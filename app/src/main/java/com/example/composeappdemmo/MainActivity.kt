package com.example.composeappdemmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeappdemmo.pokemondetail.PokemonDetailScreen
import com.example.composeappdemmo.pokemonlist.PokemonListScreen
import com.example.composeappdemmo.ui.theme.ComposeAppDemmoTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAppDemmoTheme {

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "pokemon_list_screen"
                )
                {

                    composable("pokemon_list_screen") {

                        PokemonListScreen(navController = navController)

                    }

                    // Ensure the route name here matches the one used in the navigation call
                    composable("pokemon_details_screen/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("pokemonName") {
                                type = NavType.StringType
                            }
                        )
                    ) { backStackEntry ->

                        // Retrieve and convert arguments from the backStackEntry
                        val dominantColor = remember {
                            val color = backStackEntry.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White // Default to Color.White if null
                        }
                        val pokemonName = remember {
                            backStackEntry.arguments?.getString("pokemonName")
                        }

                        // Pass the arguments to the destination screen
                        PokemonDetailScreen(
                            dominantColor = dominantColor,
                            pokemonName = pokemonName?.toLowerCase(Locale.ROOT) ?: "",
                            navController = navController
                        )
                    }


                }


            }
        }
    }
}