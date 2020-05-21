package com.gauvain.seigneur.goqo

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.SvgDecoder
import coil.util.CoilUtils
import com.gauvain.seigneur.goqo.dataAdapter.injection.adapterModule
import com.gauvain.seigneur.goqo.dataAdapter.injection.remoteDataSourceModule
import com.gauvain.seigneur.goqo.domain.injection.useCaseModule
import com.gauvain.seigneur.goqo.presentation.injection.viewModelModule
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GoQoApplication : Application(), ImageLoaderFactory {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GoQoApplication)
            androidFileProperties()
            modules(
                listOf(
                    remoteDataSourceModule,
                    adapterModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }


    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this@GoQoApplication).apply {
            componentRegistry {
                add(SvgDecoder(this@GoQoApplication))
            }
        }
            .crossfade(true)
            .okHttpClient {
                OkHttpClient.Builder()
                    .cache(CoilUtils.createDefaultCache(this@GoQoApplication))
                    .build()
            }
            .build()
    }
}