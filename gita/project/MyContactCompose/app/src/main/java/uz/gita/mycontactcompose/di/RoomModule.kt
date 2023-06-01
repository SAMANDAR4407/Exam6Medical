package uz.gita.mycontactcompose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.mycontactcompose.data.local.room.dao.ContactDao
import uz.gita.mycontactcompose.data.local.room.database.AppDatabase
import javax.inject.Singleton

/**
 *    Created by Kamolov Samandar on 26.05.2023 at 16:57
 */

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @[Provides Singleton]
    fun provideDB(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "Contact")
        .allowMainThreadQueries()
        .build()

    @[Provides Singleton]
    fun provideDao(db: AppDatabase): ContactDao = db.getDao()
}