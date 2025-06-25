package com.plcoding.vaccinationschedule.vaccinationtable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.plcoding.vaccinationschedule.data.models.Ages
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.ui.Alignment

@Composable
fun VaccinationTableScreen(
    navController: NavController,
    viewModel: VaccinationTableViewModel
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .border(1.dp, Gray)
                        .width(130.dp)
                        .height(50.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp),
                        text = "VACUNAS",
                        textAlign = TextAlign.Center
                    )
                }
                Column(modifier = Modifier.height(50.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                            .weight(1f)
                            .border(1.dp, Black)
                    ) {
                        Ages.entries.forEach { age ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .border(1.dp, Gray)
                                    .weight(1f)
                                    .height(60.dp),
                            ) {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 4.dp, vertical = 6.dp),
                                    text = age.displayName,
                                    textAlign = TextAlign.Center,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 8.dp, end = 10.dp)
            ) {
                viewModel.diseasesOrder.forEach { disease ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(130.dp)
                                .background(disease.backgroundColor),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(horizontal = 6.dp, vertical = 4.dp),
                                    text = disease.displayName,
                                    textAlign = TextAlign.Center,
                                    fontSize = 12.sp
                                )
                                if (viewModel.isDiseaseComplete(disease)) {
                                    Icon(
                                        imageVector = Icons.Filled.Check,
                                        contentDescription = "Complete",
                                        tint = Black,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                        Ages.entries.forEach { age ->
                            val color = viewModel.getCellColor(disease, age)
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .border(1.dp, Gray)
                                    .weight(1f)
                                    .background(color)
                                    .clickable {
                                        viewModel.onCellClicked(disease, age)
                                        println("Clicked on $age for $disease")
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}
