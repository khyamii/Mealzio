package com.example.meals.domain.use_case.get_meals

import com.example.meals.common.Resource
import com.example.meals.data.remote.dto.toMeal
import com.example.meals.domain.model.Meal
import com.example.meals.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMealsUseCase @Inject constructor(
    private val repository: MealRepository
) {
    operator fun invoke(): Flow<Resource<List<Meal>>> = flow {
        try {
            emit(Resource.Loading())
            val meals = repository.getMeals().meals.map { it.toMeal() }
            emit(Resource.Success(meals))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}