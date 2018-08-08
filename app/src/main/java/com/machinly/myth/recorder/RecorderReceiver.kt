package com.machinly.myth.recorder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class RecorderReceiver : BroadcastReceiver() {
    val mService: RecorderService? = null
    override fun onReceive(context: Context, intent: Intent) {
        val action: String = intent.action
        Toast.makeText(context, "action:$action", Toast.LENGTH_LONG).show()
        Log.i("TestBroadcastReceiver", "action:$action");
        if ("android.intent.action.USER_PRESENT" == action || "com.machinly.myth.WAKEUP_RECORDER" == action) {
            val sintent = Intent(context, RecorderService::class.java)
            context.startService(sintent)
        }
    }
}