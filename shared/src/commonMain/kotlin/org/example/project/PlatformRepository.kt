@file:Suppress("DEPRECATION")

package org.example.project

import PlatformInfo
import com.russhwolf.settings.Settings
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

interface PlatformRepository {
    fun getPlatformData(): String
    fun getOpenCount(): Int
    fun getLastOpenDate(): String
    fun incrementOpenCountAndUpdateDate()
}

class PlatformRepositoryImpl(
    private val platformInfo: PlatformInfo,
    private val settings: Settings // Додали Settings
) : PlatformRepository {

    private val COUNT_KEY = "open_count"
    private val DATE_KEY = "last_open_date"

    override fun getPlatformData(): String = "${platformInfo.osName} ${platformInfo.osVersion}"

    override fun getOpenCount(): Int {
        return settings.getInt(COUNT_KEY, 0)
    }

    override fun getLastOpenDate(): String {
        return settings.getString(DATE_KEY, "Ще не відкривалось")
    }

    override fun incrementOpenCountAndUpdateDate() {
        // Збільшуємо лічильник
        val currentCount = getOpenCount()
        settings.putInt(COUNT_KEY, currentCount + 1)

        // Зберігаємо поточний час
        val now = kotlinx.datetime.Clock.System.now().toLocalDateTime(kotlinx.datetime.TimeZone.currentSystemDefault())
        // Форматуємо дату (наприклад: 2026-06-17 06:15)
        val dateString = "${now.date} ${now.hour}:${now.minute.toString().padStart(2, '0')}"
        settings.putString(DATE_KEY, dateString)
    }
}