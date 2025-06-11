package com.plcoding.vaccinationschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.vaccinationschedule.ui.theme.VaccinationScheduleTheme
import com.plcoding.vaccinationschedule.vaccinationtable.VaccinationTableScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VaccinationSchedule : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VaccinationScheduleTheme {
                val navController = rememberNavController()
                Scaffold {
                        innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "vaccination_table_screen",
                        Modifier.padding(innerPadding)
                    ) {
                        composable(
                            route = "vaccination_table_screen"
                        ) {
                            VaccinationTableScreen(navController)
                        }
                    }
                }
            }
        }
    }

    private fun currentRoute(navController: NavController): String? {
        return navController.currentBackStackEntry?.destination?.route
    }
}
