package com.egobryant.cyclestack.ui.screens.today

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.egobryant.cyclestack.data.model.Supplement
import com.egobryant.cyclestack.ui.components.AppTopBar
import com.egobryant.cyclestack.ui.components.ScreenHeader
import com.egobryant.cyclestack.ui.components.SupplementDoseCard
import com.egobryant.cyclestack.ui.theme.AppDimensions

@Composable
fun TodayScreen(
    supplements: List<Supplement>,
    onAddSupplementClick: () -> Unit
) {
    Scaffold(
        topBar = {
            AppTopBar(title = "CycleStack")
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddSupplementClick) {
                Text("+", fontSize = 24.sp)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = AppDimensions.ScreenPadding)
                .fillMaxSize()
        ) {
            ScreenHeader(
                title = "Сегодня",
                modifier = Modifier.padding(top = AppDimensions.Medium)
            )

            LazyColumn {
                items(supplements) { supplement ->
                    SupplementDoseCard(supplement = supplement)
                }
            }
        }
    }
}
