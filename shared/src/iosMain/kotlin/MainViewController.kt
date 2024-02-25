import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import data.RandomUser
import navigation.RootComponent
import androidx.compose.runtime.mutableStateOf


fun MainViewController() = ComposeUIViewController {
    val root = remember {
        RootComponent(DefaultComponentContext(LifecycleRegistry()))
    }
    val userListState = remember { mutableStateOf<List<RandomUser>>(emptyList()) }
    AppRoot(root, userListState)
}