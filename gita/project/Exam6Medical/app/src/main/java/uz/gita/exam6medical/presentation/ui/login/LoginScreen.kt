package uz.gita.exam6medical.presentation.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.exam6medical.presentation.ui.login.viewmodel.LoginViewModel
import uz.gita.exam6medical.R
import uz.gita.exam6medical.databinding.SignInScreenBinding
import uz.gita.exam6medical.presentation.ui.login.viewmodel.impl.LoginViewModelImpl

@AndroidEntryPoint
class LoginScreen : Fragment(R.layout.sign_in_screen) {
    private val binding: SignInScreenBinding by viewBinding(SignInScreenBinding::bind)
    private val viewModel: LoginViewModel by viewModels<LoginViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openHomeScreenLD.observe(this, openHomeScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachObservers()

        binding.apply {
            emailInput.doAfterTextChanged {
                val email = emailInput.text.toString()
                val password = passwordInput.text.toString()
                viewModel.textChanged(email, password)
            }
            passwordInput.doAfterTextChanged {
                val email = emailInput.text.toString()
                val password = passwordInput.text.toString()
                viewModel.textChanged(email, password)
            }
            btnSignIn.setOnClickListener {
                val email = emailInput.text.toString()
                val password = passwordInput.text.toString()
                val isChecked = remember.isChecked
                viewModel.signIn(email, password, isChecked)
            }
            btnSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_loginScreen_to_signUpScreen)
            }
        }
    }

    private fun attachObservers() {
        viewModel.errorHandler.observe(viewLifecycleOwner, errorHandlerObserver)
        viewModel.buttonEnabledState.observe(viewLifecycleOwner, buttonEnabledStateObserver)
    }


    private val openHomeScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_loginScreen_to_hostFragment)
    }

    private val errorHandlerObserver = Observer<String> { error ->
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    private val buttonEnabledStateObserver = Observer<Boolean> {
        binding.btnSignIn.isEnabled = it
    }
}