package uz.gita.exam6medical.presentation.ui.splash.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.exam6medical.data.source.local.PrefHelper
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val shared: PrefHelper
) : ViewModel() {

    var openNextScreenLiveData = MutableLiveData<Unit>()
    var openOnBoardingPageLD = MutableLiveData<Unit>()
    var openLoginScreenLiveData = MutableLiveData<Unit>()
    var openHomeScreenLiveData = MutableLiveData<Unit>()

    init {
        if (shared.firstSetup) {
            openOnBoardingPageLD.value = Unit
            shared.firstSetup = false
        } else if (shared.isSignedIn) {
            openHomeScreenLiveData.value = Unit
        } else
            openLoginScreenLiveData.value = Unit
    }

}