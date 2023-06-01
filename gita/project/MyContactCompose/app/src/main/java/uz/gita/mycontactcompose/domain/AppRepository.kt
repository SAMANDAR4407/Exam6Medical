package uz.gita.mycontactcompose.domain

import kotlinx.coroutines.flow.Flow
import uz.gita.mycontactcompose.data.model.ContactData

/**
 *    Created by Kamolov Samandar on 26.05.2023 at 16:48
 */

interface AppRepository {

    suspend fun add(contactData: ContactData)
    fun delete(contactData: ContactData)
    fun update(contactData: ContactData)
    fun getContacts(): Flow<List<ContactData>>
}