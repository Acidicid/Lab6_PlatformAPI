import android.os.Build

actual class PlatformInfo actual constructor() {
    actual val osName: String = "Android"
    actual val osVersion: String = Build.VERSION.RELEASE
}