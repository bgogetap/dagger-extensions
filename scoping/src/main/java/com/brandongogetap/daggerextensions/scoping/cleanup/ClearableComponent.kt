package com.brandongogetap.daggerextensions.scoping.cleanup

import dagger.multibindings.Multibinds

/**
 * Provides [Clearable] dependencies which will have [Clearable.onCleared] called when this Component
 * goes out of scope.
 */
interface ClearableComponent {

    @Multibinds
    fun provideClearableObjects(): @JvmSuppressWildcards Set<Clearable>
}