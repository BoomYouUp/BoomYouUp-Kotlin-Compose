plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group = rootProject.group
version = rootProject.version

dependencies {
    implementation(project(":common"))
}

val versionCode: Int by rootProject.extra
val androidCompileSdk: Int by rootProject.extra
val androidMinSdk: Int by rootProject.extra
val androidTargetSdk: Int by rootProject.extra
val androidCompileOptions: com.android.build.api.dsl.CompileOptions.() -> Unit by rootProject.extra

android {
    compileSdk = androidCompileSdk
    defaultConfig {
        applicationId = "${rootProject.group}.android"
        minSdk = androidMinSdk
        targetSdk = androidTargetSdk
        versionCode = versionCode
        versionName = rootProject.version.toString()
    }
    compileOptions(androidCompileOptions)
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}