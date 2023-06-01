package uz.gita.mycontactcompose.ui.screen.add

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.gita.mycontactcompose.data.model.ContactData
import uz.gita.mycontactcompose.ui.components.MyTextField
import uz.gita.mycontactcompose.ui.screen.add.viewmodel.AddContactVM
import uz.gita.mycontactcompose.ui.screen.add.viewmodel.AddContactVMImpl

/**
 *    Created by Kamolov Samandar on 29.05.2023 at 15:17
 */

class AddScreen(val contact: ContactData) : AndroidScreen(){
    @Composable
    override fun Content(){
        val viewModel = getViewModel<AddContactVMImpl>()
        AddScreenContent(viewModel = viewModel,contact)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreenContent(viewModel: AddContactVM, contact: ContactData){

    var firstName by remember{
        mutableStateOf(contact.firstName)
    }
    var lastName by remember{
        mutableStateOf(contact.lastName)
    }
    var phone by remember{
        mutableStateOf(contact.phone)
    }

    val navigator = LocalNavigator.currentOrThrow

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Add Contact")
                },
                navigationIcon = {
                    Image(
                        modifier = Modifier.clickable { navigator.pop() },
                        imageVector = Icons.Default.Close,
                        contentDescription = null)
                }
            )
        },
    ) {  contentPadding ->

        Column(
            modifier = Modifier.padding(contentPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp), "First name", value = firstName, onValueChange = { firstName = it })
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),"Last name", value = lastName, onValueChange = { lastName = it })
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp), "Phone number", value = phone, onValueChange = { phone = it })

            ElevatedButton(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 10.dp),
                onClick = {
                    if(contact.id != -1){
                        viewModel.update(ContactData(id = contact.id,firstName = firstName, lastName = lastName, phone = phone))
                    }else{
                        viewModel.addContact(firstName, lastName, phone)
                    }
                    navigator.pop()
            }) {
                Text(text = "Add Contact")
            }
        }

    }

}