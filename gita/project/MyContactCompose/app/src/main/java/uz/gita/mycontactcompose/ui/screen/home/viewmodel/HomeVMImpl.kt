package uz.gita.mycontactcompose.ui.screen.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import uz.gita.mycontactcompose.data.model.ContactData
import uz.gita.mycontactcompose.domain.AppRepository
import uz.gita.mycontactcompose.ui.screen.home.HomeContract
import uz.gita.mycontactcompose.ui.usecase.UseCase
import javax.inject.Inject

/**
 *    Created by Kamolov Samandar on 29.05.2023 at 15:47
 */

@HiltViewModel
class HomeVMImpl @Inject constructor(
    private val repository: AppRepository
): ViewModel(), HomeContract.ViewModel{

    init {
        repository.getContacts()
            .onEach { contacts -> uiState.update { it.copy(contacts = contacts) } }
            .launchIn(viewModelScope)
    }

    override val uiState: MutableStateFlow<HomeContract.UIState> = MutableStateFlow(HomeContract.UIState())

    override fun onEventDispatcher(intent: HomeContract.Intent) {
        when(intent){
            is HomeContract.Intent.OpedEditScreen -> { uiState.update { it.copy(currentData = intent.contact, editContactState = true) } }
            is HomeContract.Intent.CloseAddScreen -> { uiState.update { it.copy(addContactState = false, editContactState = false) } }
            is HomeContract.Intent.Delete -> { repository.delete(intent.contact) }
            is HomeContract.Intent.OpenAddScreen -> { uiState.update { it.copy(addContactState = true, currentData = intent.contact) } }
        }
    }
}