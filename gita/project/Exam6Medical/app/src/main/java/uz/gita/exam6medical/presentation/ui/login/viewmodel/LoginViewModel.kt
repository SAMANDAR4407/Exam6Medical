package uz.gita.exam6medical.presentation.ui.login.viewmodel

import androidx.lifecycle.LiveData


interface LoginViewModel {
    val openHomeScreenLD: LiveData<Unit>
    val buttonEnabledState: LiveData<Boolean>
    val errorHandler: LiveData<String>
    fun signIn(email: String, password: String, remember: Boolean)
    fun textChanged(email: String, password: String)
}