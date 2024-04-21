package com.example.meals.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meals.presentation.meal_details.MealDetailScreen
import com.example.meals.presentation.meal_list.MealListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    val sharedViewModel = SharedViewModel()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.MealListScreen.route
                    ) {
                        composable(
                            route = Screen.MealListScreen.route
                        ) {
                            MealListScreen(navController = navController,sharedViewModel= sharedViewModel)
                        }
                        composable(
                            route = Screen.MealDetailsScreen.route
                        ) {
                            MealDetailScreen(navController = navController,sharedViewModel= sharedViewModel)
                        }
                    }
                }
            }
        }
    }
}