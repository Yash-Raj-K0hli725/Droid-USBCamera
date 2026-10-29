plugins {
    id("com.android.library")
}

android {
    val compileSDK: Int = providers.gradleProperty("compilesdk").get().toInt()
    namespace = "com.serenegiant.usbcameracommon"
    compileSdk = compileSDK

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies{
    implementation(files("libs/common-4.1.1.aar"))
    implementation(libs.support.v4)
    implementation(libs.support.annotations)
}