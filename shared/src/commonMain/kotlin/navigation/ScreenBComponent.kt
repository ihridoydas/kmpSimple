package navigation

import com.arkivanov.decompose.ComponentContext
import data.RandomUser

class ScreenBComponent(
    val text: String,
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit,
    val users: List<RandomUser>
): ComponentContext by componentContext {

    fun goBack(){
        onGoBack()
    }
}
