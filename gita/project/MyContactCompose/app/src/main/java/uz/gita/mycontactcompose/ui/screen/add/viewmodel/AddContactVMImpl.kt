package uz.gita.mycontactcompose.ui.screen.add.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.mycontactcompose.data.model.ContactData
import uz.gita.mycontactcompose.domain.AppRepository
import javax.inject.Inject

/**
 *    Created by Kamolov Samandar on 29.05.2023 at 15:15
 */

@HiltViewModel
class AddContactVMImpl @Inject constructor(
    private val repository: AppRepository
): AddContactVM, ViewModel() {

    override fun addContact(firstName: String, lastName: String, phone: String) {
        viewModelScope.launch {
            repository.add(ContactData(0,firstName, lastName, phone))
        }
    }

    override fun update(contact: ContactData) {
        repository.update(contact)
    }
}