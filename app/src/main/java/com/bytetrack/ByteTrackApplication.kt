package com.bytetrack

import android.app.Application
import android.util.Log

class ByteTrackApplication : Application() {
    
    companion object {
        private const val TAG = "ByteTrackApplication"
        lateinit var instance: ByteTrackApplication
            private set
    }
    
    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.d(TAG, "ByteTrack application started")
        
        // Initialize components here
    }
} 