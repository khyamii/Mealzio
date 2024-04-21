package com.example.meals.data.repository

import com.example.meals.data.remote.MealsApi
import com.example.meals.domain.model.MealResponse
import com.example.meals.domain.repository.MealRepository
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val api: MealsApi
) : MealRepository {

    override suspend fun getMeals(): MealResponse {
        return api.getMeals()
    }

}