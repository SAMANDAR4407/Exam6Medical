package uz.gita.mycontactcompose.domain

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import uz.gita.mycontactcompose.data.local.room.dao.ContactDao
import uz.gita.mycontactcompose.data.model.ContactData
import javax.inject.Inject

/**
 *    Created by Kamolov Samandar on 26.05.2023 at 16:49
 */
class AppRepositoryImpl @Inject constructor(
    private val dao: ContactDao
): AppRepository {

    override suspend fun add(contactData: ContactData) {
        withContext(Dispatchers.IO){
            dao.addContact(contactData.toEntity())
        }
    }

    override fun delete(contactData: ContactData) {
        dao.delete(contactData.toEntity())
    }

    override fun update(contactData: ContactData) {
        dao.updateContact(contactData.toEntity())
    }

    override fun getContacts(): Flow<List<ContactData>> =
        dao.getContacts().map {
            it.map { entity ->
                entity.toData()
            }
        }
}