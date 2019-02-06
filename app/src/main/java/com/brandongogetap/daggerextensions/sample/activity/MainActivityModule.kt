package com.brandongogetap.daggerextensions.sample.activity

import com.brandongogetap.daggerextensions.sample.counter.Counter
import com.brandongogetap.daggerextensions.sample.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
object MainActivityModule {

    @Provides
    @ActivityScope
    @JvmStatic
    fun provideCounter() = Counter()
}