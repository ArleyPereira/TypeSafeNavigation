package br.com.hellodev.typesafenavigation.core.navigation.routes.product

import kotlinx.serialization.Serializable

sealed class ProductRoutes {

    @Serializable
    data object Graph : ProductRoutes()

    @Serializable
    data object List : ProductRoutes()

    @Serializable
    data class Details(
        val id: Int,
        val name: String
    ) : ProductRoutes()

}