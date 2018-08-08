package com.machinly.myth.recorder.aidl

import java.io.OutputStream

interface IConnectClientInterface {

    fun startRecord(): Boolean
    fun stopRecord(): Boolean
    fun getOS(): OutputStream
}