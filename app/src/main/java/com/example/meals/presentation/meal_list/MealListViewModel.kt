package com.example.meals.presentation.meal_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meals.common.Resource
import com.example.meals.domain.use_case.get_meals.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealListViewModel @Inject constructor(
    private val getMealsUseCase: GetMealsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MealListState())
    val state: State<MealListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getMealsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MealListState(meals = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MealListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MealListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}