package com.example.lab13_animaciones

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
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset

@Composable
fun SizeAndPositionAnimationSample() {
    // Estado para el tamaño y la posición
    var isExpanded by remember { mutableStateOf(false) }

    // Animación del tamaño
    val size by animateDpAsState(
        targetValue = if (isExpanded) 200.dp else 100.dp,
        animationSpec = tween(durationMillis = 500)
    )

    // Animación de la posición
    val offsetX by animateDpAsState(
        targetValue = if (isExpanded) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 500)
    )
    // Contenedor principal
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Cuadro animado
        Box(
            modifier = Modifier
                .size(size)
                .offset(x = offsetX, y = 0.dp)
                .background(Color.Blue)
        )

        // Botón para cambiar el tamaño y la posición
        Button(
            onClick = { isExpanded = !isExpanded },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = "Animate Size & Position")
        }
    }
}