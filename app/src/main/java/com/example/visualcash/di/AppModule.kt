package com.example.visualcash.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Nombre del archivo donde DataStore guarda las preferencias.
 * Se crea automáticamente en: data/data/com.example.visualcash/files/datastore/
 */
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "visual_cash_preferences",
)

/**
 * Módulo de Hilt que provee dependencias globales (Singleton).
 *
 * Aquí se registran las dependencias que necesitan ser creadas una sola vez
 * y compartidas en toda la app (DataStore, Firebase, Retrofit, etc.).
 *
 * CÓMO AGREGAR UNA NUEVA DEPENDENCIA:
 *   1. Crear una función con @Provides y @Singleton.
 *   2. El parámetro de retorno será el tipo que Hilt inyectará.
 *   3. Hilt se encarga del resto: crea la instancia y la inyecta donde se necesite.
 *
 * Ejemplo para Firebase Auth:
 *   @Provides
 *   @Singleton
 *   fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Provee la instancia de DataStore<Preferences> para inyectarla en DataStoreManager.
     * Solo se crea una instancia (Singleton) para evitar corrupción de datos.
     */
    @Provides
    @Singleton
    fun provideDataStore(
        @ApplicationContext context: Context,
    ): DataStore<Preferences> = context.dataStore

    // ────────────────────────────────────────────────────────────────────
    // AGREGAR NUEVAS DEPENDENCIAS AQUÍ
    // ────────────────────────────────────────────────────────────────────
    //
    // Ejemplo para Retrofit:
    // @Provides
    // @Singleton
    // fun provideRetrofit(): Retrofit {
    //     return Retrofit.Builder()
    //         .baseUrl("https://api.example.com/")
    //         .addConverterFactory(GsonConverterFactory.create())
    //         .build()
    // }
    //
    // Ejemplo para Firebase Firestore:
    // @Provides
    // @Singleton
    // fun provideFirestore(): FirebaseFirestore = Firebase.firestore
}
