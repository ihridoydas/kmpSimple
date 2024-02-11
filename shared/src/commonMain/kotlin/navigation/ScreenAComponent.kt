package navigation

import androidx.compose.runtime.toMutableStateList
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import data.RandomUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScreenAComponent (
    componentContext: ComponentContext,
    private val onNavigateToScreenB: (String,MutableStateFlow<List<RandomUser>>) -> Unit,
): ComponentContext by componentContext {

    private val _text = MutableValue("")
    val text : Value<String> = _text

    private val _users = MutableStateFlow<List<RandomUser>>(listOf())
    val users = _users.asStateFlow()


    fun onEvent(event: ScreenAEvent){
        when(event){
            is ScreenAEvent.ClickButtonA -> onNavigateToScreenB(text.value,users.value.toMutableStateList().let { MutableStateFlow(it) })
            is ScreenAEvent.UpdateText -> {
                _text.value = event.text
            }
        }
    }
}