package com.example.meals.data.remote

import com.example.meals.domain.model.MealResponse
import retrofit2.http.GET


interface MealsApi {

    @GET("api/json/v1/1/search.php?s=")
    suspend fun getMeals(): MealResponse

}