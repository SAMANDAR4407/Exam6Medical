package uz.gita.exam6medical.domain.repository.auth

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun signIn(email: String, password: String): Flow<Result<Unit>>
    fun signUp(email: String, password: String): Flow<Result<Unit>>
    fun fillProfileInfo(fullName: String, nickName: String, dateOfBirth: String, gender: String)
    fun signOut()
}