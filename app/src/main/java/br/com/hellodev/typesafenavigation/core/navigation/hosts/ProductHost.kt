package br.com.hellodev.typesafenavigation.core.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import br.com.hellodev.typesafenavigation.core.navigation.routes.ProductRoutes
import br.com.hellodev.typesafenavigation.presenter.features.details.ProductDetailsScreen
import br.com.hellodev.typesafenavigation.presenter.features.list.ProductListScreen

@Composable
fun ProductHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ProductRoutes.List
    ) {
        composable<ProductRoutes.List> {
            ProductListScreen(
                navigateToDetails = { product ->
                    navController.navigate(ProductRoutes.Details(product.id, product.name))
                }
            )
        }

        composable<ProductRoutes.Details> { backStackEntry ->
            val details: ProductRoutes.Details = backStackEntry.toRoute()
            ProductDetailsScreen(
                id = details.id,
                name = details.name,
                onBackPress = { navController.popBackStack() }
            )
        }
    }
}