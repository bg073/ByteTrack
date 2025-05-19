package com.bytetrack.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * A sealed class that encapsulates successful and failed API responses
 */
sealed class NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Error(val exception: Throwable, val message: String = exception.localizedMessage ?: "Unknown error") : NetworkResult<Nothing>()
    data object Loading : NetworkResult<Nothing>()
    
    fun isSuccess(): Boolean = this is Success
    fun isError(): Boolean = this is Error
    fun isLoading(): Boolean = this is Loading
    
    fun onSuccess(action: (T) -> Unit): NetworkResult<T> {
        if (this is Success) {
            action(data)
        }
        return this
    }
    
    fun onError(action: (Throwable, String) -> Unit): NetworkResult<T> {
        if (this is Error) {
            action(exception, message)
        }
        return this
    }
    
    fun onLoading(action: () -> Unit): NetworkResult<T> {
        if (this is Loading) {
            action()
        }
        return this
    }
}

/**
 * A function that handles API calls and wraps them in NetworkResult
 */
suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
    return withContext(Dispatchers.IO) {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    NetworkResult.Success(body)
                } else {
                    NetworkResult.Error(RuntimeException("Response body is null"))
                }
            } else {
                val errorMessage = response.errorBody()?.string() ?: "Unknown error occurred"
                NetworkResult.Error(RuntimeException(errorMessage))
            }
        } catch (e: SocketTimeoutException) {
            NetworkResult.Error(e, "Connection timed out")
        } catch (e: IOException) {
            NetworkResult.Error(e, "Network error: No internet connection")
        } catch (e: Exception) {
            NetworkResult.Error(e)
        }
    }
}

/**
 * Extension function to handle network results in a clean way
 */
suspend fun <T, R> NetworkResult<T>.handle(
    onSuccess: suspend (T) -> R,
    onError: suspend (Throwable, String) -> R,
    onLoading: suspend () -> R
): R {
    return when (this) {
        is NetworkResult.Success -> onSuccess(data)
        is NetworkResult.Error -> onError(exception, message)
        is NetworkResult.Loading -> onLoading()
    }
}

/**
 * Network connectivity status
 */
enum class NetworkStatus {
    AVAILABLE,
    UNAVAILABLE,
    LOSING,
    LOST
} 