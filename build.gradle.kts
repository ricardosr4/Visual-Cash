// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    // KSP - Procesador de anotaciones (reemplaza kapt, más rápido)
    alias(libs.plugins.ksp) apply false
    // Hilt - Inyección de dependencias para Android
    alias(libs.plugins.hilt) apply false
}
