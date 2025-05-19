package com.bytetrack.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged

/**
 * Class responsible for monitoring network connectivity
 */
class NetworkConnectivityManager(private val context: Context) {
    
    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    
    /**
     * Check if the device is currently connected to the internet
     */
    fun isNetworkAvailable(): Boolean {
        val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }
    
    /**
     * Check if the device has a valid internet connection
     */
    fun isInternetAvailable(): Boolean {
        val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return networkCapabilities?.let {
            it.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    it.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } ?: false
    }
    
    /**
     * Flow that emits network status changes
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    fun observeNetworkStatus(): Flow<NetworkStatus> = callbackFlow {
        trySend(getInitialNetworkStatus())
        
        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                trySend(NetworkStatus.AVAILABLE)
            }
            
            override fun onLosing(network: Network, maxMsToLive: Int) {
                trySend(NetworkStatus.LOSING)
            }
            
            override fun onLost(network: Network) {
                trySend(NetworkStatus.LOST)
            }
            
            override fun onUnavailable() {
                trySend(NetworkStatus.UNAVAILABLE)
            }
        }
        
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
        
        awaitClose {
            connectivityManager.unregisterNetworkCallback(networkCallback)
        }
    }.distinctUntilChanged()
    
    /**
     * Get the initial network status when starting to observe
     */
    private fun getInitialNetworkStatus(): NetworkStatus {
        return if (isNetworkAvailable()) {
            NetworkStatus.AVAILABLE
        } else {
            NetworkStatus.UNAVAILABLE
        }
    }
    
    companion object {
        @Volatile
        private var INSTANCE: NetworkConnectivityManager? = null
        
        fun getInstance(context: Context): NetworkConnectivityManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: NetworkConnectivityManager(context.applicationContext).also {
                    INSTANCE = it
                }
            }
        }
    }
}

/**
 * Composable function to observe the current network status
 */
@Composable
fun connectivityState(): State<NetworkStatus> {
    val context = LocalContext.current
    
    return produceState(initialValue = NetworkStatus.UNAVAILABLE) {
        NetworkConnectivityManager.getInstance(context)
            .observeNetworkStatus()
            .collect { status ->
                value = status
            }
    }
} 