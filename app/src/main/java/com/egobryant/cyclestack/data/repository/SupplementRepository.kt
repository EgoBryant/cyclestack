package com.egobryant.cyclestack.data.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.egobryant.cyclestack.data.model.DosageUnit
import com.egobryant.cyclestack.data.model.IntakeTime
import com.egobryant.cyclestack.data.model.Supplement
import com.egobryant.cyclestack.data.model.SupplementForm

/**
 * Репозиторий для управления данными о добавках.
 * Временно хранит список в оперативной памяти.
 */
object SupplementRepository {
    
    // Список добавок с использованием Compose State для мгновенного обновления UI
    private var _supplements by mutableStateOf(initialSupplements())

    /**
     * Получить текущий список добавок.
     */
    fun getSupplements(): List<Supplement> {
        return _supplements
    }

    /**
     * Добавить новую добавку.
     */
    fun addSupplement(supplement: Supplement) {
        _supplements = _supplements + supplement
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
