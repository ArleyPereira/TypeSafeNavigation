package br.com.hellodev.typesafenavigation.presenter.features.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen(
    navigateToProductListScreen: () -> Unit
) {
    SplashContent(
        navigateToProductListScreen = navigateToProductListScreen
    )
}

@Composable
fun SplashContent(
    navigateToProductListScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = navigateToProductListScreen,
            content = {
                Text("Product List Screen")
            }
        )
    }
}

@Preview
@Composable
private fun SplashPreview() {
    SplashContent(
        navigateToProductListScreen = {}
    )
}