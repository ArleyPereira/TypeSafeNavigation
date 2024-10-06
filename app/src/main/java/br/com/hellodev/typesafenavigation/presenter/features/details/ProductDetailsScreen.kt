package br.com.hellodev.typesafenavigation.presenter.features.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProductDetailsScreen(
    id: Int,
    name: String,
    onBackPress: () -> Unit
) {
    ProductDetailsScreenContent(
        id = id,
        name = name,
        onBackPress = onBackPress
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductDetailsScreenContent(
    id: Int,
    name: String,
    onBackPress: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Details") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "id: $id")
                Text(text = "name: $name")
            }
        }
    )
}

@Preview
@Composable
private fun ProductDetailsScreenPreview() {
    ProductDetailsScreenContent(
        id = 0,
        name = "Product 0",
        onBackPress = {}
    )
}