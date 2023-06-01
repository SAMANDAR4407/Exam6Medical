package uz.gita.exam6medical.presentation.ui.signup.viewmodel

import androidx.lifecycle.LiveData

interface SignUpViewModel {
    val buttonEnabledState: LiveData<Boolean>
    val openFillProfilePage: LiveData<Unit>
    val errorHandler: LiveData<String>
    fun signUp(email: String, password: String, remember: Boolean)
    fun textChanged(email: String, password: String)
}