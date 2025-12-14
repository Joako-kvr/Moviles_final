package com.example.pasteleriamilsabores.ui.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import org.junit.Rule
import org.junit.Test

class PerfilScreenTest {

    @get:Rule
    val composeGetRule = createComposeRule()

    @Test
    fun Perfil_MuestraTitulo() {
        composeGetRule.setContent {
            PerfilScreen(navController = rememberNavController(), sesionViewModel = viewModel())
        }
        composeGetRule.onNodeWithText(text = "Mil Sabores").assertIsDisplayed()
    }


}