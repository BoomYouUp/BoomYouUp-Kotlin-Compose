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
            description = ProjectConfig.description
            vendor = ProjectConfig.vendor
            licenseFile.set(rootProject.file("LICENSE"))

            linux {
                packageName = "boom-you-up-cp"
                debMaintainer = "xfqwdsj@qq.com"
                appRelease = ProjectConfig.versionCode.toString()
                debPackageVersion = ProjectConfig.version + ProjectConfig.versionSuffix
                rpmPackageVersion = ProjectConfig.version + ProjectConfig.versionSuffix.replace('-', '+')
            }

            macOS {
                bundleID = "${ProjectConfig.group}.desktop"
                packageBuildVersion = ProjectConfig.versionCode.toString()
            }

            windows {
                perUserInstall = true
                menuGroup = rootProject.name
                upgradeUuid = "2c0a65b2-f6fa-46c0-8c83-24fba18a08fe"
            }
        }
    }
}
