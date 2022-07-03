package com.hexagonteam.itinterview.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.hexagonteam.itinterview.Greeting
import com.hexagonteam.itinterview.android.theme.ItInterviewTheme

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItInterviewTheme {
                Text(text = greet())
            }
        }
    }
}
