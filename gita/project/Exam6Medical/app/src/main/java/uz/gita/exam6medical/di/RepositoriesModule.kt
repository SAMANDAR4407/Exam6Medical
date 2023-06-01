package uz.gita.exam6medical.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.exam6medical.domain.repository.auth.AuthRepository
import uz.gita.exam6medical.domain.repository.auth.AuthRepositoryImpl
import uz.gita.exam6medical.domain.repository.home.HomeRepository
import uz.gita.exam6medical.domain.repository.home.HomeRepositoryImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @[Binds Singleton]
    fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @[Binds Singleton]
    fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository

}