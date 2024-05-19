package com.example.portfolio

import android.util.Log
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun StateManagement(modifier: Modifier = Modifier) {

    val state = remember {
        mutableStateOf("")
    }

    Log.d("TAG", "StateManagement: ${state.value}")

    TextField(value = state.value, onValueChange = {
        state.value = it
    })
}