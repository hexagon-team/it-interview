pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "ITInterview"
include(":androidApp")
include(":shared")

enableFeaturePreview("VERSION_CATALOGS")