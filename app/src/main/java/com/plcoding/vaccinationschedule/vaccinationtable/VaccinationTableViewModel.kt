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
    val cellStates = mutableStateMapOf<Pair<Diseases, Ages>, Boolean>()

    private val _diseasesOrder = mutableStateListOf<Diseases>().apply {
        addAll(Diseases.entries.toTypedArray())
    }
    val diseasesOrder: List<Diseases> get() = _diseasesOrder

    val correctPerDisease = mutableStateMapOf<Diseases, MutableSet<Ages>>()

    fun onCellClicked(disease: Diseases, age: Ages) {
        val key = Pair(disease, age)
        val isActive = cellStates[key] == true
        val isCorrect = disease.vaccinationSchedule.contains(age)
        val correctSet = correctPerDisease[disease] ?: mutableSetOf()

        if (isActive) {
            cellStates.remove(key)
            cellColors.remove(key)
            correctSet.remove(age)
            correctPerDisease[disease] = correctSet
        } else {
            cellStates[key] = true
            val color = if (isCorrect) {
                correctSet.add(age)
                correctPerDisease[disease] = correctSet
                Color.Green
            } else {
                Color.Red
            }
            cellColors[key] = color
        }
    }

    fun getCellColor(disease: Diseases, age: Ages): Color {
        return when {
            cellStates[Pair(disease, age)] == true -> cellColors[Pair(disease, age)] ?: Color.White
            else -> Color.White
        }
    }

    fun resetCells() {
        cellColors.clear()
        cellStates.clear()
        correctPerDisease.clear()
    }

    fun reorderDiseases() {
        _diseasesOrder.shuffle()
    }

    fun isDiseaseComplete(disease: Diseases): Boolean {
        val totalCorrectAges = disease.vaccinationSchedule.toSet()
        val correctAgesMarked = correctPerDisease[disease] ?: setOf()
        return totalCorrectAges.all { correctAgesMarked.contains(it) }
    }
}