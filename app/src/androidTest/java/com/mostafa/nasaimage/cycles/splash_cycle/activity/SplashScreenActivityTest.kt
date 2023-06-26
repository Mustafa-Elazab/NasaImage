package com.mostafa.nasaimage.cycles.splash_cycle.activity

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mostafa.nasaimage.cycles.home_cycle.activity.HomeActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.mostafa.nasaimage.R


@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class SplashScreenActivityTest {


    @get: Rule()
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val splashScreenRule: IntentsTestRule<SplashScreenActivity> = IntentsTestRule(SplashScreenActivity::class.java)

    @Before
    fun setup() {
        hiltRule.inject()
    }


    @Test
    fun move_to_home_activity_with_delay_then_return_home_activity_displayed() {
        Thread.sleep(2000) // Wait for the delay and navigation to occur

        // Verify that the HomeActivity is displayed
       // intended(hasComponent(HomeActivity::class.java.name))
                Espresso.onView(ViewMatchers.withId(R.id.activity_home_screen))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }



}