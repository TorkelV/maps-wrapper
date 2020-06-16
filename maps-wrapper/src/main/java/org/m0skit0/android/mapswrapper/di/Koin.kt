package org.m0skit0.android.mapswrapper.di

import org.koin.core.Koin
import org.koin.core.KoinApplication

private val modules = listOf(
    ApiAvailabilityModuleProvider,
    CallbackModuleProvider,
    MapModuleProvider,
    GoogleModelsModuleProvider,
    HuaweiModelsModuleProvider,
    WrapperModelsModuleProvider
)

private val koinContext: KoinApplication by lazy {
    KoinApplication.init().apply {
        modules(modules.map { it.module() })
    }
}

internal fun koin(): Koin = koinContext.koin
