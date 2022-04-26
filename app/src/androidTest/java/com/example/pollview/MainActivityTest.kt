package com.example.pollview

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import junit.framework.TestCase
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest : TestCase(){
    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
     fun setup()
    {
        scenario= ActivityScenario.launch(MainActivity::class.java)

        scenario.moveToState(Lifecycle.State.RESUMED)
    }
    @Test
    fun testPoll()
    {
       Espresso.onView(withId(R.id.set)).perform(click())

               Espresso.onView(withText("php"))
                   .perform(click())
        Espresso.onView(withText("34%")).check(matches(isDisplayed()))

    }

}