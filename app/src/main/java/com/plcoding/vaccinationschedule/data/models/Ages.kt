package com.plcoding.vaccinationschedule.data.models

enum class Ages(val displayName: String) {
    PRENATAL("Prenatal"),
    ZERO_MONTHS("0 meses"),
    TWO_MONTHS("2 meses"),
    FOUR_MONTHS("4 meses"),
    SIX_MONTHS("6 meses"),
    ELEVEN_MONTHS("11 meses"),
    TWELVE_MONTHS("12 meses"),
    FIFTEEN_MONTHS("15 meses"),
    FOUR_YEARS("4 años"),
    FIVE_YEARS("5 años"),
    SIX_YEARS("6 años"),
    TWELVE_YEARS("12 años"),
    FOURTEEN_YEARS("14 años"),
    FIFTEEN_TO_EIGHTEEN_YEARS("15 a 18 años"),
    NINETEEN_TO_SIXTYFOUR_YEARS("19 a 64 años"),
    MORE_THAN_SIXTYFIVE_YEARS("más de 65 años")
}
