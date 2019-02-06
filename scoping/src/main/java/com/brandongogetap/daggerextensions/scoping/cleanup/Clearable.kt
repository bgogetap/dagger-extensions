package com.brandongogetap.daggerextensions.scoping.cleanup

/**
 * Interface to implement for objects that require a callback when the Component they're associated
 * with go out of scope.
 */
interface Clearable {

    /**
     * Called when this object will go out of scope.
     *
     * Any cleanups should be performed here.
     */
    fun onCleared()
}