package com.example.gradlekotlintest.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class ContextModule(private val context: Context) {
    @Provides
    fun provideContext() = context
}