package uz.gita.exam6medical.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.exam6medical.data.source.local.PrefHelper
import uz.gita.exam6medical.data.source.local.PrefHelperImpl
import javax.inject.Singleton

/**
 *    Created by Kamolov Samandar on 15.05.2023 at 17:20
 */

@Module
@InstallIn(SingletonComponent::class)
class SharedPrefModule {

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("ContactApp", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun myPrefHelper( pref: SharedPreferences) : PrefHelper = PrefHelperImpl(pref)
}