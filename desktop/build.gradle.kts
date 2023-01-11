import byucp.CompileConfig
import byucp.ProjectConfig
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = rootProject.group
version = rootProject.version

kotlin {
    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = CompileConfig.jvmTarget
            }
        }
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
            packageVersion = ProjectConfig.version
        }
    }
}
