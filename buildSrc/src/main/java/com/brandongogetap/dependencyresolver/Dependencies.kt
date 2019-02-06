package com.brandongogetap.dependencyresolver


object Versions {

    const val androidTesting = "2.0.0-rc01"
    const val androidTestRunner = "1.1.0"
    const val appCompat = "1.1.0-alpha01"
    const val conductor = "3.0.0-rc1"
    const val coroutines = "1.1.0"
    const val constraintLayout = "2.0.0-alpha3"
    const val dagger = "2.20"
    const val espresso = "3.1.0"
    const val junit = "4.12"
    const val kotlin = "1.3.11"
    const val ktx = "1.1.0-alpha03"
    const val lifecycle = "2.0.0-rc01"
    const val livedata = "2.0.0-rc01"
    const val material = "1.1.0-alpha02"
    const val mockito = "2.23.4"
    const val room = "2.1.0-alpha03"
    const val rxJava = "2.2.5"
    const val rxAndroid = "2.1.0"
    const val sqlDelight = "1.0.0"
    const val timber = "4.7.1"
    const val truth = "0.42"
    const val viewModel = "2.0.0-rc01"
}

object Dependencies {

    val androidx = AndroidX
    val conductor = Conductor
    val dagger = Dagger
    val junit = "junit:junit:${Versions.junit}"
    val kotlin = Kotlin
    val material = "com.google.android.material:material:${Versions.material}"
    val mockito = Mockito
    val room = Room
    val rx = RxJava
    val sqlDelight = SqlDelight
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val truth = "com.google.truth:truth:${Versions.truth}"
}

object AndroidX {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val constraintLayoutSolver =
            "androidx.constraintlayout:constraintlayout-solver:${Versions.constraintLayout}"

    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.ktx}"

    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    const val livedataCore = "androidx.lifecycle:lifecycle-livedata-core:${Versions.livedata}"

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.viewModel}"

    const val testingCore = "androidx.arch.core:core-testing:${Versions.androidTesting}"
    const val testRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    const val testRules = "androidx.test:rules:${Versions.androidTestRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Conductor {
    const val core = "com.bluelinelabs:conductor:${Versions.conductor}"
}

object Dagger {
    const val core = "com.google.dagger:dagger:${Versions.dagger}"
    const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}

object Kotlin {
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object Mockito {
    const val core = "org.mockito:mockito-core:${Versions.mockito}"
}

object RxJava {
    const val core = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val android = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
}

object Room {
    const val common = "androidx.room:room-common:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
    const val coroutines = "androidx.room:room-coroutines:${Versions.room}"
}

object SqlDelight {
    const val androidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
    const val paging = "com.squareup.sqldelight:android-paging-extensions:${Versions.sqlDelight}"
    const val rx = "com.squareup.sqldelight:rxjava2-extensions:${Versions.sqlDelight}"
}