package com.example.customklist.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data class for items
data class Coin(val name: String, val price: String)

// Composable list item
@Composable
fun KListItem(coin: Coin) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = coin.name,
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                color = androidx.compose.ui.graphics.Color.Black,
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Price: ${coin.price}",
                fontSize = 16.sp,
                color = androidx.compose.ui.graphics.Color.DarkGray,
            )
        }
    }
}