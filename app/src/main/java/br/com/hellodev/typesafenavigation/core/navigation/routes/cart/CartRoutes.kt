package br.com.hellodev.typesafenavigation.core.navigation.routes.cart

import kotlinx.serialization.Serializable

sealed class CartRoutes {

    @Serializable
    data object Graph : CartRoutes()

    @Serializable
    data class Cart(
        val id: Int = 0,
        val name: String = ""
    ) : CartRoutes()

}