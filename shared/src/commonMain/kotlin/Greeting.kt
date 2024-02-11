import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import data.RandomUser
import navigation.RootComponent
import screens.ScreenA
import screens.ScreenB

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}

@Composable
fun AppRoot(root: RootComponent, users: State<List<RandomUser>>) {
    MaterialTheme {
        val childStack by root.childStack.subscribeAsState()
        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) { child ->
            when(val instance = child.instance) {
                is RootComponent.Child.ScreenA -> ScreenA(instance.component,)
                is RootComponent.Child.ScreenB -> ScreenB(instance.component.text, instance.component, users.value)
            }
        }
    }
}