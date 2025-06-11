package com.plcoding.vaccinationschedule.vaccinationtable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.plcoding.vaccinationschedule.data.models.Ages
import com.plcoding.vaccinationschedule.data.models.Diseases

@Composable
fun VaccinationTableScreen(
    navController: NavController,
    viewModel: VaccinationTableViewModel = hiltViewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .border(1.dp, Gray)
                .width(110.dp)
                .height(60.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 4.dp, vertical = 6.dp),
                text = "VACUNACIÓN",
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .border(1.dp, Black)
        ) {
            for (age in Ages.entries) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .height(60.dp)
                        .border(1.dp, Gray)
                        .weight(1f)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp, vertical = 6.dp),
                        text = age.displayName,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Column (
            modifier = Modifier
                .padding(16.dp)
                .border(1.dp, Black)
        ) {
            for (disease in Diseases.entries) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(110.dp)
                        .border(1.dp, Gray)
                        .weight(1f)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp, vertical = 6.dp),
                        text = disease.displayName,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}