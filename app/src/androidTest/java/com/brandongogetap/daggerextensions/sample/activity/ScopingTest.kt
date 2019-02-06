package com.brandongogetap.daggerextensions.sample.activity


import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.brandongogetap.daggerextensions.sample.R
import org.junit.Rule
import org.junit.Test

class ScopingTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun orientationChange() {
        onView(withId(R.id.btn_increment)).perform(click())

        activityRule.rotate()

        onView(withId(R.id.tv_count)).check(matches(withText("1")))
    }

    @Test
    fun activityRecreate() {
        onView(withId(R.id.btn_increment)).perform(click())

        activityRule.recreateActivity()

        onView(withId(R.id.tv_count)).check(matches(withText("1")))
    }

    //TODO Add tests for Fragments once they are part of sample
}

fun ActivityTestRule<*>.rotate() {
    val currentOrientation = activity.requestedOrientation
    activity.requestedOrientation = if (currentOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT else ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
}

fun ActivityTestRule<*>.recreateActivity() {
    activity.runOnUiThread { activity.recreate() }
}
