package com.brandongogetap.daggerextensions.scoping.extensions

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import com.brandongogetap.daggerextensions.scoping.TestActivity
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test

class ActivityExtensionsTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(TestActivity::class.java)

    @Rule
    @JvmField
    var secondActivityRule = ActivityTestRule(
            TestActivity::class.java,
            false /* initialTouchMode */,
            false /* launchActivity */)

    private val componentOne = "1"
    private val componentTwo = "2"

    @Test
    fun cachedComponentReturnedOnSecondInvocation() {
        activityRule.activity.getComponent { componentOne }

        // Have initializer return a different object for the Component. This initializer should not
        // be used
        val secondInvocation = activityRule.activity.getComponent { componentTwo }

        assertThat(secondInvocation).isEqualTo(componentOne)
    }

    @Test
    fun separateActivityInstanceReceivesNewComponent() {
        activityRule.activity.getComponent { componentOne }

        secondActivityRule.launchActivity(Intent())
        assertThat(secondActivityRule.activity.getComponent { componentTwo })
                .isEqualTo(componentTwo)
    }
}