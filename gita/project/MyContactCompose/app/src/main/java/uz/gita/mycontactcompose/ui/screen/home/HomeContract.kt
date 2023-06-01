package uz.gita.mycontactcompose.ui.screen.home

import kotlinx.coroutines.flow.StateFlow
import uz.gita.mycontactcompose.data.model.ContactData

/**
 *    Created by Kamolov Samandar on 30.05.2023 at 13:15
 */
interface HomeContract {
    sealed interface Intent {
        class OpedEditScreen(val contact: ContactData) : Intent
        class Delete(val contact: ContactData) : Intent
        class OpenAddScreen(val contact: ContactData) : Intent
        object CloseAddScreen : Intent
    }

    data class UIState(
        val contacts: List<ContactData> = listOf(),
        val addContactState: Boolean = false,
        val editContactState: Boolean = false,
        val currentData: ContactData = ContactData(-1,"","","")
    )

    interface ViewModel{
        val uiState: StateFlow<UIState>

        fun onEventDispatcher(intent: Intent)
    }
}