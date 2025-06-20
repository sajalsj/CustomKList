package com.example.customklist.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.customklist.components.Coin
import com.example.customklist.components.KListItem
import com.example.customklist.dsl.KList

@Composable
fun KListDemo() {
    val coins = listOf(
        Coin("Bitcoin", "$65,000"),
        Coin("Ethereum", "$4,000"),
        Coin("Solana", "$150")
    )

    val losers = listOf(
        Coin("Dogecoin", "$0.05"),
        Coin("Ripple", "$0.60")
    )

    val context = LocalContext.current
    
    KList {
        padding(16.dp)
        dividers(false)

        section("Top Gainers", coins, onClick = { coin ->
            Toast.makeText(context,coin.name, Toast.LENGTH_SHORT).show()
        }) { coin ->
            KListItem(coin)
        }

        section("Top Losers", losers, onClick = { coin ->
            Toast.makeText(context,coin.name, Toast.LENGTH_SHORT).show()
        }) { coin ->
            KListItem(coin)
        }
    }
}