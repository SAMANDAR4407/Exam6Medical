package uz.gita.exam6medical.data.source.local

/**
 *    Created by Kamolov Samandar on 15.05.2023 at 17:14
 */
interface PrefHelper {

    var firstSetup: Boolean
    var login: String
    var password: String
    var isSignedIn: Boolean
    var isProfileFilled: Boolean
    var currentUserEmail: String?
    var currentUserFullName: String?
    var currentUserNickName: String?
    var currentUserDateOfBirth: String?
    var currentUserGender: String?
}