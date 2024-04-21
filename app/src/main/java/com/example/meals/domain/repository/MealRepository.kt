package com.example.meals.domain.repository

import com.example.meals.domain.model.MealResponse


interface MealRepository {

    suspend fun getMeals(): MealResponse

}