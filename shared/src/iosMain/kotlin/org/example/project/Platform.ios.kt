import platform.UIKit.UIDevice

actual class PlatformInfo actual constructor() {
    actual val osName: String = UIDevice.currentDevice.systemName()
    actual val osVersion: String = UIDevice.currentDevice.systemVersion
}