package org.example.project

import PlatformInfo
import com.russhwolf.settings.Settings
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single { PlatformInfo() }

    // Додаємо створення Settings
    single<Settings> { Settings() }

    // Додаємо get() для Settings у репозиторій
    single<PlatformRepository> { PlatformRepositoryImpl(get(), get()) }
    factory { AboutViewModel(get()) }
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}