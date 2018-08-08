package com.machinly.myth

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.machinly.myth.recorder.RecorderService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mRecorderSatus: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wakeup()
        initView()
    }

    private fun wakeup() {
        val intent = Intent()
        intent.action = "com.machinly.myth.WAKEUP_RECORDER"
        sendBroadcast(intent)
    }

    private fun initView() {
        setRecorderCtlBtn()
        recordCtlBtn.setOnClickListener { recorderTrigger() }
    }

    private fun setRecorderCtlBtn() {
        recordCtlBtn.setText(if (mRecorderSatus) R.string.recorder_stop else R.string.recorder_start)
    }

    private fun recorderTrigger() {
        mRecorderSatus = !mRecorderSatus
        val intent = Intent()
        if (mRecorderSatus) {
            intent.action = "com.machinly.myth.START_RECORDER"
        } else {
            intent.action = "com.machinly.myth.STOP_RECORDER"
        }
        sendBroadcast(intent)
        setRecorderCtlBtn()
    }


}

