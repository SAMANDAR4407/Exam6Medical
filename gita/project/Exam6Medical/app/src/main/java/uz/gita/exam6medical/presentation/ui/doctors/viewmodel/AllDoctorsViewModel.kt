package uz.gita.exam6medical.presentation.ui.doctors.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.exam6medical.data.model.common.DoctorData

interface AllDoctorsViewModel {
    fun getAllDoctors()
    fun getAllGeneral()
    fun getAllDentists()
    fun getAllOphthalmologists()
    fun getAllNutritionists()
    fun getAllNeurologists()
    fun getAllPediatric()
    fun getAllRadiologists()
    fun getAllCardiologists()
    fun getAllImmunologists()
    fun getAllAllergists()

    val openAllSpecialtiesLD: LiveData<Unit>
    val getAllDoctorsLD: LiveData<List<DoctorData>>
    val getAllGeneralsLD: LiveData<List<DoctorData>>
    val getAllDentistsLD: LiveData<List<DoctorData>>
    val getAllOphthalmologistsLD: LiveData<List<DoctorData>>
    val getAllNutritionistsLD: LiveData<List<DoctorData>>
    val getAllNeurologistsLD: LiveData<List<DoctorData>>
    val getAllPediatricLD: LiveData<List<DoctorData>>
    val getAllRadiologistsLD: LiveData<List<DoctorData>>
    val getAllCardiologistsLD: LiveData<List<DoctorData>>
    val getAllImmunologistsLD: LiveData<List<DoctorData>>
    val getAllAllergistsLD: LiveData<List<DoctorData>>

    val errorHandlerLD: LiveData<String>
    val openDetailsScreenLD: LiveData<Unit>
}