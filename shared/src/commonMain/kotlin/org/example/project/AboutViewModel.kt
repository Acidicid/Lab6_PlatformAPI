package org.example.project

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AboutViewModel(private val repository: PlatformRepository) {
    private val _platformInfo = MutableStateFlow("Завантаження...")
    val platformInfo: StateFlow<String> = _platformInfo.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        // Дані постачаються через репозиторій
        _platformInfo.value = repository.getPlatformData()
    }
}