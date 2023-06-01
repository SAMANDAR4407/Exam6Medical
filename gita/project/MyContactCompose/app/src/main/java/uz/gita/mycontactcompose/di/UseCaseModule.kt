package uz.gita.mycontactcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mycontactcompose.ui.usecase.UseCase
import uz.gita.mycontactcompose.ui.usecase.UseCaseImpl

/**
 *    Created by Kamolov Samandar on 29.05.2023 at 16:27
 */
@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindUseCase(impl: UseCaseImpl): UseCase
}