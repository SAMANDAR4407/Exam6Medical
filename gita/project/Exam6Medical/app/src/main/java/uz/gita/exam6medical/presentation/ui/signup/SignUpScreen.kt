package uz.gita.exam6medical.presentation.ui.signup

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
import uz.gita.exam6medical.R
import uz.gita.exam6medical.databinding.SignUpScreenBinding
import uz.gita.exam6medical.presentation.ui.signup.viewmodel.SignUpViewModel
import uz.gita.exam6medical.presentation.ui.signup.viewmodel.impl.SignUpViewModelImpl

@AndroidEntryPoint
class SignUpScreen : Fragment(R.layout.sign_up_screen) {
    private val binding: SignUpScreenBinding by viewBinding(SignUpScreenBinding::bind)
    private val viewModel: SignUpViewModel by viewModels<SignUpViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openFillProfilePage.observe(this, openFillProfilePageObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

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
            btnSignUp.setOnClickListener {
                val email = emailInput.text.toString()
                val password = passwordInput.text.toString()
                val isChecked = remember.isChecked
                viewModel.signUp(email, password, isChecked)
            }
            btnSignIn.setOnClickListener {
                findNavController().navigate(R.id.action_signUpScreen_to_loginScreen)
            }
        }
    }

    private fun attachObservers() {
        viewModel.errorHandler.observe(viewLifecycleOwner, errorHandlerObserver)
        viewModel.buttonEnabledState.observe(viewLifecycleOwner, buttonEnabledStateObserver)
    }

    private val openFillProfilePageObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_signUpScreen_to_fillProfileScreen)
    }
    private val errorHandlerObserver = Observer<String> { error ->
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }
    private val buttonEnabledStateObserver = Observer<Boolean> {
        binding.btnSignUp.isEnabled = it
    }
}