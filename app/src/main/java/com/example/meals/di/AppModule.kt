package com.example.meals.di

import com.example.meals.common.Constants
import com.example.meals.data.remote.MealsApi
import com.example.meals.data.repository.MealRepositoryImpl
import com.example.meals.domain.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMealsApi(): MealsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMealRepository(api: MealsApi): MealRepository {
        return MealRepositoryImpl(api)
    }
}