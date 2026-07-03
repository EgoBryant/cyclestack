package com.egobryant.cyclestack.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.egobryant.cyclestack.data.model.SupplementDose

@Composable
fun SupplementDoseCard(dose: SupplementDose) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = dose.name,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "${dose.amount} • ${dose.time}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = dose.note,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
            
            Button(
                onClick = { /* TODO: Functionality coming later */ },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Mark as taken")
            }
        }
    }
}
