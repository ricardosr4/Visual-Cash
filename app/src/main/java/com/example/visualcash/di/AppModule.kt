package com.example.visualcash.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // Aquí se proveerán dependencias globales (Firebase, DataStore, Retrofit, etc.)
    // Ejemplo:
    // @Provides
    // @Singleton
    // fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth
}
