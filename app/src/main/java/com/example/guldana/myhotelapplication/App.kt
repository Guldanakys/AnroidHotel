package com.example.guldana.myhotelapplication

import android.support.multidex.MultiDexApplication
import com.example.guldana.myhotelapplication.di.hotelApp
import org.koin.android.ext.android.startKoin

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin(this, hotelApp)
    }

    companion object {
        @JvmStatic var instance: App? = null
            private set
    }
}