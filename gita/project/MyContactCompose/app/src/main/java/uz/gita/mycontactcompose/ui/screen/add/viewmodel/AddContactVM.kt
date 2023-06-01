package uz.gita.mycontactcompose.ui.screen.add.viewmodel

import uz.gita.mycontactcompose.data.model.ContactData

/**
 *    Created by Kamolov Samandar on 29.05.2023 at 15:14
 */

interface AddContactVM {
    fun addContact(firstName: String, lastName: String, phone: String)
    fun update(contact: ContactData)
}