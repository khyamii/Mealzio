package com.example.meals.presentation

sealed class Screen(val route: String) {
    data object MealListScreen: Screen("meal_list_screen")
    data object MealDetailsScreen: Screen("meal_details_screen")

}
