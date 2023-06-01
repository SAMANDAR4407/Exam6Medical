package uz.gita.exam6medical.presentation.ui.doctors.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.exam6medical.presentation.ui.doctors.viewmodel.AllDoctorsViewModel
import uz.gita.exam6medical.data.model.common.DoctorData
import uz.gita.exam6medical.domain.repository.home.HomeRepository
import javax.inject.Inject

@HiltViewModel
class AllDoctorsViewModelImpl @Inject constructor(
    private val homeRepository: HomeRepository
) : AllDoctorsViewModel, ViewModel() {
    override val getAllDoctorsLD = MutableLiveData<List<DoctorData>>()
    override val openAllSpecialtiesLD = MutableLiveData<Unit>()
    override val getAllGeneralsLD = MutableLiveData<List<DoctorData>>()
    override val getAllDentistsLD = MutableLiveData<List<DoctorData>>()
    override val getAllOphthalmologistsLD = MutableLiveData<List<DoctorData>>()
    override val getAllNutritionistsLD = MutableLiveData<List<DoctorData>>()
    override val getAllNeurologistsLD = MutableLiveData<List<DoctorData>>()
    override val getAllPediatricLD = MutableLiveData<List<DoctorData>>()
    override val getAllRadiologistsLD = MutableLiveData<List<DoctorData>>()
    override val errorHandlerLD = MutableLiveData<String>()
    override val getAllCardiologistsLD = MutableLiveData<List<DoctorData>>()
    override val getAllImmunologistsLD = MutableLiveData<List<DoctorData>>()
    override val getAllAllergistsLD = MutableLiveData<List<DoctorData>>()

    override val openDetailsScreenLD = MutableLiveData<Unit>()
//        get() = TODO("Not yet implemented")

    override fun getAllDoctors() {
        homeRepository.getAllDoctors().onEach {
            it.onSuccess { list ->
                getAllDoctorsLD.value = list
            }
            it.onFailure { error ->
                errorHandlerLD.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getAllGeneral() {
        homeRepository.getAllGeneral().onEach {
            it.onSuccess { list ->
                getAllGeneralsLD.value = list
            }
            it.onFailure { error ->
                errorHandlerLD.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getAllDentists() {
        homeRepository.getAllDentists().onEach {
            it.onSuccess { list ->
                getAllDentistsLD.value = list
            }
            it.onFailure { error ->
                errorHandlerLD.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getAllOphthalmologists() {
        homeRepository.getAllOphthalmologists().onEach {
            it.onSuccess { list ->
                getAllOphthalmologistsLD.value = list
            }
            it.onFailure { error ->
                errorHandlerLD.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getAllNutritionists() {
        homeRepository.getAllNutritionists().onEach {
            it.onSuccess { list ->
                getAllNutritionistsLD.value = list
            }
            it.onFailure { error ->
                errorHandlerLD.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getAllNeurologists() {
        homeRepository.getAllNeurologists().onEach {
            it.onSuccess { list ->
                getAllNeurologistsLD.value = list
            }
            it.onFailure { error ->
                errorHandlerLD.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getAllPediatric() {
        homeRepository.getAllPediatric().onEach {
            it.onSuccess { list ->
                getAllPediatricLD.value = list
            }
            it.onFailure { error ->
                errorHandlerLD.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getAllRadiologists() {
        homeRepository.getAllRadiologists().onEach {
            it.onSuccess { list ->
                getAllRadiologistsLD.value = list
            }
            it.onFailure { error ->
                errorHandlerLD.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getAllCardiologists() {
        homeRepository.getAllCardiologist().onEach {
            it.onSuccess { list ->
                getAllCardiologistsLD.value = list
            }
            it.onFailure { error ->
                errorHandlerLD.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getAllImmunologists() {
        homeRepository.getAllImmunologist().onEach {
            it.onSuccess { list ->
                getAllImmunologistsLD.value = list
            }
            it.onFailure { error ->
                errorHandlerLD.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getAllAllergists() {
        homeRepository.getAllAllergist().onEach {
            it.onSuccess { list ->
                getAllAllergistsLD.value = list
            }
            it.onFailure { error ->
                errorHandlerLD.value = error.message
            }
        }.launchIn(viewModelScope)
    }

}