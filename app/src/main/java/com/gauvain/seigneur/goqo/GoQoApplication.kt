package com.gauvain.seigneur.goqo

import android.app.Application
import com.gauvain.seigneur.goqo.dataAdapter.injection.remoteDataSourceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GoQoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GoQoApplication)
            androidFileProperties()
            modules(
                listOf(
                    remoteDataSourceModule
                )
            )
        }
    }
}