package com.example.meals.presentation.meal_list

import com.example.meals.domain.model.Meal


data class MealListState(
    val isLoading: Boolean = false,
    val meals: List<Meal> = emptyList(),
    val error: String = ""
)
