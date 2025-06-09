package com.plcoding.vaccinationschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.plcoding.vaccinationschedule.ui.theme.VaccinationScheduleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VaccinationScheduleTheme {

            }
        }
    }
}
