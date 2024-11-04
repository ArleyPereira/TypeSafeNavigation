package br.com.hellodev.typesafenavigation.core.navigation.hosts.cart

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import br.com.hellodev.typesafenavigation.core.navigation.routes.cart.CartRoutes
import br.com.hellodev.typesafenavigation.presenter.features.cart.CartScreen

fun NavGraphBuilder.cartNavHost(navController: NavHostController) {
    navigation<CartRoutes.Graph>(
        startDestination = CartRoutes.Cart()
    ) {
        composable<CartRoutes.Cart> { backStackEntry ->
            val cart: CartRoutes.Cart = backStackEntry.toRoute()
            CartScreen(
                id = cart.id,
                name = cart.name,
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}