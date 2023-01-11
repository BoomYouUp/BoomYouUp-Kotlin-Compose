package byucp

import org.gradle.api.JavaVersion

object AndroidConfig {
    const val appId = "${ProjectConfig.group}.android"
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33
}

object ProjectConfig {
    const val group = "xyz.xfqlittlefan.byucp"
    const val version = "1.0.0"
    const val versionSuffix = "-alpha01"
    const val versionCode = 1
}

object CompileConfig {
    const val jvmTarget = "11"
    val compatibility = JavaVersion.VERSION_11
}