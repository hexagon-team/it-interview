/*
*TODO remove suppress when this issue will be solved
*  https://youtrack.jetbrains.com/issue/KTIJ-19369
*/
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("multiplatform")
    alias { libs.plugins.ksp }
    id("com.android.library")
    id("com.squareup.sqldelight")
    // TODO: uncommented when created google-services.json
//    id("com.google.gms.google-services")
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    sourceSets {
        /**
         * Common
         * */
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.bundles.ktor)
                implementation(libs.sqldelight.runtime)
                api(libs.kotlinx.coroutines.core)
                api(libs.napier.logger)
            }
        }

        val commonTest by getting {
            dependencies {
                dependsOn(commonMain)
            }
        }

        /**
         * Android
         * */
        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.okhttp)
                implementation(libs.koin.android)
                implementation(libs.koin.core)
                implementation(libs.kotlinx.coroutines.android)
                implementation(libs.sqldelight.android)
                implementation(libs.firebase.bom)
                implementation(libs.firebase.analytics)
            }
        }
        val androidTest by getting

        /**
         * IOS
         * */
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(libs.ktor.client.ios)
                implementation(libs.sqldelight.ios)
            }
        }

        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 28
        targetSdk = 32
    }
}

sqldelight {
    database("ItInterviewDatabase") {
        packageName = "com.hexagonteam.itinterview"
        sourceFolders = listOf("database")
    }
}

dependencies {
    testImplementation(libs.koin.test)
    testImplementation(libs.bundles.kotest)
    testImplementation(libs.junit5)
    testImplementation(libs.testing)
}