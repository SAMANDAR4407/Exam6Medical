package uz.gita.mycontactcompose.data.model

import uz.gita.mycontactcompose.data.local.room.entity.ContactEntity

/**
 *    Created by Kamolov Samandar on 26.05.2023 at 16:34
 */
data class ContactData(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String,
){
    fun toEntity() = ContactEntity(id, firstName, lastName, phone)
}
