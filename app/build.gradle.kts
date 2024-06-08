plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "com.emreozcan.rickandmorty"


    defaultConfig {
        applicationId = "com.emreozcan.rickandmorty"
        versionCode = 1
        versionName = "1.0"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "NETWORK_HOST", "\"rickandmortyapi.com/api\"")
        }
        debug {
            buildConfigField("String", "NETWORK_HOST", "\"rickandmortyapi.com/api\"")
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(projects.theme)
    implementation(projects.network)
    implementation(projects.features.home)
    implementation(projects.features.home.data)
    implementation(projects.features.detail)
    implementation(projects.features.detail.data)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.material3)

    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.hilt.compose.navigation)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    implementation(libs.ktor.client.core)

    implementation(libs.timber)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}