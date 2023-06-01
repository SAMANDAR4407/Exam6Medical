package uz.gita.exam6medical.presentation.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.exam6medical.R
import uz.gita.exam6medical.data.source.local.PrefHelper
import uz.gita.exam6medical.databinding.ProfileScreenBinding
import javax.inject.Inject

/**
 *    Created by Kamolov Samandar on 28.05.2023 at 17:23
 */
@AndroidEntryPoint
class ProfileScreen: Fragment(R.layout.profile_screen) {

    @Inject
    lateinit var shared: PrefHelper
    private val binding by viewBinding(ProfileScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            fullName.text = shared.currentUserFullName
            email.text = shared.currentUserEmail
        }
    }
}