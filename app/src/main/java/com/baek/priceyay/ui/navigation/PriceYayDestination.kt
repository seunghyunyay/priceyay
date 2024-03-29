package com.baek.priceyay.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.baek.priceyay.BOOKMARK
import com.baek.priceyay.HOME
import com.baek.priceyay.R
import com.baek.priceyay.SEARCH

sealed class PriceYayDestination(val route: String, val titleRes: Int, val icon: ImageVector) {
    object HomeDestination : PriceYayDestination(HOME, R.string.home, Icons.Filled.Home)
    object SearchDestination : PriceYayDestination(SEARCH, R.string.search, Icons.Filled.Search)
    object BookmarkDestination : PriceYayDestination(BOOKMARK, R.string.bookmark, Icons.Filled.FavoriteBorder)
}