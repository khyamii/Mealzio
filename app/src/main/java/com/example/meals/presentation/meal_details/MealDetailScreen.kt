package com.example.meals.presentation.meal_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.meals.R
import com.example.meals.presentation.SharedViewModel

@Composable
fun MealDetailScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.dark_gray))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            sharedViewModel.meal?.let {
                item {
                    Box {

                        Image(
                            painter = rememberAsyncImagePainter(it.strMealThumb),
                            contentDescription = null,
                            contentScale = ContentScale.Crop, // You can use ContentScale.Fit as well, depending on your preference
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )

                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .background(
                                    colorResource(R.color.second_color),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .border(
                                    1.dp,
                                    Color.Black,
                                    shape = RoundedCornerShape(16.dp)
                                ) // Adding border here
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .align(Alignment.BottomEnd)
                        ) {
                            Text(
                                text = it.strCategory,
                                color = colorResource(R.color.dark_gray),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(8.dp,0.dp)

                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clickable {
                                    navController.popBackStack()
                                }
                                .padding(8.dp)
                                .background(colorResource(R.color.my_light_primary), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier.size(24.dp),
                                tint = Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),

                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            color = Color.White,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 23.sp,
                            text = it.strMeal,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = it.strArea,
                            fontFamily = FontFamily.Monospace,
                            color = colorResource(R.color.my_light_primary),
                            fontSize = 13.sp,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(2f)
                        )
                    }

                    Text(
                        modifier = Modifier.padding(12.dp, 0.dp),
                        color = colorResource(R.color.second_color),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        text = "Instructions",
                        style = MaterialTheme.typography.bodyMedium,

                        )
                    Text(
                        modifier = Modifier.padding(12.dp),
                        color = Color.White,
                        lineHeight = 25.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 14.sp,
                        text = it.strInstructions,
                        style = MaterialTheme.typography.bodyMedium,

                        )

                }
            }
        }
    }
}