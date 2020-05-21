package com.gauvain.seigneur.goqo.dataAdapter.injection

import com.gauvain.seigneur.goqo.dataAdapter.adapter.GetRandomUsersAdapter
import com.gauvain.seigneur.goqo.domain.provider.GetRandomUsersProvider
import org.koin.dsl.module

val adapterModule = module {
    single<GetRandomUsersProvider> {
        GetRandomUsersAdapter(get())
    }
}