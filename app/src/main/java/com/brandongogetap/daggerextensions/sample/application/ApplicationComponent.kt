package com.brandongogetap.daggerextensions.sample.application

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

    fun inject(application: SampleApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindAppContext(application: Context): Builder

        fun build(): ApplicationComponent
    }
}

fun SampleApplication.inject(): ApplicationComponent {
    val component = DaggerApplicationComponent.builder()
            .bindAppContext(this)
            .build()
    component.inject(this)
    return component
}