
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.kdraw.russian"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.kdraw.russian"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1-prototype"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}
