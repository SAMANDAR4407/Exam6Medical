package uz.gita.exam6medical.domain.repository.home

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import uz.gita.exam6medical.data.model.common.DoctorData
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
) : HomeRepository {

    override fun getAllDoctors(): Flow<Result<List<DoctorData>>> = callbackFlow {
        val list = ArrayList<DoctorData>()
        fireStore.collection("doctors")
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.forEach { document ->
                    list.add(
                        DoctorData(
                            specialty = document.get("specialty").toString(),
                            fullName = document.get("name").toString(),
                            about = document.get("about").toString(),
                            hospital = document.get("hospital").toString(),
                            experience = document.get("experience").toString(),
                            patients = document.get("patients").toString(),
                            rating = document.get("rating").toString(),
                            reviews = document.get("reviews").toString(),
                            imageUrl = document.get("imageUrl").toString()
                        )
                    )
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getAllGeneral(): Flow<Result<List<DoctorData>>> = callbackFlow {
        val list = ArrayList<DoctorData>()
        fireStore.collection("doctors")
            .whereEqualTo("specialty_id", "1")
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.forEach { document ->
                    list.add(
                        DoctorData(
                            specialty = document.get("specialty").toString(),
                            fullName = document.get("name").toString(),
                            about = document.get("about").toString(),
                            hospital = document.get("hospital").toString(),
                            experience = document.get("experience").toString(),
                            patients = document.get("patients").toString(),
                            rating = document.get("rating").toString(),
                            reviews = document.get("reviews").toString(),
                            imageUrl = document.get("imageUrl").toString()
                        )
                    )
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getAllDentists(): Flow<Result<List<DoctorData>>> = callbackFlow {
        val list = ArrayList<DoctorData>()
        fireStore.collection("doctors")
            .whereEqualTo("specialty_id", "2")
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.forEach { document ->
                    list.add(
                        DoctorData(
                            specialty = document.get("specialty").toString(),
                            fullName = document.get("name").toString(),
                            about = document.get("about").toString(),
                            hospital = document.get("hospital").toString(),
                            experience = document.get("experience").toString(),
                            patients = document.get("patients").toString(),
                            rating = document.get("rating").toString(),
                            reviews = document.get("reviews").toString(),
                            imageUrl = document.get("imageUrl").toString()
                        )
                    )
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getAllOphthalmologists(): Flow<Result<List<DoctorData>>> = callbackFlow {
        val list = ArrayList<DoctorData>()
        fireStore.collection("doctors")
            .whereEqualTo("specialty_id", "3")
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.forEach { document ->
                    list.add(
                        DoctorData(
                            specialty = document.get("specialty").toString(),
                            fullName = document.get("name").toString(),
                            about = document.get("about").toString(),
                            hospital = document.get("hospital").toString(),
                            experience = document.get("experience").toString(),
                            patients = document.get("patients").toString(),
                            rating = document.get("rating").toString(),
                            reviews = document.get("reviews").toString(),
                            imageUrl = document.get("imageUrl").toString()
                        )
                    )
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getAllNutritionists(): Flow<Result<List<DoctorData>>> = callbackFlow {
        val list = ArrayList<DoctorData>()
        fireStore.collection("doctors")
            .whereEqualTo("specialty_id", "4")
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.forEach { document ->
                    list.add(
                        DoctorData(
                            specialty = document.get("specialty").toString(),
                            fullName = document.get("name").toString(),
                            about = document.get("about").toString(),
                            hospital = document.get("hospital").toString(),
                            experience = document.get("experience").toString(),
                            patients = document.get("patients").toString(),
                            rating = document.get("rating").toString(),
                            reviews = document.get("reviews").toString(),
                            imageUrl = document.get("imageUrl").toString()
                        )
                    )
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getAllNeurologists(): Flow<Result<List<DoctorData>>> = callbackFlow {
        val list = ArrayList<DoctorData>()
        fireStore.collection("doctors")
            .whereEqualTo("specialty_id", "5")
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.forEach { document ->
                    list.add(
                        DoctorData(
                            specialty = document.get("specialty").toString(),
                            fullName = document.get("name").toString(),
                            about = document.get("about").toString(),
                            hospital = document.get("hospital").toString(),
                            experience = document.get("experience").toString(),
                            patients = document.get("patients").toString(),
                            rating = document.get("rating").toString(),
                            reviews = document.get("reviews").toString(),
                            imageUrl = document.get("imageUrl").toString()
                        )
                    )
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getAllPediatric(): Flow<Result<List<DoctorData>>> = callbackFlow {
        val list = ArrayList<DoctorData>()
        fireStore.collection("doctors")
            .whereEqualTo("specialty_id", "6")
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.forEach { document ->
                    list.add(
                        DoctorData(
                            specialty = document.get("specialty").toString(),
                            fullName = document.get("name").toString(),
                            about = document.get("about").toString(),
                            hospital = document.get("hospital").toString(),
                            experience = document.get("experience").toString(),
                            patients = document.get("patients").toString(),
                            rating = document.get("rating").toString(),
                            reviews = document.get("reviews").toString(),
                            imageUrl = document.get("imageUrl").toString()
                        )
                    )
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getAllRadiologists(): Flow<Result<List<DoctorData>>> = callbackFlow {
        val list = ArrayList<DoctorData>()
        fireStore.collection("doctors")
            .whereEqualTo("specialty_id", "7")
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.forEach { document ->
                    list.add(
                        DoctorData(
                            specialty = document.get("specialty").toString(),
                            fullName = document.get("name").toString(),
                            about = document.get("about").toString(),
                            hospital = document.get("hospital").toString(),
                            experience = document.get("experience").toString(),
                            patients = document.get("patients").toString(),
                            rating = document.get("rating").toString(),
                            reviews = document.get("reviews").toString(),
                            imageUrl = document.get("imageUrl").toString()
                        )
                    )
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getAllCardiologist(): Flow<Result<List<DoctorData>>> = callbackFlow {
        val list = ArrayList<DoctorData>()
        fireStore.collection("doctors")
            .whereEqualTo("specialty_id", "8")
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.forEach { document ->
                    list.add(
                        DoctorData(
                            specialty = document.get("specialty").toString(),
                            fullName = document.get("name").toString(),
                            about = document.get("about").toString(),
                            hospital = document.get("hospital").toString(),
                            experience = document.get("experience").toString(),
                            patients = document.get("patients").toString(),
                            rating = document.get("rating").toString(),
                            reviews = document.get("reviews").toString(),
                            imageUrl = document.get("imageUrl").toString()
                        )
                    )
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getAllImmunologist(): Flow<Result<List<DoctorData>>> = callbackFlow {
        val list = ArrayList<DoctorData>()
        fireStore.collection("doctors")
            .whereEqualTo("specialty_id", "9")
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.forEach { document ->
                    list.add(
                        DoctorData(
                            specialty = document.get("specialty").toString(),
                            fullName = document.get("name").toString(),
                            about = document.get("about").toString(),
                            hospital = document.get("hospital").toString(),
                            experience = document.get("experience").toString(),
                            patients = document.get("patients").toString(),
                            rating = document.get("rating").toString(),
                            reviews = document.get("reviews").toString(),
                            imageUrl = document.get("imageUrl").toString()
                        )
                    )
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getAllAllergist(): Flow<Result<List<DoctorData>>> = callbackFlow {
        val list = ArrayList<DoctorData>()
        fireStore.collection("doctors")
            .whereEqualTo("specialty_id", "10")
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.forEach { document ->
                    list.add(
                        DoctorData(
                            specialty = document.get("specialty").toString(),
                            fullName = document.get("name").toString(),
                            about = document.get("about").toString(),
                            hospital = document.get("hospital").toString(),
                            experience = document.get("experience").toString(),
                            patients = document.get("patients").toString(),
                            rating = document.get("rating").toString(),
                            reviews = document.get("reviews").toString(),
                            imageUrl = document.get("imageUrl").toString()
                        )
                    )
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }
}