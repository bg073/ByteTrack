package com.bytetrack

import android.app.Application
import android.util.Log
import com.bytetrack.utils.NetworkConnectivityManager

class ByteTrackApplication : Application() {
    
    // Lazy initialized network connectivity manager
    val networkConnectivityManager by lazy {
        NetworkConnectivityManager.getInstance(this)
    }
    
    companion object {
        private const val TAG = "ByteTrackApplication"
        lateinit var instance: ByteTrackApplication
            private set
    }
    
    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.d(TAG, "ByteTrack application started")
        
        // Initialize the network connectivity manager
        networkConnectivityManager
    }
} 