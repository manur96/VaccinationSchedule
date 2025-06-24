package com.plcoding.vaccinationschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.vaccinationschedule.ui.theme.VaccinationScheduleTheme
import com.plcoding.vaccinationschedule.vaccinationtable.VaccinationTableScreen
import com.plcoding.vaccinationschedule.vaccinationtable.VaccinationTableViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class VaccinationSchedule : ComponentActivity() {
    val viewModel: VaccinationTableViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel
            VaccinationScheduleTheme {
                val navController = rememberNavController()
                Scaffold (
                    topBar = {
                        TopAppBar(
                            title = { Text("Tabla de vacunación") },
                            actions = {
                                Button(
                                    modifier = Modifier
                                        .border(width = 1.dp,
                                            color = Color.Black,
                                            shape = RoundedCornerShape(10.dp)
                                        ),
                                    onClick = {
                                        viewModel.resetColors()
                                        viewModel.reorderDiseases()
                                    }
                                ) {
                                    Text("Actualizar")
                                }
                            }
                        )
                    }
                ){ innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "vaccination_table_screen",
                        Modifier.padding(innerPadding)
                    ) {
                        composable(
                            route = "vaccination_table_screen"
                        ) {
                            VaccinationTableScreen(navController, viewModel)
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
