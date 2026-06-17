actual class PlatformInfo actual constructor() {
    actual val osName: String = System.getProperty("os.name") ?: "Desktop"
    actual val osVersion: String = System.getProperty("os.version") ?: "Unknown"
}