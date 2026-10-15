package com.example.portrait_mode_unit_converter

import androidx.compose.material3.SwipeToDismissBox
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

enum class LengthUnit(
    val label: String,
    val symbol: String,
    val metersFactor: Double
) {
    CENTIMETER("Centimeters", "cm", 0.01),
    KILOMETER("Kilometers", "km", 1000.0),
    MILE("Miles","mi",1609.344),
    LIGHT_YEAR("Light Years","ly",9_460_730_472_580_800.0)
}

fun convertMeters(inputMeters: String, unit: LengthUnit): String{
    val normalizedInput = inputMeters.replace(',', '.')
    val meters = normalizedInput.toDoubleOrNull()
    if (meters == null) {
        return ""
    }
    val result = meters/unit.metersFactor
    return formatNumber(result)
}

fun formatNumber(value: Double): String {
    if (value == 0.0) return "0"

    val absValue = kotlin.math.abs(value)

    return if (absValue < 1e-4 || absValue >= 1e7) {
        val formatter = DecimalFormat("0.0000E0")
        formatter.format(value).replace("E", " × 10^")
    } else {
        val formatter = NumberFormat.getNumberInstance(Locale.US).apply {
            maximumFractionDigits = 4
            isGroupingUsed = true
        }
        formatter.format(value)
    }
}