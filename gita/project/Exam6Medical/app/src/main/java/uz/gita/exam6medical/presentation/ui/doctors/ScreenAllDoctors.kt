package uz.gita.exam6medical.presentation.ui.doctors

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uz.gita.exam6medical.R
import uz.gita.exam6medical.data.model.common.DoctorData
import uz.gita.exam6medical.databinding.ScreenDoctorsBinding
import uz.gita.exam6medical.presentation.adapter.MyAdapter
import uz.gita.exam6medical.presentation.ui.doctors.viewmodel.AllDoctorsViewModel
import uz.gita.exam6medical.presentation.ui.doctors.viewmodel.impl.AllDoctorsViewModelImpl

@AndroidEntryPoint
class ScreenAllDoctors : Fragment(R.layout.screen_doctors) {
    private val binding: ScreenDoctorsBinding by viewBinding(ScreenDoctorsBinding::bind)
    private val viewModel: AllDoctorsViewModel by viewModels<AllDoctorsViewModelImpl>()
    private lateinit var adapter: MyAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MyAdapter()
        attachObservers()
        val arg = arguments?.getString("B")
        Timber.tag("GGG").d("onViewCreated: %s", arguments?.getString("B"))
        when (arg) {
            "1" -> {
                viewModel.getAllDoctors()
            }

            "2" -> {
                viewModel.getAllDoctors()
            }

            "3" -> {
                viewModel.getAllDoctors()
            }

            "4" -> {
                viewModel.getAllDoctors()
            }

            "5" -> {
                viewModel.getAllDoctors()
            }

            "6" -> {
                viewModel.getAllDoctors()
            }

            "7" -> {
                viewModel.getAllDoctors()
            }

            else -> {
                viewModel.getAllDoctors()
            }
        }

        binding.apply {
            recyclerViewAllDoctors.adapter = adapter

            btnBack.setOnClickListener{
                findNavController().navigateUp()
            }
        }

        adapter.setClickListener {
            val action = ScreenAllDoctorsDirections.actionScreenAllDoctorsToDoctorInfoScreen(it)
            findNavController().navigate(action)
        }
    }

    private fun attachObservers() {
        viewModel.getAllDoctorsLD.observe(viewLifecycleOwner, getAllDoctorsObserver)
        viewModel.getAllGeneralsLD.observe(viewLifecycleOwner, getAllGeneralsObserver)
        viewModel.getAllDentistsLD.observe(viewLifecycleOwner, getAllDentistsObserver)
        viewModel.getAllOphthalmologistsLD.observe(viewLifecycleOwner, getAllOphthalmologistsObserver)
        viewModel.getAllNutritionistsLD.observe(viewLifecycleOwner, getAllNutritionistsObserver)
        viewModel.getAllNeurologistsLD.observe(viewLifecycleOwner, getAllNeurologistsObserver)
        viewModel.getAllPediatricLD.observe(viewLifecycleOwner, getAllPediatricObserver)
        viewModel.getAllRadiologistsLD.observe(viewLifecycleOwner, getAllRadiologistsObserver)
        viewModel.getAllCardiologistsLD.observe(viewLifecycleOwner, getAllCardiologistsObserver)
        viewModel.getAllImmunologistsLD.observe(viewLifecycleOwner, getAllImmunologistsObserver)
        viewModel.getAllAllergistsLD.observe(viewLifecycleOwner, getAllAllergistsObserver)
    }

    private val getAllDoctorsObserver = Observer<List<DoctorData>> {
        adapter.submitList(it)
    }
    private val getAllGeneralsObserver = Observer<List<DoctorData>> {
        adapter.submitList(it)
    }
    private val getAllDentistsObserver = Observer<List<DoctorData>> {
        adapter.submitList(it)
    }
    private val getAllOphthalmologistsObserver = Observer<List<DoctorData>> {
        adapter.submitList(it)
    }
    private val getAllNutritionistsObserver = Observer<List<DoctorData>> {
        adapter.submitList(it)
    }
    private val getAllNeurologistsObserver = Observer<List<DoctorData>> {
        adapter.submitList(it)
    }
    private val getAllPediatricObserver = Observer<List<DoctorData>> {
        adapter.submitList(it)
    }
    private val getAllRadiologistsObserver = Observer<List<DoctorData>> {
        adapter.submitList(it)
    }
    private val getAllCardiologistsObserver = Observer<List<DoctorData>> {
        adapter.submitList(it)
    }
    private val getAllImmunologistsObserver = Observer<List<DoctorData>> {
        adapter.submitList(it)
    }
    private val getAllAllergistsObserver = Observer<List<DoctorData>> {
        adapter.submitList(it)
    }
}