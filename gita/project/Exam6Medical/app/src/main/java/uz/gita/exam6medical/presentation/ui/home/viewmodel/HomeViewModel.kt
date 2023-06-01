package uz.gita.exam6medical.presentation.ui.home.viewmodel

import androidx.lifecycle.LiveData

interface HomeViewModel {
    fun getAllGeneral()
    fun getAllDentists()
    fun getAllOphthalmologists()
    fun getAllNutritionists()
    fun getAllNeurologists()
    fun getAllPediatric()
    fun getAllRadiologists()
    fun getMore()

    val openAllSpecialtiesLD: LiveData<Unit>
    val getAllGeneralsLD: LiveData<String>
    val getAllDentistsLD: LiveData<String>
    val getAllOphthalmologistsLD: LiveData<String>
    val getAllNutritionistsLD: LiveData<String>
    val getAllNeurologistsLD: LiveData<String>
    val getAllPediatricLD: LiveData<String>
    val getAllRadiologistsLD: LiveData<String>
    val errorHandlerLD: LiveData<String>
}