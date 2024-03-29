package com.baek.priceyay.ui.bookmark

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.baek.priceyay.BOOKMARK

@Composable
fun BookmarkScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            BOOKMARK,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}