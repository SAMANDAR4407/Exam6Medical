package uz.gita.exam6medical.presentation.ui.home.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.exam6medical.domain.repository.home.HomeRepository
import uz.gita.exam6medical.presentation.ui.home.viewmodel.HomeViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    private val homeRepository: HomeRepository
) : HomeViewModel, ViewModel() {
    override val openAllSpecialtiesLD = MutableLiveData<Unit>()
    override val getAllGeneralsLD = MutableLiveData<String>()
    override val getAllDentistsLD = MutableLiveData<String>()
    override val getAllOphthalmologistsLD = MutableLiveData<String>()
    override val getAllNutritionistsLD = MutableLiveData<String>()
    override val getAllNeurologistsLD = MutableLiveData<String>()
    override val getAllPediatricLD = MutableLiveData<String>()
    override val getAllRadiologistsLD = MutableLiveData<String>()
    override val errorHandlerLD = MutableLiveData<String>()

    override fun getAllGeneral() {
        getAllGeneralsLD.value = "1"
    }

    override fun getAllDentists() {
        getAllDentistsLD.value = "2"
    }

    override fun getAllOphthalmologists() {
        getAllOphthalmologistsLD.value = "3"
    }

    override fun getAllNutritionists() {
        getAllNutritionistsLD.value = "4"
    }

    override fun getAllNeurologists() {
        getAllNeurologistsLD.value = "5"
    }

    override fun getAllPediatric() {
        getAllPediatricLD.value = "6"
    }

    override fun getAllRadiologists() {
        getAllRadiologistsLD.value = "7"
    }

    override fun getMore() {
        openAllSpecialtiesLD.value = Unit
    }
}