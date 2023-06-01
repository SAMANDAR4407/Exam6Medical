package uz.gita.exam6medical.presentation.ui.fillprofile

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.exam6medical.presentation.ui.fillprofile.viewmodel.FillProfileViewModel
import uz.gita.exam6medical.presentation.ui.fillprofile.viewmodel.impl.FillProfileViewModelImpl
import uz.gita.exam6medical.R
import uz.gita.exam6medical.databinding.FillYourProfileBinding

@AndroidEntryPoint
class FillProfileScreen : Fragment(R.layout.fill_your_profile) {
    private val binding: FillYourProfileBinding by viewBinding(FillYourProfileBinding::bind)
    private val viewModel: FillProfileViewModel by viewModels<FillProfileViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openHomeScreenLD.observe(this, openHomeScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.buttonStateEnabledLD.observe(viewLifecycleOwner, buttonStateEnabledObserver)
        binding.apply {
            etFullName.doAfterTextChanged {
                val fullName = etFullName.text.toString()
                val nickName = etNickName.text.toString()
                val dateOfBirth = etDateOfBirth.text.toString()
                val email = etEmail.text.toString()
                val gender = selector.text.toString()

                viewModel.textChanged(fullName, nickName, dateOfBirth, email, gender)
            }
            etNickName.doAfterTextChanged {
                val fullName = etFullName.text.toString()
                val nickName = etNickName.text.toString()
                val dateOfBirth = etDateOfBirth.text.toString()
                val email = etEmail.text.toString()
                val gender = selector.text.toString()

                viewModel.textChanged(fullName, nickName, dateOfBirth, email, gender)
            }
            etDateOfBirth.doAfterTextChanged {
                val fullName = etFullName.text.toString()
                val nickName = etNickName.text.toString()
                val dateOfBirth = etDateOfBirth.text.toString()
                val email = etEmail.text.toString()
                val gender = selector.text.toString()

                viewModel.textChanged(fullName, nickName, dateOfBirth, email, gender)
            }
            selector.doAfterTextChanged {
                val fullName = etFullName.text.toString()
                val nickName = etNickName.text.toString()
                val dateOfBirth = etDateOfBirth.text.toString()
                val email = etEmail.text.toString()
                val gender = selector.text.toString()

                viewModel.textChanged(fullName, nickName, dateOfBirth, email, gender)
            }
        }
        binding.apply {
            btnContinue.setOnClickListener {
                val fullName = etFullName.text.toString()
                val nickName = etNickName.text.toString()
                val dateOfBirth = etDateOfBirth.text.toString()
                val email = etEmail.text.toString()
                val gender = selector.text.toString()

                viewModel.saveProfileInfo(fullName, nickName, dateOfBirth, email, gender)
            }
        }
    }

    private val buttonStateEnabledObserver = Observer<Boolean> {
        binding.btnContinue.isEnabled = it
    }

    private val openHomeScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_fillProfileScreen_to_hostFragment)
    }
}