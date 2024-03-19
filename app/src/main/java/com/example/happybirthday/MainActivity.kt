package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    BirthdayScreen()
                }

            }
        }
    }
}

@Composable
fun BirthdayScreen() {
    var showMessage by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Gambar
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Birthday Card",
            modifier = Modifier.size(500.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Tombol
        Button(onClick = { showMessage = !showMessage }) {
            Text(text = if (showMessage) "Hide Message" else "Show Message")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Pesan
        if (showMessage) {
            Text(
                text = "It's your special day—the day you get a free dessert at a restaurant in exchange for being stared at by everyone in the place!",
                fontSize = 24.sp,
                color = Color.Black,
                textAlign = TextAlign.Center

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayScreenPreview() {
    HappyBirthdayTheme {
        BirthdayScreen()
    }
}
