package com.gauvain.seigneur.goqo.domain.injection
import com.gauvain.seigneur.goqo.domain.usecase.GetRandomUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetRandomUsersUseCase.create(get()) }
}