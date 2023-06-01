package uz.gita.exam6medical.presentation.ui.appointment

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctors.presentation.ui.screens.main.appointments.viewmodel.AppointmentViewModel
import com.example.doctors.presentation.ui.screens.main.appointments.viewmodel.impl.AppointmentViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.exam6medical.R
import uz.gita.exam6medical.databinding.ScreenAppointmentBinding

@AndroidEntryPoint
class AppointmentScreen : Fragment(R.layout.screen_appointment) {
    private val binding: ScreenAppointmentBinding by viewBinding(ScreenAppointmentBinding::bind)
    private val viewModel: AppointmentViewModel by viewModels<AppointmentViewModelImpl>()

}