package com.mostafa.nasaimage.cycles.home_cycle.fragment.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.mostafa.nasaimage.R
import com.mostafa.nasaimage.TestAppFragmentFactory
import com.mostafa.nasaimage.cycles.home_cycle.activity.HomeActivity
import com.mostafa.nasaimage.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class HomeFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var activityRule: ActivityTestRule<HomeActivity> = ActivityTestRule(HomeActivity::class.java)

    @Inject
    @Named("TestFragmentFactory")
    lateinit var testFragmentFactory: TestAppFragmentFactory

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun when_click_on_item_in_recycler_view_then_detail_fragment_display() {
        launchFragmentInHiltContainer<HomeFragment> {

        }

    }
}