package uz.gita.exam6medical.data.model.common

/**
 *    Created by Kamolov Samandar on 28.05.2023 at 9:09
 */
data class DoctorData(
    val fullName: String,
    val about: String,
    val experience: String,
    val hospital: String,
    val patients: String,
    val rating: String,
    val reviews: String,
    val specialty: String,
    val imageUrl: String
): java.io.Serializable
