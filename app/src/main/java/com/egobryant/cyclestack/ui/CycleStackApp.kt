package com.egobryant.cyclestack.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.egobryant.cyclestack.ui.screens.add.AddSupplementScreen
import com.egobryant.cyclestack.ui.screens.today.TodayScreen
import com.egobryant.cyclestack.ui.theme.CycleStackTheme
import com.egobryant.cyclestack.ui.viewmodel.SupplementViewModel

enum class Screen {
    Today,
    AddSupplement
}

@Composable
fun CycleStackApp(
    viewModel: SupplementViewModel = viewModel()
) {
    var currentScreen by remember { mutableStateOf(Screen.Today) }
    
    val supplements = viewModel.supplements

    CycleStackTheme {
        when (currentScreen) {
            Screen.Today -> TodayScreen(
                supplements = supplements,
                onAddSupplementClick = { currentScreen = Screen.AddSupplement }
            )
            Screen.AddSupplement -> AddSupplementScreen(
                onBackClick = { currentScreen = Screen.Today },
                onSave = { newSupplement ->
                    viewModel.addSupplement(newSupplement)
                    currentScreen = Screen.Today
                }
            )
        }
    }
}
