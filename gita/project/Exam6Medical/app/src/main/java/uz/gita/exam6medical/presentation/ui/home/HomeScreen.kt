package uz.gita.exam6medical.presentation.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.exam6medical.presentation.ui.home.viewmodel.HomeViewModel
import uz.gita.exam6medical.presentation.ui.home.viewmodel.impl.HomeViewModelImpl
import uz.gita.exam6medical.R
import uz.gita.exam6medical.data.source.local.PrefHelper
import uz.gita.exam6medical.databinding.ScreenHomeBinding
import javax.inject.Inject

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {

    @Inject
    lateinit var shared: PrefHelper
    private val binding: ScreenHomeBinding by viewBinding(ScreenHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openAllSpecialtiesLD.observe(this, openAllSpecialtiesObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachObservers()
        binding.apply {
            txtFullName.text = shared.currentUserFullName

            btnSeeAll.setOnClickListener {
                viewModel.getAllGeneral()
            }

            btnGeneral.setOnClickListener {
                viewModel.getAllGeneral()
            }

            btnDentist.setOnClickListener {
                viewModel.getAllDentists()
            }

            btnOphthalmologist.setOnClickListener {
                viewModel.getAllOphthalmologists()
            }

            btnNutritionist.setOnClickListener {
                viewModel.getAllNutritionists()
            }

            btnNeurologist.setOnClickListener {
                viewModel.getAllNeurologists()
            }

            btnPediatric.setOnClickListener {
                viewModel.getAllPediatric()
            }

            btnRadiologist.setOnClickListener {
                viewModel.getAllRadiologists()
            }

            btnMore.setOnClickListener {
                viewModel.getMore()
            }
        }
    }

    private fun attachObservers() {
        viewModel.getAllGeneralsLD.observe(viewLifecycleOwner, getAllGeneralsObserver)
        viewModel.getAllDentistsLD.observe(viewLifecycleOwner, getAllDentistsObserver)
        viewModel.getAllOphthalmologistsLD.observe(viewLifecycleOwner, getAllOphthalmologistsObserver)
        viewModel.getAllNutritionistsLD.observe(viewLifecycleOwner, getAllNutritionistsObserver)
        viewModel.getAllNeurologistsLD.observe(viewLifecycleOwner, getAllNeurologistsObserver)
        viewModel.getAllPediatricLD.observe(viewLifecycleOwner, getAllPediatricObserver)
        viewModel.getAllRadiologistsLD.observe(viewLifecycleOwner, getAllRadiologistsObserver)
        viewModel.errorHandlerLD.observe(viewLifecycleOwner, errorHandlerObserver)
    }

    private val openAllSpecialtiesObserver = Observer<Unit> {
        findNavController().navigate(R.id.screenAllDoctors)
    }

    private val getAllGeneralsObserver = Observer<String> {
        val bundle = bundleOf(Pair("B",it))
        findNavController().navigate(R.id.screenAllDoctors,bundle)
    }
    private val getAllDentistsObserver = Observer<String> {
        val bundle = bundleOf(Pair("B",it))
        findNavController().navigate(R.id.screenAllDoctors,bundle)
    }
    private val getAllOphthalmologistsObserver = Observer<String> {
        val bundle = bundleOf(Pair("B",it))
        findNavController().navigate(R.id.screenAllDoctors,bundle)
    }
    private val getAllNutritionistsObserver = Observer<String> {
        val bundle = bundleOf(Pair("B",it))
        findNavController().navigate(R.id.screenAllDoctors,bundle)
    }
    private val getAllNeurologistsObserver = Observer<String> {
        val bundle = bundleOf(Pair("B",it))
        findNavController().navigate(R.id.screenAllDoctors,bundle)
    }
    private val getAllPediatricObserver = Observer<String> {
        val bundle = bundleOf(Pair("B",it))
        findNavController().navigate(R.id.screenAllDoctors,bundle)
    }
    private val getAllRadiologistsObserver = Observer<String> {
        val bundle = bundleOf(Pair("B",it))
        findNavController().navigate(R.id.screenAllDoctors,bundle)
    }
    private val errorHandlerObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }
}