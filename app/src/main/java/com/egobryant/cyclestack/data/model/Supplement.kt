package com.egobryant.cyclestack.data.model

/**
 * Основная модель добавки (БАДа) в приложении.
 */
data class Supplement(
    val name: String,
    val description: String = "",
    
    // Дозировка активного вещества (например, 500 мг)
    val dosageAmount: Double,
    val dosageUnit: DosageUnit,
    
    // Форма и количество приема (например, 2 капсулы)
    val form: SupplementForm,
    val intakeAmount: Double,
    
    // Время и условия приема
    val preferredIntakeTime: IntakeTime,
    val customIntakeTime: String? = null,
    val foodRelation: FoodRelation = FoodRelation.NONE,
    
    // Сроки курса
    val startDate: String,
    val endDate: String? = null,
    
    // Настройки циклов (прием/перерыв)
    val cycleSettings: CycleSettings = CycleSettings(),
    
    // Учет запасов
    val inventory: InventorySettings = InventorySettings(),
    
    val notes: String = ""
)

/**
 * Настройки курса: продолжительность приема и перерыва.
 */
data class CycleSettings(
    val isEnabled: Boolean = false,
    val intakeValue: Int = 30,
    val intakeUnit: CycleUnit = CycleUnit.DAYS,
    val breakValue: Int = 7,
    val breakUnit: CycleUnit = CycleUnit.DAYS
)

/**
 * Данные о наличии добавки и отслеживание остатков.
 */
data class InventorySettings(
    val currentAmount: Double = 0.0,
    val lowStockThreshold: Double = 10.0,
    val purchaseLink: String? = null
)
