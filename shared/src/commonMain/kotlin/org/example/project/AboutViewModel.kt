package org.example.project

import PlatformInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AboutViewModel {
    // Внутрішній змінний стан
    private val _platformInfo = MutableStateFlow("Завантаження...")

    // Публічний незмінний стан, який буде "слухати" UI
    val platformInfo: StateFlow<String> = _platformInfo.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        // Переносимо постачання даних з UI частини сюди
        val platform = PlatformInfo()
        _platformInfo.value = "${platform.osName} ${platform.osVersion}"
    }
}