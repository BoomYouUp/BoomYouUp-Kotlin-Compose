import byucp.AndroidConfig
import byucp.CompileConfig
import byucp.ProjectConfig
import java.util.Properties

plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group = rootProject.group
version = rootProject.group

dependencies {
    implementation(project(":common"))
}

val keyProperties = Properties().apply {
    file("key.properties").inputStream().use {
        load(it)
    }
}

android {
    namespace = AndroidConfig.appId
    compileSdk = AndroidConfig.compileSdk

    signingConfigs {
        create("release") {
            keyAlias = keyProperties["keyAlias"] as String
            keyPassword = keyProperties["keyPassword"] as String
            storeFile = file("key.jks")
            storePassword = keyProperties["storePassword"] as String
        }
    }

    defaultConfig {
        applicationId = AndroidConfig.appId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.version + ProjectConfig.versionSuffix
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions {
        jvmTarget = CompileConfig.jvmTarget
    }
    compileOptions {
        sourceCompatibility = CompileConfig.compatibility
        targetCompatibility = CompileConfig.compatibility
    }
}