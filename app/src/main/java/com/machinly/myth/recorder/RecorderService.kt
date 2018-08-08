package com.machinly.myth.recorder

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.io.FileDescriptor
import java.io.PrintWriter

class RecorderService : Service() {
    companion object {
        var TAG = "recorder"
    }

    var count = 0

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        count = count.plus(1)
        Log.d(TAG, "onCreate() executed $count")
    }

    override fun onRebind(intent: Intent) {
        super.onRebind(intent)
        Log.d(TAG, "onRebind() executed")
    }

    override fun dump(fd: FileDescriptor, writer: PrintWriter, args: Array<out String>) {
        super.dump(fd, writer, args)
        Log.d(TAG, "dump() executed")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        count = count.plus(1)
        Log.d(TAG, "onStartCommand() executed $count")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onLowMemory() {
        Log.d(TAG, "onLowMemory() executed")
        super.onLowMemory()
    }

    override fun onTaskRemoved(rootIntent: Intent) {
        Log.d(TAG, "onLowMemory() executed")
        super.onTaskRemoved(rootIntent)
    }

    override fun onTrimMemory(level: Int) {
        Log.d(TAG, "onTrimMemory() executed")
        super.onTrimMemory(level)
    }

    override fun onUnbind(intent: Intent): Boolean {
        Log.d(TAG, "onUnbind() executed")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy() executed")
        super.onDestroy()
    }
}