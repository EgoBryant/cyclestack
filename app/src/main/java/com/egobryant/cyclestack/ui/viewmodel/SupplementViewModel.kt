package com.egobryant.cyclestack.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.egobryant.cyclestack.data.model.DosageUnit
import com.egobryant.cyclestack.data.model.IntakeTime
import com.egobryant.cyclestack.data.model.Supplement
import com.egobryant.cyclestack.data.model.SupplementForm

/**
 * ViewModel для управления списком добавок.
 * На данном этапе хранит данные в оперативной памяти.
 */
class SupplementViewModel : ViewModel() {
    
    // Список добавок, доступный только для чтения извне
    var supplements by mutableStateOf(initialSupplements())
        private set

    /**
     * Добавление новой добавки в список.
     */
    fun addSupplement(supplement: Supplement) {
        supplements = supplements + supplement
    }

    private fun initialSupplements(): List<Supplement> {
        return listOf(
            Supplement(
                name = "L-Theanine",
                description = "После завтрака",
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
                description = "Запивать водой",
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
                description = "После ужина",
                dosageAmount = 1000.0,
                dosageUnit = DosageUnit.MG,
                form = SupplementForm.CAPSULE,
                intakeAmount = 2.0,
                preferredIntakeTime = IntakeTime.EVENING,
                customIntakeTime = "Вечер",
                startDate = "01.01.2024"
            )
        )
    }
}
