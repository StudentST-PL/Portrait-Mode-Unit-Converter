package com.example.portrait_mode_unit_converter

import org.junit.Assert.assertEquals
import org.junit.Test

class ConverterLogicTest {

    @Test
    fun testUnitConversions() {
        // Test przeliczania 1000 metrów
        assertEquals("100,000", convertMeters("1000", LengthUnit.CENTIMETER))
        assertEquals("1", convertMeters("1000", LengthUnit.KILOMETER))
    }

    @Test
    fun testScientificNotationForExtremeValues() {
        // Test przełączenia na notację naukową przy małych i dużych wartościach
        val lightYearsResult = convertMeters("1", LengthUnit.LIGHT_YEAR)
        assert(lightYearsResult.contains("× 10^")) { "Oczekiwano notacji naukowej dla lat świetlnych" }
    }

    @Test
    fun testInvalidAndEmptyInputs() {
        // Test dla pustego tekstu oraz błędnych znaków
        assertEquals("", convertMeters("", LengthUnit.CENTIMETER))
        assertEquals("", convertMeters("abc", LengthUnit.KILOMETER))
    }
}