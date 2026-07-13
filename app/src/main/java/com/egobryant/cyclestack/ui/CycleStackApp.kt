package com.egobryant.cyclestack.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.egobryant.cyclestack.data.model.DosageUnit
import com.egobryant.cyclestack.data.model.IntakeTime
import com.egobryant.cyclestack.data.model.Supplement
import com.egobryant.cyclestack.data.model.SupplementForm
import com.egobryant.cyclestack.ui.screens.add.AddSupplementScreen
import com.egobryant.cyclestack.ui.screens.today.TodayScreen
import com.egobryant.cyclestack.ui.theme.CycleStackTheme

enum class Screen {
    Today,
    AddSupplement
}

@Composable
fun CycleStackApp() {
    var currentScreen by remember { mutableStateOf(Screen.Today) }
    
    // In-memory list of supplements
    var supplements by remember {
        mutableStateOf(
            listOf(
                Supplement(
                    name = "L-Theanine",
                    description = "After breakfast",
                    dosageAmount = 200.0,
                    dosageUnit = DosageUnit.MG,
                    form = SupplementForm.CAPSULE,
                    intakeAmount = 2.0,
                    preferredIntakeTime = IntakeTime.MORNING,
                    customIntakeTime = "Утро",
                    startDate = "01.01.2024"
                ),
                Supplement(
                    name = "Lion's Mane",
                    description = "With water",
                    dosageAmount = 500.0,
                    dosageUnit = DosageUnit.MG,
                    form = SupplementForm.CAPSULE,
                    intakeAmount = 1.0,
                    preferredIntakeTime = IntakeTime.MORNING,
                    customIntakeTime = "Утро",
                    startDate = "01.01.2024"
                ),
                Supplement(
                    name = "Omega-3",
                    description = "After dinner",
                    dosageAmount = 1000.0,
                    dosageUnit = DosageUnit.MG,
                    form = SupplementForm.CAPSULE,
                    intakeAmount = 2.0,
                    preferredIntakeTime = IntakeTime.EVENING,
                    customIntakeTime = "Вечер",
                    startDate = "01.01.2024"
                )
            )
        )
    }

    CycleStackTheme {
        when (currentScreen) {
            Screen.Today -> TodayScreen(
                supplements = supplements,
                onAddSupplementClick = { currentScreen = Screen.AddSupplement }
            )
            Screen.AddSupplement -> AddSupplementScreen(
                onBackClick = { currentScreen = Screen.Today },
                onSave = { newSupplement ->
                    supplements = supplements + newSupplement
                    currentScreen = Screen.Today
                }
            )
        }
    }
}
