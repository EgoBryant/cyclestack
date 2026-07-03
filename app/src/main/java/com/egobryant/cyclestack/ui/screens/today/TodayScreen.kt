package com.egobryant.cyclestack.ui.screens.today

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.egobryant.cyclestack.data.model.SupplementDose
import com.egobryant.cyclestack.ui.components.SupplementDoseCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodayScreen() {
    // Mock data
    val doses = listOf(
        SupplementDose("L-Theanine", "2 capsules", "Morning", "After breakfast"),
        SupplementDose("Lion's Mane", "1 capsule", "Morning", "With water"),
        SupplementDose("Omega-3", "2 capsules", "Evening", "After dinner")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("CycleStack") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Functionality coming later */ }) {
                Text("+", fontSize = 24.sp)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Today",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            LazyColumn {
                items(doses) { dose ->
                    SupplementDoseCard(dose)
                }
            }
        }
    }
}
