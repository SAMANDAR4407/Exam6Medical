package uz.gita.mycontactcompose.ui.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.mycontactcompose.data.model.ContactData
import uz.gita.mycontactcompose.domain.AppRepository
import javax.inject.Inject

/**
 *    Created by Kamolov Samandar on 29.05.2023 at 16:25
 */
class UseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : UseCase {
    override suspend fun addContact(contact: ContactData) {
        repository.add(contact)
    }

    override fun update(contact: ContactData) {
        update(contact)
    }

    override fun delete(contact: ContactData) {
        repository.delete(contact)
    }

    override fun getContacts(): Flow<List<ContactData>> {
        return repository.getContacts()
    }
}