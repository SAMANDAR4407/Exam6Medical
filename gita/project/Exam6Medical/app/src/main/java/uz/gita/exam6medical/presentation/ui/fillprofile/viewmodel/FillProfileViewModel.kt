package uz.gita.exam6medical.presentation.ui.fillprofile.viewmodel

import androidx.lifecycle.LiveData

interface FillProfileViewModel {
    val buttonStateEnabledLD: LiveData<Boolean>
    val openHomeScreenLD: LiveData<Unit>
    fun textChanged(fullName: String, nickName: String, dateOfBirth: String, email:String, gender: String)
    fun saveProfileInfo(fullName: String, nickName: String, dateOfBirth: String, email:String, gender: String)
}