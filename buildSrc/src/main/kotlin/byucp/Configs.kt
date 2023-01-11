package byucp

import org.gradle.api.JavaVersion

object ProjectConfig {
    const val group = "xyz.xfqlittlefan.byucp"
    const val version = "1.0.0"
    const val versionSuffix = "-alpha01"
    const val versionCode = 1
    const val description = "使用 Kotlin 编写的 BoomYouUp 客户端"
    const val vendor = "LTFan"
}

object AndroidConfig {
    const val appId = "${ProjectConfig.group}.android"
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33
}

object CompileConfig {
    const val jvmTarget = "11"
    val compatibility = JavaVersion.VERSION_11
}