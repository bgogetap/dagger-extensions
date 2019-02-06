import com.brandongogetap.dependencyresolver.Dependencies
import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig


plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}
android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.brandongogetap.daggerextensions.sample"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":scoping"))

    implementation(Dependencies.androidx.appCompat)
    implementation(Dependencies.androidx.constraintLayout)

    implementation(Dependencies.dagger.core)
    kapt(Dependencies.dagger.compiler)

    implementation(Dependencies.kotlin.stdlib)
}

dependencies {
    testImplementation(Dependencies.junit)
}

dependencies {
    androidTestImplementation(Dependencies.androidx.testRunner)
    androidTestImplementation(Dependencies.androidx.testRules)
    androidTestImplementation(Dependencies.androidx.testingCore)
    androidTestImplementation(Dependencies.androidx.espressoCore)
}
