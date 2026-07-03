package com.egobryant.cyclestack.data.model

/**
 * Единицы измерения дозировки вещества (мг, г и т.д.)
 */
enum class DosageUnit(val label: String) {
    MG("мг"),
    G("г"),
    IU("МЕ"),
    ML("мл")
}

/**
 * Форма выпуска добавки
 */
enum class SupplementForm(val label: String) {
    CAPSULE("капсула"),
    TABLET("таблетка"),
    DROPS("капли"),
    POWDER("порошок"),
    SCOOP("черпак")
}

/**
 * Время приема
 */
enum class IntakeTime(val label: String) {
    MORNING("Утро"),
    AFTERNOON("День"),
    EVENING("Вечер"),
    CUSTOM("Своё время")
}

/**
 * Отношение к приему пищи
 */
enum class FoodRelation(val label: String) {
    BEFORE_MEAL("До еды"),
    WITH_MEAL("Во время еды"),
    AFTER_MEAL("После еды"),
    NONE("Неважно")
}

/**
 * Единицы измерения циклов (дни, недели, месяцы)
 */
enum class CycleUnit(val label: String) {
    DAYS("дн."),
    WEEKS("нед."),
    MONTHS("мес.")
}
