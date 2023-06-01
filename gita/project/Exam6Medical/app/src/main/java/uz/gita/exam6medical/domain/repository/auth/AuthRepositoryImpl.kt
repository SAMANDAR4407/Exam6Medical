package uz.gita.exam6medical.domain.repository.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import uz.gita.exam6medical.data.source.local.PrefHelper
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val myPrefs: PrefHelper,
    private val auth: FirebaseAuth,
    private val db: FirebaseFirestore
) : AuthRepository {

    override fun signIn(email: String, password: String): Flow<Result<Unit>> = callbackFlow {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                myPrefs.isSignedIn = true
                trySend(Result.success(Unit))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun signUp(email: String, password: String): Flow<Result<Unit>> = callbackFlow {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                myPrefs.isSignedIn = true
                trySend(Result.success(Unit))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun fillProfileInfo(fullName: String, nickName: String, dateOfBirth: String, gender: String) {
        myPrefs.currentUserFullName = fullName
        myPrefs.currentUserNickName = nickName
        myPrefs.currentUserDateOfBirth = dateOfBirth
        myPrefs.currentUserGender = gender
    }

    override fun signOut() {
        auth.signOut()
        myPrefs.isSignedIn = false
        myPrefs.currentUserFullName = null
        myPrefs.currentUserNickName = null
    }
}