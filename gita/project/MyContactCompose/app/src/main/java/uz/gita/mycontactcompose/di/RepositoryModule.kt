package uz.gita.mycontactcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mycontactcompose.domain.AppRepository
import uz.gita.mycontactcompose.domain.AppRepositoryImpl
import javax.inject.Singleton

/**
 *    Created by Kamolov Samandar on 26.05.2023 at 16:46
 */

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindRepository(impl: AppRepositoryImpl): AppRepository
}