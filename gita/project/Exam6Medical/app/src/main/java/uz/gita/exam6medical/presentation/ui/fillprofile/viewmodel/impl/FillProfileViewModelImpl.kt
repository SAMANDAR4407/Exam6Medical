package uz.gita.exam6medical.presentation.ui.fillprofile.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.exam6medical.presentation.ui.fillprofile.viewmodel.FillProfileViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.exam6medical.data.source.local.PrefHelper
import javax.inject.Inject

@HiltViewModel
class FillProfileViewModelImpl @Inject constructor(
    private val myPrefs: PrefHelper
) : FillProfileViewModel, ViewModel() {
    override val buttonStateEnabledLD = MutableLiveData<Boolean>()
    override val openHomeScreenLD = MutableLiveData<Unit>()

    override fun textChanged(fullName: String, nickName: String, dateOfBirth: String,email: String, gender: String) {
        buttonStateEnabledLD.value =
            fullName.trim().isNotBlank()
                    && nickName.trim().isNotBlank()
                    && dateOfBirth.trim().isNotBlank()
                    && gender.trim().isNotBlank()
                    && email.trim().isNotBlank()
    }

    override fun saveProfileInfo(fullName: String, nickName: String, dateOfBirth: String, email: String, gender: String) {
        myPrefs.currentUserFullName = fullName.trim()
        myPrefs.currentUserNickName = nickName.trim()
        myPrefs.currentUserDateOfBirth = dateOfBirth.trim()
        myPrefs.currentUserEmail = email.trim()
        myPrefs.currentUserGender = gender.trim()
        myPrefs.isProfileFilled = true
        openHomeScreenLD.value = Unit
    }
}