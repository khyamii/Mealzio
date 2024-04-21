package com.example.meals.domain.model

import com.example.meals.data.remote.dto.MealDto

data class MealResponse(
    val meals: List<MealDto>
)