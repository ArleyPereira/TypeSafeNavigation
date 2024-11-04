package br.com.hellodev.typesafenavigation.core.navigation.routes.onboarding

import kotlinx.serialization.Serializable

sealed class OnboardingRoutes {

    @Serializable
    data object Splash : OnboardingRoutes()

}