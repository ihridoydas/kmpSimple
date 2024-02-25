package com.hridoy.kmpsimple

import App
import AppRoot
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.arkivanov.decompose.ExperimentalDecomposeApi
import navigation.RootComponent
import com.arkivanov.decompose.retainedComponent


class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

    @OptIn(ExperimentalDecomposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val root = retainedComponent {
                RootComponent(
                    componentContext = it
                )
            }
            AppRoot(root, homeViewModel.users.collectAsStateWithLifecycle())

        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}