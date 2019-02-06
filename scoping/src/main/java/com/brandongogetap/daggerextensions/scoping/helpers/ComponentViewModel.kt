package com.brandongogetap.daggerextensions.scoping.helpers

import androidx.lifecycle.ViewModel
import com.brandongogetap.daggerextensions.scoping.cleanup.Clearable
import com.brandongogetap.daggerextensions.scoping.cleanup.ClearableComponent

/**
 * Simple [ViewModel] that allows Components to be reused across configuration changes.
 *
 * If the Component implements [ClearableComponent], all [Clearable] dependencies will have their
 * [Clearable.onCleared] function called when this Component goes out of scope.
 */
internal class ComponentViewModel : ViewModel() {

    var component: Any? = null

    override fun onCleared() {
        (component as? ClearableComponent)?.let { component ->
            component.provideClearableObjects().forEach { it.onCleared() }
        }
    }

    fun callOnCleared() {
        onCleared()
    }
}