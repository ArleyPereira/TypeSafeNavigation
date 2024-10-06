package br.com.hellodev.typesafenavigation.domain.model

data class Product(
    val id: Int,
    val name: String
) {
    companion object {
        fun getProducts() = listOf(
            Product(1, "Product 1"),
            Product(2, "Product 2"),
            Product(3, "Product 3"),
            Product(4, "Product 4"),
            Product(5, "Product 5"),
        )
    }
}
