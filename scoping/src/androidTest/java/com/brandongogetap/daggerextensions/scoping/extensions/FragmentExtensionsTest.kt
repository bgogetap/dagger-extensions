package com.brandongogetap.daggerextensions.scoping.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.brandongogetap.daggerextensions.scoping.TestActivity
import com.brandongogetap.daggerextensions.scoping.TestFragment
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test

class FragmentExtensionsTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(TestActivity::class.java)

    private val componentOne = "1"
    private val componentTwo = "2"
    private val fragmentInstanceOne = TestFragment()
    private val fragmentInstanceTwo = TestFragment()

    @Test
    fun cachedComponentReturnedOnSecondInvocation() {
        activityRule.addFragment(fragmentInstanceOne)

        InstrumentationRegistry.getInstrumentation().waitForIdleSync()

        fragmentInstanceOne.getComponent { componentOne }

        // Verify initializer does not get called and cached component is used
        assertThat(fragmentInstanceOne.getComponent { componentTwo }).isEqualTo(componentOne)
    }

    @Test
    fun separateFragmentInstanceReceivesNewComponent() {
        activityRule.addFragment(fragmentInstanceOne)
        activityRule.addFragment(fragmentInstanceTwo)

        InstrumentationRegistry.getInstrumentation().waitForIdleSync()

        // Seed first ComponentViewModel
        fragmentInstanceOne.getComponent { componentOne }

        // Verify second instance has its own ComponentViewModel and does not use cached componentOne
        assertThat(fragmentInstanceTwo.getComponent { componentTwo }).isEqualTo(componentTwo)
    }
}

fun ActivityTestRule<out FragmentActivity>.addFragment(fragment: Fragment) {
    activity.runOnUiThread {
        activity.supportFragmentManager.beginTransaction()
                .add(fragment, null)
                .commitNow()

    }
}