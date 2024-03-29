package com.baek.priceyay.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.baek.priceyay.ui.navigation.PriceYayDestination
import com.baek.priceyay.ui.navigation.PriceYayGraph

@Composable
fun PriceYayApp(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { PriceYayBottomAppBar(navController = navController) }
    ) {
        Box(Modifier.padding(it)) {
            PriceYayGraph(navController = navController)
        }
    }
}

@Composable
fun PriceYayBottomAppBar(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val items = listOf<PriceYayDestination>(
        PriceYayDestination.HomeDestination,
        PriceYayDestination.SearchDestination,
        PriceYayDestination.BookmarkDestination,
    )

    BottomAppBar(
        modifier = Modifier.height(60.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    modifier = Modifier.weight(1f),
                    icon = item.icon,
                    selected = currentRoute == item.route,
                    label = item.route
                ) {
                    navController.navigate(item.route)
                }
            }
        }
    }
}

/*
icon image
label text
언제 selected 상태가 될 지
선택됐을 때 icon 색상
선택되지 않았을때 icon 색상
click되면 어떤 행동을 취할지
*/
@Composable
fun BottomNavigationItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    label: String,
    selected: Boolean,
    selectedContentColor: Color = MaterialTheme.colorScheme.primary,
    unselectedContentColor: Color = Color.Gray,
    onClick: () -> Unit = {}
) {
    IconButton(
        onClick = onClick, modifier = modifier,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (selected) selectedContentColor else unselectedContentColor
        )
    }
}

