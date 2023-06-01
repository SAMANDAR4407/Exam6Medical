package uz.gita.exam6medical.presentation.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.exam6medical.R
import uz.gita.exam6medical.databinding.SplashScreenBinding
import uz.gita.exam6medical.presentation.ui.splash.viewmodel.SplashViewModel

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.splash_screen) {

    private val viewModel by viewModels<SplashViewModel>()
    private val binding by viewBinding(SplashScreenBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openHomeScreenLiveData.observe(this, openHomePagePageObserver)
        viewModel.openLoginScreenLiveData.observe(this, openLoginPageObserver)
        viewModel.openOnBoardingPageLD.observe(this, openOnBoardingPageObserver)
    }

    private val openOnBoardingPageObserver = Observer<Unit> {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                findNavController().navigate(R.id.action_splashFragment_to_screenEnter)
            }, 1000
        )
    }

    private val openLoginPageObserver = Observer<Unit> {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                findNavController().navigate(R.id.action_splashFragment_to_loginScreen)
            }, 1000
        )
    }

    private val openHomePagePageObserver = Observer<Unit> {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                findNavController().navigate(R.id.action_splashFragment_to_hostFragment)
            }, 1000
        )
    }

}