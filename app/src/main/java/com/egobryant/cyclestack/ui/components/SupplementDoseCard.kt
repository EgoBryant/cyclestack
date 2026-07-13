package com.egobryant.cyclestack.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.egobryant.cyclestack.data.model.Supplement
import com.egobryant.cyclestack.ui.theme.AppDimensions

@Composable
fun SupplementDoseCard(supplement: Supplement) {
    AppCard(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = supplement.name,
            style = MaterialTheme.typography.titleLarge
        )
        
        val intakeInfo = "${supplement.intakeAmount.toInt()} ${supplement.form.label}"
        val timeInfo = supplement.customIntakeTime ?: supplement.preferredIntakeTime.label
        
        Text(
            text = "$intakeInfo • $timeInfo",
            style = MaterialTheme.typography.bodyMedium
        )
        
        if (supplement.description.isNotEmpty()) {
            Text(
                text = supplement.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        
        Button(
            onClick = { /* TODO: Functionality coming later */ },
            modifier = Modifier.padding(top = AppDimensions.Small)
        ) {
            Text("Принять")
        }
    }
}
