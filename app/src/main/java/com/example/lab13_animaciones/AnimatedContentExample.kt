package com.example.lab13_animaciones

import androidx.compose.runtime.Composable
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

enum class EstadoPantalla {
    CARGANDO, CONTENIDO, ERROR
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentExample() {
    var estado by remember { mutableStateOf(EstadoPantalla.CARGANDO) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedContent(
            targetState = estado,
            transitionSpec = {
                fadeIn(animationSpec = tween(500)) with
                        fadeOut(animationSpec = tween(500))
            },
            label = "AnimatedContentCambio"
        ) { targetEstado ->
            when (targetEstado) {
                EstadoPantalla.CARGANDO -> Text("⏳ Cargando...",
                    style = MaterialTheme.typography.headlineMedium)
                EstadoPantalla.CONTENIDO -> Text("✅ Contenido cargado",
                    style = MaterialTheme.typography.headlineMedium)
                EstadoPantalla.ERROR -> Text("❌ Ocurrió un error",
                    style = MaterialTheme.typography.headlineMedium)
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        // Botones para cambiar de estado
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { estado = EstadoPantalla.CARGANDO }) {
                Text("Cargar")
            }
            Button(onClick = { estado = EstadoPantalla.CONTENIDO }) {
                Text("Mostrar")
            }
            Button(onClick = { estado = EstadoPantalla.ERROR }) {
                Text("Error")
            }
        }
    }
}
