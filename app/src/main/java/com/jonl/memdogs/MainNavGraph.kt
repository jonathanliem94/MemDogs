package com.jonl.memdogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jonl.memdogs.ui.memorytest.MemoryTestScreen
import com.jonl.memdogs.ui.referencelist.ReferenceListScreen

@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Routes.REFERENCE_LIST_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Routes.MEMORY_TEST_ROUTE) {
            MemoryTestScreen()
        }
        composable(Routes.REFERENCE_LIST_ROUTE) {
            ReferenceListScreen()
        }
    }

}


/**
 * Destinations used in the [MainActivity]
 */
object Routes {
    const val MEMORY_TEST_ROUTE = "memory_test"
    const val REFERENCE_LIST_ROUTE = "reference_list"
}

