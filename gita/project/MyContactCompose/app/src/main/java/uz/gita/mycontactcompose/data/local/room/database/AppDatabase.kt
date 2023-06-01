package uz.gita.mycontactcompose.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.mycontactcompose.data.local.room.dao.ContactDao
import uz.gita.mycontactcompose.data.local.room.entity.ContactEntity

/**
 *    Created by Kamolov Samandar on 26.05.2023 at 16:42
 */

@Database(entities = [ContactEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getDao(): ContactDao
}