package com.gauvain.seigneur.goqo.presentation.injection

import com.gauvain.seigneur.goqo.presentation.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}