package com.example.lab13_animaciones

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ColorChangeSample() {
    // Estado para el color del cuadro
    var isBlue by remember { mutableStateOf(true) }

    // Animación de color
    val backgroundColor by animateColorAsState(
        targetValue = if (isBlue) Color.Blue else Color.Green,
        animationSpec = tween(durationMillis = 1000) // Especificación de animación
    )

    // Contenedor principal
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(backgroundColor)
    ) {
        // Botón para cambiar el color
        Button(
            onClick = { isBlue = !isBlue },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "Change Color")
        }
    }
}