package com.brandongogetap.daggerextensions.scoping.extensions

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.brandongogetap.daggerextensions.scoping.helpers.ComponentViewModel

/**
 * Creates and returns a component, as defined by [componentInitializer].
 *
 * If an existing Component for this Activity exists, that instance is returned instead.
 *
 * Once an Activity goes out of scope, the existing Component will be released.
 */
@Suppress("UNCHECKED_CAST")
fun <T : Any> FragmentActivity.getComponent(componentInitializer: () -> T): T {
    val viewModel = ViewModelProviders.of(this).get(ComponentViewModel::class.java)
    if (viewModel.component == null) {
        viewModel.component = componentInitializer()
    }
    return viewModel.component as T
}

/**
 * Retrieves the Component for this Fragment's scope.
 *
 * This can only be called after [getComponent] has been called.
 *
 * This can be useful to inject child Fragments or Views (that don't have their own Component).
 */
fun <T : Any> FragmentActivity.getCachedComponent(): T {
    val viewModel = ViewModelProviders.of(this).get(ComponentViewModel::class.java)
    @Suppress("UNCHECKED_CAST")
    return viewModel.component as? T
            ?: throw IllegalStateException("Cannot call getCachedComponent before the Component has been initialized via getComponent")
}