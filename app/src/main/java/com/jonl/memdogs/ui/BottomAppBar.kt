package com.jonl.memdogs.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.jonl.memdogs.Routes.MEMORY_TEST_ROUTE
import com.jonl.memdogs.Routes.REFERENCE_LIST_ROUTE

internal enum class TabItem(
    val title: String,
    val navGraphRoute: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    MemTest("Memory Test", MEMORY_TEST_ROUTE, Icons.Filled.Favorite, Icons.Outlined.FavoriteBorder),
    RefList("Reference List", REFERENCE_LIST_ROUTE, Icons.Filled.Home, Icons.Outlined.Home),
}

@Composable
fun MainBottomNavigationBar(
    navController: NavHostController
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(TabItem.RefList, TabItem.MemTest)

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) item.selectedIcon else item.unselectedIcon,
                        contentDescription = null,
                    )
                },
                label = { Text(item.title) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.navGraphRoute) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}