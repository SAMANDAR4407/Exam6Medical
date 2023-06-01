package uz.gita.mycontactcompose.ui.screen.home.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.mycontactcompose.data.model.ContactData

/**
 *    Created by Kamolov Samandar on 29.05.2023 at 15:46
 */
interface HomeVM {
    val contactsLD: LiveData<List<ContactData>>
    fun delete(contactData: ContactData)
}