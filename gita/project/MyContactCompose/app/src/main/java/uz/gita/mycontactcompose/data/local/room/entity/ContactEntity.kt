package uz.gita.mycontactcompose.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.gita.mycontactcompose.data.model.ContactData

/**
 *    Created by Kamolov Samandar on 26.05.2023 at 16:31
 */

@Entity("contacts")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val phone: String,
) {
    fun toData() = ContactData(id, firstName, lastName, phone)
}
