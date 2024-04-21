package com.example.meals.presentation.meal_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.meals.domain.model.Meal

@Composable
fun MealListItem(
    meal: Meal,
    onItemClick: (Meal) -> Unit
) {

        Column(
            modifier = Modifier
                .clickable { onItemClick(meal) }
                .fillMaxWidth()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 15.dp
                ), // Apply elevation directly to the Card
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RoundedCornerShape(8.dp), // Apply rounded corners to the Card
                border = BorderStroke(1.dp, Color.Gray) // Add border to the Card
            ) {
                    Image(
                        painter = rememberAsyncImagePainter(meal.strMealThumb),
                        contentDescription = null,
                        contentScale = ContentScale.Crop, // You can use ContentScale.Fit as well, depending on your preference
                        modifier = Modifier.fillMaxSize()
                    )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = meal.strMeal,
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = meal.strArea,
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis,
                color = Color.LightGray,
                fontSize = 12.sp,
                fontFamily = FontFamily.Monospace,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(8.dp))


        }
    }

@Preview(showBackground = true)
@Composable
fun MealListItemPreview() {
    val sampleMeal = Meal("1","Carrots","https://www.themealdb.com/images/media/meals/58oia61564916529.jpg"
        ,"1","1","1")
    MealListItem(meal = sampleMeal, onItemClick = {})
}