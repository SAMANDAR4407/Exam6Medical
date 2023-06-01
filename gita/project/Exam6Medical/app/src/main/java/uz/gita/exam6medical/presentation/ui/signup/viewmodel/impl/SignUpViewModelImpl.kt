package uz.gita.exam6medical.presentation.ui.signup.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.exam6medical.presentation.ui.signup.viewmodel.SignUpViewModel
import uz.gita.exam6medical.data.source.local.PrefHelper
import uz.gita.exam6medical.domain.repository.auth.AuthRepository
import javax.inject.Inject

@HiltViewModel
class SignUpViewModelImpl @Inject constructor(
    private val authRepository: AuthRepository,
    private val myPrefs: PrefHelper
) : SignUpViewModel, ViewModel() {

    override val openFillProfilePage = MutableLiveData<Unit>()
    override val errorHandler = MutableLiveData<String>()
    override val buttonEnabledState = MutableLiveData<Boolean>()

    override fun textChanged(email: String, password: String) {
        buttonEnabledState.value =
            email.endsWith(".com") && email.length >= 6
                    && password.length >= 7
    }

    override fun signUp(email: String, password: String, remember: Boolean) {
        authRepository.signUp(email, password).onEach {
            it.onSuccess {
                if (remember) {
                    myPrefs.isSignedIn = true
                    myPrefs.currentUserEmail = email
                }
                openFillProfilePage.value = Unit
            }
            it.onFailure { error ->
                errorHandler.value = error.message
            }
        }.launchIn(viewModelScope)
    }
}