import com.android.build.api.dsl.CompileOptions
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinJvmCompilation

/**
 * ```
 * val jvmCompilation: org.jetbrains.kotlin.gradle.plugin.mpp.KotlinJvmCompilation.() -> Unit by rootProject.extra
 * ```
 */
val jvmCompilation by extra(fun KotlinJvmCompilation.() {
    kotlinOptions.jvmTarget = "11"
})

val androidCompileSdk by extra(33)
val androidMinSdk by extra(24)
val androidTargetSdk by extra(33)

/**
 * ```kotlin
 * val androidCompileOptions: com.android.build.api.dsl.CompileOptions.() -> Unit by rootProject.extra
 * ```
 */
val androidCompileOptions by extra(fun CompileOptions.() {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
})

group = "xyz.xfqlittlefan.byucp"
version = "1.0.0"
val versionCode by extra(1)

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

plugins {
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.compose") apply false
}
