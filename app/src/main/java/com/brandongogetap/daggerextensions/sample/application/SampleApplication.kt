package com.brandongogetap.daggerextensions.sample.application

import android.app.Application
import android.content.Context

class SampleApplication : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = inject()
    }
}

fun Context.appComponent(): ApplicationComponent {
    return (applicationContext as SampleApplication).component
}