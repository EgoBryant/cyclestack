package com.egobryant.cyclestack.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.egobryant.cyclestack.ui.screens.add.AddSupplementScreen
import com.egobryant.cyclestack.ui.screens.today.TodayScreen
import com.egobryant.cyclestack.ui.theme.CycleStackTheme

/**
 * Перечисление всех экранов приложения.
 */
enum class Screen {
    Today,
    AddSupplement
}

@Composable
fun CycleStackApp() {
    var currentScreen by remember { mutableStateOf(Screen.Today) }

    CycleStackTheme {
        when (currentScreen) {
            Screen.Today -> TodayScreen(
                onAddSupplementClick = { currentScreen = Screen.AddSupplement }
            )
            Screen.AddSupplement -> AddSupplementScreen(
                onBackClick = { currentScreen = Screen.Today }
            )
        }
    }
}
