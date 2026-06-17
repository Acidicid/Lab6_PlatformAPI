package org.example.project

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AboutViewModel(private val repository: PlatformRepository) {
    private val _platformInfo = MutableStateFlow("Завантаження...")
    val platformInfo: StateFlow<String> = _platformInfo.asStateFlow()

    private val _openCount = MutableStateFlow(0)
    val openCount: StateFlow<Int> = _openCount.asStateFlow()

    private val _lastOpenDate = MutableStateFlow("")
    val lastOpenDate: StateFlow<String> = _lastOpenDate.asStateFlow()

    init {
        // Оновлюємо лічильник і дату при кожному відкритті (ініціалізації)
        repository.incrementOpenCountAndUpdateDate()
        loadData()
    }

    private fun loadData() {
        _platformInfo.value = repository.getPlatformData()
        _openCount.value = repository.getOpenCount()
        _lastOpenDate.value = repository.getLastOpenDate()
    }
}