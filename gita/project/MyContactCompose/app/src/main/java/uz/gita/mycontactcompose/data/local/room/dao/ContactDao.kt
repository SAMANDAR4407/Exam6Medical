package uz.gita.mycontactcompose.data.local.room.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.gita.mycontactcompose.data.local.room.entity.ContactEntity

/**
 *    Created by Kamolov Samandar on 26.05.2023 at 16:24
 */

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addContact(entity: ContactEntity)

    @Update
    fun updateContact(entity: ContactEntity)

    @Delete
    fun delete(entity: ContactEntity)

    @Query("select * from contacts")
    fun getContacts(): Flow<List<ContactEntity>>
}