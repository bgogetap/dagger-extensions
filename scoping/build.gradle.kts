import com.brandongogetap.dependencyresolver.AppVersions
import com.brandongogetap.dependencyresolver.Dependencies

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdkVersion(AppVersions.compileSdk)

    defaultConfig {
        minSdkVersion(AppVersions.minSdk)
        targetSdkVersion(AppVersions.targetSdk)
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
    implementation(Dependencies.androidx.appCompat)
    implementation(Dependencies.androidx.lifecycle)
    implementation(Dependencies.androidx.livedataCore)
    implementation(Dependencies.androidx.viewModel)

    implementation(Dependencies.dagger.core)

    implementation(Dependencies.kotlin.stdlib)
}

dependencies {
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.truth)
    testImplementation(Dependencies.mockito.core)
}

dependencies {
    androidTestImplementation(Dependencies.androidx.testRunner)
    androidTestImplementation(Dependencies.androidx.testRules)
    androidTestImplementation(Dependencies.androidx.testingCore)

    androidTestImplementation(Dependencies.truth)
}