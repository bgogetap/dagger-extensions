package com.brandongogetap.daggerextensions.scoping.helpers

import com.brandongogetap.daggerextensions.scoping.cleanup.Clearable
import com.brandongogetap.daggerextensions.scoping.cleanup.ClearableComponent
import org.junit.Test
import org.mockito.Mockito.*

class ComponentViewModelTest {

    @Test
    fun onClearedCalledOnClearables() {
        val component = mock(ClearableComponent::class.java)
        val clearable = mock(Clearable::class.java)
        `when`(component.provideClearableObjects()).thenReturn(setOf(clearable))
        val viewModel = ComponentViewModel()
        viewModel.component = component

        viewModel.callOnCleared()

        verify(clearable).onCleared()
    }
}