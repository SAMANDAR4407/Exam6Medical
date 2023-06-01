package uz.gita.exam6medical.data.model.response

/**
 *    Created by Kamolov Samandar on 28.05.2023 at 9:09
 */
data class DoctorResponse(
    val fullName: String,
    val about: String,
    val experience: String,
    val hospital: String,
    val patients: String,
    val rating: String,
    val reviews: String,
    val specialty: String,
    val imageUrl: String
)
