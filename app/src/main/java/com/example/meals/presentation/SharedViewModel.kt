package com.example.meals.presentation

import androidx.lifecycle.ViewModel
import com.example.meals.domain.model.Meal


class SharedViewModel : ViewModel() {
    var meal : Meal? = null
}