package com.egobryant.cyclestack.ui.screens.add

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.egobryant.cyclestack.data.model.DosageUnit
import com.egobryant.cyclestack.data.model.IntakeTime
import com.egobryant.cyclestack.data.model.Supplement
import com.egobryant.cyclestack.data.model.SupplementForm
import com.egobryant.cyclestack.ui.components.AppTopBar
import com.egobryant.cyclestack.ui.components.PrimaryButton
import com.egobryant.cyclestack.ui.components.ScreenHeader
import com.egobryant.cyclestack.ui.components.SupplementTextField
import com.egobryant.cyclestack.ui.theme.AppDimensions

@Composable
fun AddSupplementScreen(
    onBackClick: () -> Unit,
    onSave: (Supplement) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var dosage by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

    val isSaveEnabled = name.isNotBlank()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            AppTopBar(onBackClick = onBackClick)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = AppDimensions.ScreenPadding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(AppDimensions.Medium))
                
                ScreenHeader(
                    title = "Новая добавка",
                    subtitle = "Заполните данные, чтобы начать отслеживать прием."
                )

                SupplementTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = "Название"
                )

                Spacer(modifier = Modifier.height(AppDimensions.FieldSpacing))

                SupplementTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = "Описание (опционально)"
                )

                Spacer(modifier = Modifier.height(AppDimensions.FieldSpacing))

                SupplementTextField(
                    value = dosage,
                    onValueChange = { dosage = it },
                    label = "Дозировка (напр. 500 мг)"
                )

                Spacer(modifier = Modifier.height(AppDimensions.FieldSpacing))

                SupplementTextField(
                    value = time,
                    onValueChange = { time = it },
                    label = "Время приема"
                )

                Spacer(modifier = Modifier.height(AppDimensions.ButtonHeight + AppDimensions.Large * 2))
            }

            PrimaryButton(
                text = "Сохранить",
                enabled = isSaveEnabled,
                onClick = {
                    val newSupplement = Supplement(
                        name = name,
                        description = description,
                        dosageAmount = dosage.toDoubleOrNull() ?: 0.0,
                        dosageUnit = DosageUnit.MG,
                        form = SupplementForm.CAPSULE,
                        intakeAmount = 1.0,
                        preferredIntakeTime = IntakeTime.CUSTOM,
                        customIntakeTime = time.ifBlank { null },
                        startDate = "01.01.2024" // Default for now
                    )
                    onSave(newSupplement)
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(AppDimensions.ScreenPadding)
            )
        }
    }
}
