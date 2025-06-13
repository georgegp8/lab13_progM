package com.example.lab13_animaciones

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PantallaAnimacionesFinal() {
    var expandido by remember { mutableStateOf(false) }
    var mostrarBoton by remember { mutableStateOf(true) }
    var modoOscuro by remember { mutableStateOf(false) }

    val colorCaja by animateColorAsState(
        targetValue = if (modoOscuro) Color.DarkGray else Color(0xFFBBDEFB),
        animationSpec = tween(durationMillis = 600)
    )

    val tamañoCaja by animateDpAsState(
        targetValue = if (expandido) 200.dp else 100.dp,
        animationSpec = tween(durationMillis = 600)
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = if (modoOscuro) Color.Black else Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            // Cambia de tamaño y color al hacer clic
            Box(
                modifier = Modifier
                    .size(tamañoCaja)
                    .background(colorCaja, shape = RoundedCornerShape(12.dp))
                    .clickable { expandido = !expandido }
            )

            // Botón con AnimatedVisibility
            AnimatedVisibility(
                visible = mostrarBoton,
                enter = slideInVertically(animationSpec = tween(500)) + fadeIn(),
                exit = slideOutVertically(animationSpec = tween(500)) + fadeOut()
            ) {
                Button(onClick = { mostrarBoton = false }) {
                    Text("Ocultar botón")
                }
            }

            // Modo claro / oscuro con AnimatedContent
            AnimatedContent(
                targetState = modoOscuro,
                transitionSpec = {
                    fadeIn(tween(400)) with fadeOut(tween(400))
                },
                label = "ModoClaroOscuro"
            ) { esOscuro ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = if (esOscuro) "🌙 Modo Oscuro" else "🌞 Modo Claro",
                        color = if (esOscuro) Color.White else Color.Black,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = { modoOscuro = !modoOscuro }) {
                        Text("Cambiar Modo")
                    }
                }
            }
        }
    }
}