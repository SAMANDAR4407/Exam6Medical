package uz.gita.exam6medical.presentation.ui.login.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.exam6medical.presentation.ui.login.viewmodel.LoginViewModel
import uz.gita.exam6medical.data.source.local.PrefHelper
import uz.gita.exam6medical.domain.repository.auth.AuthRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(
    private val authRepository: AuthRepository,
    private val myPrefs: PrefHelper
) : LoginViewModel, ViewModel() {

    override val buttonEnabledState = MutableLiveData<Boolean>()
    override val errorHandler = MutableLiveData<String>()
    override val openHomeScreenLD = MutableLiveData<Unit>()

    override fun signIn(email: String, password: String, remember: Boolean) {
        authRepository.signIn(email, password).onEach {
            it.onSuccess {
                if (remember) {
                    myPrefs.isSignedIn = true
                    myPrefs.currentUserEmail = email
                }
                openHomeScreenLD.value = Unit
            }
            it.onFailure { error ->
                errorHandler.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun textChanged(email: String, password: String) {
        buttonEnabledState.value =
            email.trim().endsWith(".com")
                    && email.trim().length >= 6
                    && password.length >= 6
    }
}