package com.plcoding.vaccinationschedule.data.models

import androidx.compose.ui.graphics.Color
import com.plcoding.vaccinationschedule.ui.theme.*
import com.plcoding.vaccinationschedule.data.models.Ages.*

enum class Diseases(
    val displayName: String,
    val backgroundColor: Color,
    val vaccinationSchedule: List<Ages>
) {
    POLIOMIELITIS(
        "Poliomielitis",
        PoliomielitisColor,
        listOf(TWO_MONTHS, FOUR_MONTHS, ELEVEN_MONTHS, SIX_YEARS)
    ),
    DIFTERIA_TETANOS_TOSFERINA(
        "Difteria - Tetanos - Tosferina",
        DifteriaColor,
        listOf(PRENATAL, TWO_MONTHS, FOUR_MONTHS, ELEVEN_MONTHS, SIX_YEARS, FOURTEEN_YEARS, MORE_THAN_SIXTYFIVE_YEARS)
    ),
    HAEMOPHILUS_INFLUENZA_B(
        "Haemophilus influenza B",
        InfluenzaColor,
        listOf(TWO_MONTHS, FOUR_MONTHS, ELEVEN_MONTHS)
    ),
    HEPATITIS_B(
        "Hepatitis B",
        HepatitisColor,
        listOf(TWO_MONTHS, FOUR_MONTHS, ELEVEN_MONTHS)
    ),
    SARAMPION_RUBEOLA_PAROTIDITIS(
        "Sarampion - Rubeola - Parotiditis",
        SarampionColor,
        listOf(TWELVE_MONTHS, FOUR_YEARS)
    ),
    ENFERMEDAD_MENINGOCOCICA(
        "Enfermedad meningococica",
        MeningococicaColor,
        listOf(TWO_MONTHS, FOUR_MONTHS, TWELVE_MONTHS, TWELVE_YEARS)
    ),
    VARICELA(
        "Varicela",
        VaricelaColor,
        listOf(FIFTEEN_MONTHS, FOUR_YEARS)
    ),
    VIRUS_DEL_PAPILOMA_HUMANO(
        "Virus del papiloma humano",
        PapilomaColor,
        listOf(TWELVE_YEARS)
    ),
    ENFERMEDAD_NEUMOCOCICA(
        "Enfermedad neumococica",
        NeumocicaColor,
        listOf(TWO_MONTHS, FOUR_MONTHS, SIX_MONTHS, ELEVEN_MONTHS, MORE_THAN_SIXTYFIVE_YEARS)
    ),
    HERPES_ZOSTER(
        "Herpes zoster",
        ZosterColor,
        listOf(MORE_THAN_SIXTYFIVE_YEARS)
    ),
    GRIPE(
        "Gripe",
        GripeColor,
        listOf(PRENATAL, SIX_MONTHS, ELEVEN_MONTHS, TWELVE_MONTHS, FIFTEEN_MONTHS, FOUR_YEARS, MORE_THAN_SIXTYFIVE_YEARS)
    )
}