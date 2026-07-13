package com.egobryant.cyclestack.ui.screens.today

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            FloatingActionButton(
                onClick = onAddSupplementClick,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Text("+", fontSize = 24.sp)
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(
                start = AppDimensions.ScreenPadding,
                end = AppDimensions.ScreenPadding,
                top = AppDimensions.Medium,
                bottom = 100.dp // Extra space for FAB and navigation
            ),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Medium)
        ) {
            item {
                ScreenHeader(
                    title = "Сегодня",
                    // Header handles its own spacing via SectionSpacing
                )
            }

            items(supplements) { supplement ->
                SupplementDoseCard(supplement = supplement)
            }
        }
    }
}
