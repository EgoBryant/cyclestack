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
import androidx.compose.ui.tooling.preview.Preview
import com.egobryant.cyclestack.ui.components.AppTopBar
import com.egobryant.cyclestack.ui.components.PrimaryButton
import com.egobryant.cyclestack.ui.components.ScreenHeader
import com.egobryant.cyclestack.ui.components.SupplementTextField
import com.egobryant.cyclestack.ui.theme.AppDimensions
import com.egobryant.cyclestack.ui.theme.CycleStackTheme

@Composable
fun AddSupplementScreen(onBackClick: () -> Unit = {}) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var dosage by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

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
                    title = "New Supplement",
                    subtitle = "Fill in the details to start tracking your new supplement routine."
                )

                SupplementTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = "Supplement name"
                )

                Spacer(modifier = Modifier.height(AppDimensions.FieldSpacing))

                SupplementTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = "Description (Optional)"
                )

                Spacer(modifier = Modifier.height(AppDimensions.FieldSpacing))

                SupplementTextField(
                    value = dosage,
                    onValueChange = { dosage = it },
                    label = "Dosage (e.g. 500mg)"
                )

                Spacer(modifier = Modifier.height(AppDimensions.FieldSpacing))

                SupplementTextField(
                    value = time,
                    onValueChange = { time = it },
                    label = "Time of day"
                )

                // Extra space for the button at the bottom
                Spacer(modifier = Modifier.height(AppDimensions.ButtonHeight + AppDimensions.Large * 2))
            }

            // Pinned Save Button
            PrimaryButton(
                text = "Save Supplement",
                onClick = { /* TODO: Save */ },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(AppDimensions.ScreenPadding)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddSupplementScreenPreview() {
    CycleStackTheme {
        AddSupplementScreen()
    }
}
