package org.example.project

import PlatformInfo
import org.koin.core.context.startKoin
import org.koin.dsl.module

// Граф залежностей
val appModule = module {
    single { PlatformInfo() } // Створюємо PlatformInfo в єдиному екземплярі
    single<PlatformRepository> { PlatformRepositoryImpl(get()) } // Передаємо PlatformInfo в репозиторій
    factory { AboutViewModel(get()) } // Передаємо репозиторій у ViewModel
}

// Загальна функція для ініціалізації
fun initKoin() {
    startKoin {
        modules(appModule)
    }
}