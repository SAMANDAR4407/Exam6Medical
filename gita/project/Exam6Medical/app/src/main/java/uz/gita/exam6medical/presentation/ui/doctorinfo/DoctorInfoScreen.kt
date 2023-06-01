package uz.gita.exam6medical.presentation.ui.doctorinfo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import uz.gita.exam6medical.R
import uz.gita.exam6medical.databinding.ScreenDoctorInfoBinding

/**
 *    Created by Kamolov Samandar on 29.05.2023 at 11:02
 */
class DoctorInfoScreen : Fragment(R.layout.screen_doctor_info) {
    private val binding by viewBinding(ScreenDoctorInfoBinding::bind)
    private val args: DoctorInfoScreenArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val data = args.data
        binding.apply {
            Glide.with(image).load(data.imageUrl).into(image)
            name.text = data.fullName
            rating.text = data.rating
            reviews.text = data.reviews
            specialty.text = data.specialty
            patients.text = data.patients
            workAddress.text = data.hospital
            description.text = data.about
            experience.text = data.experience
            pageTitle.text = data.fullName

            btnBooking.setOnClickListener {
                Toast.makeText(requireContext(), "Booking", Toast.LENGTH_SHORT).show()
            }
            btnLike.setOnClickListener {
                Toast.makeText(requireContext(), "Liked", Toast.LENGTH_SHORT).show()
            }
            btnMore.setOnClickListener {
                Toast.makeText(requireContext(), "Top Menu", Toast.LENGTH_SHORT).show()
            }
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}