plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(projects.features.detail.data)
    implementation(projects.common.domain)
    implementation(projects.common.utils)
    implementation(projects.network)
    implementation(libs.javax.inject)
}