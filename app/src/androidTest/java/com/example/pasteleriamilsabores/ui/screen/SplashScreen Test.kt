package com.example.pasteleriamilsabores.ui.screen


import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class SplashViewModelTest {

    // test para la corrutina

    @Test
    fun splash_delay_inline() = runTest {

        var finished = false

        launch {
            delay(3000)
            finished = true
        }

        advanceTimeBy(3000)
        runCurrent()

        assertTrue(finished)
    }
}