package uz.gita.exam6medical.domain.repository.home

import kotlinx.coroutines.flow.Flow
import uz.gita.exam6medical.data.model.common.DoctorData

interface HomeRepository {
    fun getAllDoctors(): Flow<Result<List<DoctorData>>>
    fun getAllGeneral(): Flow<Result<List<DoctorData>>>
    fun getAllDentists(): Flow<Result<List<DoctorData>>>
    fun getAllOphthalmologists(): Flow<Result<List<DoctorData>>>
    fun getAllNutritionists(): Flow<Result<List<DoctorData>>>
    fun getAllNeurologists(): Flow<Result<List<DoctorData>>>
    fun getAllPediatric(): Flow<Result<List<DoctorData>>>
    fun getAllRadiologists(): Flow<Result<List<DoctorData>>>
    fun getAllCardiologist(): Flow<Result<List<DoctorData>>>
    fun getAllImmunologist(): Flow<Result<List<DoctorData>>>
    fun getAllAllergist(): Flow<Result<List<DoctorData>>>
}