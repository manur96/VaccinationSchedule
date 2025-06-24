package com.plcoding.vaccinationschedule.vaccinationtable

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.graphics.Color
import com.plcoding.vaccinationschedule.data.models.*

@HiltViewModel
class VaccinationTableViewModel @Inject constructor(): ViewModel() {
    val cellColors = mutableStateMapOf<Pair<Diseases, Ages>, Color>()

    private val _diseasesOrder = mutableStateListOf<Diseases>().apply {
        addAll(Diseases.entries.toTypedArray())
    }
    val diseasesOrder: List<Diseases> get() = _diseasesOrder

    fun onCellClicked(disease: Diseases, age: Ages) {
        val isCorrect = disease.vaccinationSchedule.contains(age)
        val newColor = if (isCorrect) Color.Green else Color.Red
        cellColors[Pair(disease, age)] = newColor
    }

    fun resetColors() {
        cellColors.clear()
    }

    fun reorderDiseases() {
        _diseasesOrder.shuffle()
    }
}