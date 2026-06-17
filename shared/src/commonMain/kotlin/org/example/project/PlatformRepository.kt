package org.example.project

import PlatformInfo

// Інтерфейс репозиторію
interface PlatformRepository {
    fun getPlatformData(): String
}

// Реалізація репозиторію
class PlatformRepositoryImpl(private val platformInfo: PlatformInfo) : PlatformRepository {
    override fun getPlatformData(): String = "${platformInfo.osName} ${platformInfo.osVersion}"
}