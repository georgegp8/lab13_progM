package com.example.lab13_animaciones

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedVisibilitySample() {
    // Estado para el cuadro de color
    var isColorBoxVisible by remember { mutableStateOf(false) }

    // Estado para el ventilador
    var isFanVisible by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Botón para alternar la visibilidad del cuadro de color
        Button(
            onClick = { isColorBoxVisible = !isColorBoxVisible },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Toggle Color Box")
        }

        // AnimatedVisibility para el cuadro de color
        AnimatedVisibility(
            visible = isColorBoxVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Blue)
            )
        }

        // Botón para alternar la visibilidad del ventilador
        Button(
            onClick = { isFanVisible = !isFanVisible },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Toggle Fan Icon")
        }

        // AnimatedVisibility para el ícono del ventilador
        AnimatedVisibility(
            visible = isFanVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_fan),
                contentDescription = "Ventilador",
                modifier = Modifier.size(100.dp) // Ajusta el tamaño según necesites
            )
        }
    }
}