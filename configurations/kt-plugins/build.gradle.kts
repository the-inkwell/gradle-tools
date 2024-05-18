plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(ktPluginsLibs.kotlin.gradlePlugin)
}
