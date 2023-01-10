import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = rootProject.group
version = rootProject.version

val jvmCompilation: org.jetbrains.kotlin.gradle.plugin.mpp.KotlinJvmCompilation.() -> Unit by rootProject.extra

kotlin {
    jvm {
        compilations.all(jvmCompilation)
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":common"))
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = rootProject.name
            packageVersion = rootProject.version.toString()
        }
    }
}
