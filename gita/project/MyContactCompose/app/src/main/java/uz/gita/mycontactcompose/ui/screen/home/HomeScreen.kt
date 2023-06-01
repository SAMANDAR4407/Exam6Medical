package uz.gita.mycontactcompose.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.gita.mycontactcompose.data.model.ContactData
import uz.gita.mycontactcompose.ui.components.ContactItem
import uz.gita.mycontactcompose.ui.screen.add.AddScreen
import uz.gita.mycontactcompose.ui.screen.home.viewmodel.HomeVM
import uz.gita.mycontactcompose.ui.screen.home.viewmodel.HomeVMImpl

/**
 *    Created by Kamolov Samandar on 29.05.2023 at 15:08
 */

class HomeScreen : AndroidScreen(){
    @Composable
    override fun Content() {
        val viewModel: HomeContract.ViewModel = getViewModel<HomeVMImpl>()
        val uiState = viewModel.uiState.collectAsState().value
        HomeScreenContent(uiState,viewModel::onEventDispatcher)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContent(uiState: HomeContract.UIState, onEventDispatcher: (HomeContract.Intent)->Unit){
    val navigator = LocalNavigator.currentOrThrow

    if (uiState.addContactState){
        navigator.push(AddScreen(uiState.currentData))
        onEventDispatcher(HomeContract.Intent.CloseAddScreen)
    }
    if (uiState.editContactState){
        navigator.push(AddScreen(uiState.currentData))
        onEventDispatcher(HomeContract.Intent.CloseAddScreen)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Contacts", modifier = Modifier.padding(start = 15.dp))
                }
            )
        },
            floatingActionButton = {
                Card(
                    modifier = Modifier.size(60.dp),
                    colors = CardDefaults.cardColors(Color.LightGray),
                    shape = RoundedCornerShape(100.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .clickable {
                                onEventDispatcher(HomeContract.Intent.OpenAddScreen(ContactData(-1,"","","")))
                            }
                            .padding(20.dp),
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ){
            items(uiState.contacts){ data->
                ContactItem(firstName = data.firstName, lastName = data.lastName, phone = data.phone,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .combinedClickable(
                            onClick = { onEventDispatcher(HomeContract.Intent.OpedEditScreen(data)) },
                            onLongClick = { onEventDispatcher(HomeContract.Intent.Delete(data)) })
                )
            }
        }
    }
}