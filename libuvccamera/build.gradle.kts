import org.apache.tools.ant.taskdefs.condition.Os

plugins {
    id("com.android.library")
}
val ndk: String by project
android {
    val compileSDK: Int = providers.gradleProperty("compilesdk").get().toInt()
    namespace = "com.serenegiant.uvccamera"
    compileSdk = compileSDK

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    externalNativeBuild {
        ndkBuild {
            path(file("src/main/jni/Android.mk"))
        }
    }

    ndkVersion = ndk
}

private fun ndkPathBuilder():String {
    val ndkpath: String by project
    println("yash path is :" +android.ndkPath)
    return if(Os.isFamily(Os.FAMILY_WINDOWS)){
        "$ndkpath/ndk-build.cmd"
    }else {
        "$ndkpath/ndk-build"
    }
}

tasks.register<Exec>("ndkBuild") {
    println("executing ndkBuild")
    commandLine(ndkPathBuilder(), "-j8", "-C", file("src/main").absolutePath)
}

tasks.register<Exec>("ndkClean") {
    println("executing ndkBuild clean")
    commandLine(ndkPathBuilder(), "clean", "-C", file("src/main").absolutePath)
}

tasks.withType<JavaCompile>().configureEach{
    dependsOn("ndkBuild")
}

dependencies{
    implementation(files("libs/common-4.1.1.aar"))
    implementation(libs.support.v4)
    implementation(libs.support.annotations)
    implementation(libs.androidx.app.compat)
}