package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.RandomUser
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import navigation.ScreenBComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi

@Composable
fun ScreenB(text: String, component: ScreenBComponent, users: List<RandomUser>) {
    Scaffold(
        drawerShape = RoundedCornerShape(topEnd = 23.dp, bottomEnd = 23.dp),
        topBar = {
            TopAppBar(
                title = { Text(text = text) },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            component.goBack()
                                  },
                        modifier = Modifier
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                                 },
            )
                 },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                ) {
                
                AndroidApp(users = users)
              
                
            }
        }
    )
    
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun AndroidApp(users: List<RandomUser>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(users, key = { user -> user.login?.uuid.toString() }) { user ->
            Card(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                elevation = 2.dp
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {


                    KamelImage(
                        resource = asyncPainterResource(
                            data = user.picture?.thumbnail.toString()
                        ),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .padding(16.dp)
                            .size(50.dp)
                    )

                    Column(verticalArrangement = Arrangement.Center) {
                        Text(text = "${user.name?.first} ${user.name?.last}")
                        Text(text = user.phone.toString())
                    }
                }

            }
        }
    }
}