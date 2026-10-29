plugins {
    alias(libs.plugins.android.application)
}

android {
    val compileSDK: Int = providers.gradleProperty("compilesdk").get().toInt()
    namespace = "com.serenegiant.usbcameratest"
    compileSdk = compileSDK

    defaultConfig {
        applicationId = "com.serenegiant.usbcameratest"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies{
    implementation(libs.support.v4)
    implementation(libs.support.annotations)
    implementation(libs.androidx.app.compat)
    implementation(files("libs/common-4.1.1.aar"))
    implementation(project(":libuvccamera"))
}