package br.com.hellodev.typesafenavigation.core.navigation.hosts.onboarding

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.hellodev.typesafenavigation.core.navigation.hosts.product.productNavHost
import br.com.hellodev.typesafenavigation.core.navigation.routes.onboarding.OnboardingRoutes
import br.com.hellodev.typesafenavigation.core.navigation.routes.product.ProductRoutes
import br.com.hellodev.typesafenavigation.presenter.features.onboarding.SplashScreen

@Composable
fun OnboardingNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = OnboardingRoutes.Splash
    ) {
        composable<OnboardingRoutes.Splash> {
            SplashScreen(
                navigateToProductListScreen = {
                    navController.navigate(ProductRoutes.Graph) {
                        popUpTo(OnboardingRoutes.Splash) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        productNavHost(navController = navController)
    }
}