package com.example.pasteleriamilsabores.ui.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import org.junit.Rule
import org.junit.Test

class CarritoScreenTest {

    @get:Rule
    val composeGetRule = createComposeRule()

    @Test
    fun Carrito_MuestraTitulo() {
        composeGetRule.setContent {
            CarritoScreen(navController = rememberNavController(), sesionViewModel = viewModel())
        }
        composeGetRule.onNodeWithText(text = "Mi Carrito").assertIsDisplayed()
    }


}