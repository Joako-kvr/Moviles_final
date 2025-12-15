package com.example.pasteleriamilsabores.ui.screen


import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavController

import com.example.pasteleriamilsabores.viewmodel.SesionViewModel
import org.junit.Rule
import org.junit.Test
import io.mockk.mockk

class RegistroScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()



    // test para el error al repetir contraseñas

    @Test
    fun contrasenas_no_coinciden_test() {
        val navController = mockk<NavController>(relaxed = true)
        val sesionVM = SesionViewModel()

        composeTestRule.setContent {
            RegistroScreen(navController, sesionVM)
        }

        composeTestRule.onNodeWithText("Contraseña").performTextInput("123")
        composeTestRule.onNodeWithText("Confirmar Contraseña").performTextInput("456")
        composeTestRule.onNodeWithText("Registrarse").performClick()


        composeTestRule.onNodeWithText("Las contraseñas no coinciden").assertExists()
    }

}