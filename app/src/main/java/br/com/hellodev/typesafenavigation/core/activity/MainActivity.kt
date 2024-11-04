package br.com.hellodev.typesafenavigation.core.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import br.com.hellodev.typesafenavigation.core.navigation.hosts.onboarding.OnboardingNavHost
import br.com.hellodev.typesafenavigation.presenter.ui.theme.TypeSafeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypeSafeNavigationTheme {
                OnboardingNavHost(navController = rememberNavController())
            }
        }
    }
}
