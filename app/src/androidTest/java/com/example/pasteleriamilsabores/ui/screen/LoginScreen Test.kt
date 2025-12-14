package com.example.pasteleriamilsabores.ui.screen

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import com.example.pasteleriamilsabores.viewmodel.SesionViewModel
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    @get:Rule
    val composeGetRule = createComposeRule()

    @Test
    fun Login_MuestraIniciarSesion() {
        composeGetRule.setContent {
            LoginScreen(navController = rememberNavController(), sesionViewModel = viewModel())
        }
        composeGetRule.onNodeWithText(text = "Iniciar Sesión").assertIsDisplayed()
    }


    // prueba que funcione el boton de ir a registro

    @Test
    fun LoginScreen_clickBoton_irRegistro() {
        lateinit var navController: TestNavHostController
        val sesionViewModel = SesionViewModel()

        composeGetRule.setContent {
            val context = LocalContext.current
            navController = TestNavHostController(context)
            navController.navigatorProvider.addNavigator(ComposeNavigator())

            NavHost(navController = navController, startDestination = "login") {
                composable("login") {
                    LoginScreen(
                        navController = navController,
                        sesionViewModel = sesionViewModel
                    )
                }

                composable("registro") { }
            }

        }

        composeGetRule
            .onNodeWithTag("btnIrRegistro")
            .performClick()

        Assert.assertEquals("registro", navController.currentBackStackEntry?.destination?.route)
    }


}