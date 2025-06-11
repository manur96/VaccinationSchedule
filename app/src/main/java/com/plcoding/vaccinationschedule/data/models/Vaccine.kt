package com.plcoding.vaccinationschedule.data.models

data class Vaccine(
    val vaccineName: String,
    val listOfAges: List<Ages>
)
