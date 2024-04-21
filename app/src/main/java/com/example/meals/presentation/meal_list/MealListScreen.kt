package com.example.meals.presentation.meal_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.meals.R
import com.example.meals.presentation.Screen
import com.example.meals.presentation.SharedViewModel
import com.example.meals.presentation.meal_list.components.MealListItem

@Composable
fun MealListScreen(
    navController: NavController,
    viewModel: MealListViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize().background(colorResource(R.color.dark_gray))) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize().
            padding(0.dp,16.dp)
        ) {
            items(state.meals.size) { index ->
                val meal = state.meals[index]
                MealListItem(
                    meal = meal,
                    onItemClick = {
                        sharedViewModel.meal = it
                        navController.navigate(Screen.MealDetailsScreen.route)



                    }
                )
            }
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = colorResource(R.color.my_light_primary))
        }
    }


}