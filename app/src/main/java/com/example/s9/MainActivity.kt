package com.example.s9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.s9.ui.theme.S9Theme

@Composable
fun ControlAcceso(){
    var personasDentro by remember { mutableStateOf( value = 0) }
    var ultimoRegistro by remember { mutableStateOf( value = "Ninguno") }
    var invitado by remember { mutableStateOf( value = "") }

    Column() {
        Text("Control de Aforo")
        Text("Personas adentro: $personasDentro")
        Text("Último registrado: $ultimoRegistro")

        TextField(value=invitado, onValueChange= {invitado=it} )
        Button(
            onClick = {ultimoRegistro=invitado
                personasDentro=personasDentro+1
                invitado="" })
        { Text("Registrar e Ingresar")}

        Row() {
            Button(onClick = {
                if(personasDentro>0){
                    personasDentro=personasDentro-1
                }
            }) {Text("Salida (-1)") }
            Button(onClick = {personasDentro=0
                ultimoRegistro="Ninguno"}) {Text("Reiniciar")}
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S9Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(paddingValues = innerPadding)) {
                        ControlAcceso()
                    }
                }
            }
        }
    }
}