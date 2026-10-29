import org.apache.tools.ant.taskdefs.condition.Os
import java.io.FileInputStream
import java.util.Properties

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

private fun ndkPathBuilder(): String {
    var path: String? = android.ndkPath
    if (path.isNullOrEmpty())
        path = System.getenv("ANDROID_NDK_HOME") ?: System.getenv("NDK_HOME")

    if (path.isNullOrEmpty()) {
        val properties = Properties().apply {
            val file = project.rootProject.file("local.properties")
            if (file.exists()) {
                load(FileInputStream(file))
            }
        }
        path = properties.getProperty("ndk.dir")
    }

    if (path.isNullOrEmpty())
        path
            ?: throw GradleException("NDK path not found! Set 'android.ndkPath' in build.gradle.kts or ANDROID_NDK_HOME in your environment.")

    return if (Os.isFamily(Os.FAMILY_WINDOWS)) {
        "$path/ndk-build.cmd"
    } else {
        "$path/ndk-build"
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

tasks.withType<JavaCompile>().configureEach {
    dependsOn("ndkBuild")
}

dependencies {
    implementation(files("libs/common-4.1.1.aar"))
    implementation(libs.support.v4)
    implementation(libs.support.annotations)
    implementation(libs.androidx.app.compat)
}