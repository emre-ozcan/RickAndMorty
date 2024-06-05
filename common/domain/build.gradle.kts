plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
}


dependencies {
    implementation(projects.network)
}
