package uz.gita.mycontactcompose.ui.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.mycontactcompose.data.model.ContactData

/**
 *    Created by Kamolov Samandar on 29.05.2023 at 16:22
 */
interface UseCase {
    suspend fun addContact(contact: ContactData)
    fun update(contact: ContactData)
    fun delete(contact: ContactData)
    fun getContacts(): Flow<List<ContactData>>
}