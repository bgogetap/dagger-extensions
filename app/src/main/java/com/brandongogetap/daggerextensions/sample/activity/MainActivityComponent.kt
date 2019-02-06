package com.brandongogetap.daggerextensions.sample.activity

import com.brandongogetap.daggerextensions.sample.application.ApplicationComponent
import com.brandongogetap.daggerextensions.sample.application.appComponent
import com.brandongogetap.daggerextensions.sample.scopes.ActivityScope
import com.brandongogetap.daggerextensions.scoping.extensions.getComponent
import dagger.Component

@ActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        fun appComponent(applicationComponent: ApplicationComponent): Builder

        fun build(): MainActivityComponent
    }
}

fun MainActivity.inject() {
    getComponent {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent())
                .build()
    }.inject(this)
}