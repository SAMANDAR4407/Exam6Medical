package uz.gita.exam6medical.data.model

import uz.gita.exam6medical.data.model.common.DoctorData
import uz.gita.exam6medical.data.model.request.DoctorRequest
import uz.gita.exam6medical.data.model.response.DoctorResponse

/**
 *    Created by Kamolov Samandar on 28.05.2023 at 17:27
 */

fun DoctorData.toDoctorRequest() = DoctorRequest(fullName, about, experience, hospital, patients, rating, reviews, specialty, imageUrl)
fun DoctorData.toDoctorResponse() = DoctorResponse(fullName, about, experience, hospital, patients, rating, reviews, specialty, imageUrl)

fun DoctorResponse.toDoctorData() = DoctorData(fullName, about, experience, hospital, patients, rating, reviews, specialty, imageUrl)
fun DoctorResponse.tpDoctorRequest() = DoctorRequest(fullName, about, experience, hospital, patients, rating, reviews, specialty, imageUrl)

fun DoctorRequest.toDoctorData() = DoctorData(fullName, about, experience, hospital, patients, rating, reviews, specialty, imageUrl)
fun DoctorRequest.toDoctorResponse() = DoctorResponse(fullName, about, experience, hospital, patients, rating, reviews, specialty, imageUrl)
