import byucp.AndroidConfig
import byucp.CompileConfig
import byucp.ProjectConfig

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
}

group = rootProject.group
version = rootProject.group

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = CompileConfig.jvmTarget
            }
        }
    }
    jvm("desktop") {
        compilations.all {
            kotlinOptions {
                jvmTarget = CompileConfig.jvmTarget
            }
        }
    }
    js(IR) {
        browser()
    }
    sourceSets {
        val commonMain by getting {
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class) dependencies {
                api(compose.animation)
                api(compose.animationGraphics)
                api(compose.foundation)
                api(compose.material3)
//                api(compose.materialIconsExtended)
                api(compose.runtime)
                api(compose.ui)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                val androidxCoreVersion = "1.9.0"
                val appCompatVersion = "1.7.0-alpha01"
                val activityVersion = "1.7.0-alpha02"
//                val lifecycleVersion = "2.6.0-alpha03"
//                val coroutinesVersion = "1.6.4"
                val accompanistVersion = "0.28.0"

                api("androidx.core:core-ktx:$androidxCoreVersion")
                api("androidx.appcompat:appcompat:$appCompatVersion")
                api("androidx.activity:activity-compose:$activityVersion")
//                api("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
//                api("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion")
//                api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
                api("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.desktop.currentOs)
            }
        }
        val desktopTest by getting
        val jsMain by getting {
            dependencies {
                api(compose.web.core)
            }
        }
        val jsTest by getting
    }
}

android {
    namespace = "${ProjectConfig.group}.common"
    compileSdk = AndroidConfig.compileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
    }

    compileOptions {
        sourceCompatibility = CompileConfig.compatibility
        targetCompatibility = CompileConfig.compatibility
    }
}