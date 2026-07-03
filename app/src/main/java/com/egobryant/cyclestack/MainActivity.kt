package com.egobryant.cyclestack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.egobryant.cyclestack.ui.screens.add.AddSupplementScreen
import com.egobryant.cyclestack.ui.theme.CycleStackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CycleStackTheme {
                AddSupplementScreen()
            }
        }
    }
}
