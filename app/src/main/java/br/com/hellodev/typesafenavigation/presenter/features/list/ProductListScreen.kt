package br.com.hellodev.typesafenavigation.presenter.features.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.hellodev.typesafenavigation.domain.model.Product

@Composable
fun ProductListScreen(
    navigateToDetails: (Product) -> Unit
) {
    ProductListContent(
        navigateToDetails = navigateToDetails
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductListContent(
    navigateToDetails: (Product) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Products") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    itemsIndexed(Product.getProducts()) { index, product ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navigateToDetails(product) }
                        ) {
                            Text(text = "id: ${product.id}")
                            Text(text = "name: ${product.name}")

                            if (index < Product.getProducts().lastIndex) {
                                Spacer(modifier = Modifier.height(16.dp))
                                HorizontalDivider()
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun ProductListPreview() {
    ProductListContent(
        navigateToDetails = {}
    )
}