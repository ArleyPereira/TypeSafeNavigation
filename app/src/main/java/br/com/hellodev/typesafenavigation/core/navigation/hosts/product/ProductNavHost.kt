package br.com.hellodev.typesafenavigation.core.navigation.hosts.product

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import br.com.hellodev.typesafenavigation.core.navigation.hosts.cart.cartNavHost
import br.com.hellodev.typesafenavigation.core.navigation.routes.cart.CartRoutes
import br.com.hellodev.typesafenavigation.core.navigation.routes.product.ProductRoutes
import br.com.hellodev.typesafenavigation.presenter.features.details.ProductDetailsScreen
import br.com.hellodev.typesafenavigation.presenter.features.list.ProductListScreen

fun NavGraphBuilder.productNavHost(navController: NavHostController) {
    navigation<ProductRoutes.Graph>(
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
                navigateToCartScreen = {
                    navController.navigate(
                        CartRoutes.Cart(
                            id = details.id,
                            name = details.name,
                        )
                    )
                },
                onBackPressed = { navController.popBackStack() }
            )
        }

        cartNavHost(navController = navController)
    }
}