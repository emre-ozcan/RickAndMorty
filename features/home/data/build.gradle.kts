plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
    id(libs.plugins.kotlin.serialization.get().pluginId)
}

dependencies {
    implementation(projects.network)
    implementation(libs.ktor.serialization)
    implementation(libs.javax.inject)

    testImplementation(libs.junit)
    testImplementation(libs.ktor.client.content.negotiation)
    testImplementation(libs.ktor.client.mock)
    testImplementation(libs.ktor.serialization)
    testImplementation(libs.google.truth)
}