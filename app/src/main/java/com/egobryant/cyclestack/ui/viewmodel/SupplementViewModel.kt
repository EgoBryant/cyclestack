package com.egobryant.cyclestack.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.egobryant.cyclestack.data.model.Supplement
import com.egobryant.cyclestack.data.repository.SupplementRepository

/**
 * ViewModel для управления состоянием экрана добавок.
 * Делегирует работу с данными репозиторию.
 */
class SupplementViewModel : ViewModel() {
    
    /**
     * Список добавок для отображения в UI.
     * Получает актуальное состояние напрямую из репозитория.
     */
    val supplements: List<Supplement>
        get() = SupplementRepository.getSupplements()

    /**
     * Добавление новой добавки через репозиторий.
     */
    fun addSupplement(supplement: Supplement) {
        SupplementRepository.addSupplement(supplement)
    }
}
