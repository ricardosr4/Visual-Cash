package com.example.visualcash.core.model

/**
 * Monedas disponibles en la aplicación.
 *
 * @param code Código ISO 4217 (ej: "CLP", "USD")
 * @param symbol Símbolo de la moneda (ej: "$", "€")
 * @param displayName Nombre legible para mostrar al usuario
 * @param flag Emoji de bandera del país
 *
 * Para agregar una nueva moneda:
 *   1. Agregar la entrada aquí en el enum.
 *   2. Listo — el selector la mostrará automáticamente.
 */
enum class Currency(
    val code: String,
    val symbol: String,
    val displayName: String,
    val flag: String,
) {
    CLP(code = "CLP", symbol = "$", displayName = "Peso Chileno", flag = "\uD83C\uDDE8\uD83C\uDDF1"),
    USD(code = "USD", symbol = "$", displayName = "Dólar Estadounidense", flag = "\uD83C\uDDFA\uD83C\uDDF8"),
    EUR(code = "EUR", symbol = "€", displayName = "Euro", flag = "\uD83C\uDDEA\uD83C\uDDFA"),
    ARS(code = "ARS", symbol = "$", displayName = "Peso Argentino", flag = "\uD83C\uDDE6\uD83C\uDDF7"),
    COP(code = "COP", symbol = "$", displayName = "Peso Colombiano", flag = "\uD83C\uDDE8\uD83C\uDDF4"),
    MXN(code = "MXN", symbol = "$", displayName = "Peso Mexicano", flag = "\uD83C\uDDF2\uD83C\uDDFD"),
    PEN(code = "PEN", symbol = "S/", displayName = "Sol Peruano", flag = "\uD83C\uDDF5\uD83C\uDDEA"),
    BRL(code = "BRL", symbol = "R$", displayName = "Real Brasileño", flag = "\uD83C\uDDE7\uD83C\uDDF7"),
    UYU(code = "UYU", symbol = "$", displayName = "Peso Uruguayo", flag = "\uD83C\uDDFA\uD83C\uDDFE"),
    BOB(code = "BOB", symbol = "Bs", displayName = "Boliviano", flag = "\uD83C\uDDE7\uD83C\uDDF4"),
    PYG(code = "PYG", symbol = "₲", displayName = "Guaraní Paraguayo", flag = "\uD83C\uDDF5\uD83C\uDDFE"),
    GBP(code = "GBP", symbol = "£", displayName = "Libra Esterlina", flag = "\uD83C\uDDEC\uD83C\uDDE7");

    /**
     * Formato corto para mostrar en la UI (ej: "CLP ($)")
     */
    val label: String get() = "$code ($symbol)"

    companion object {
        val DEFAULT = CLP

        /**
         * Busca una moneda por su código ISO.
         * Si no la encuentra, devuelve la moneda por defecto (CLP).
         */
        fun fromCode(code: String): Currency {
            return entries.find { it.code == code } ?: DEFAULT
        }
    }
}
