package uz.gita.exam6medical.data.source.local

import android.content.SharedPreferences
import javax.inject.Inject

class PrefHelperImpl @Inject constructor(private val pref: SharedPreferences): PrefHelper {

    companion object {
        private val IS_SIGNED_IN = "is_signed_in"
        private val IS_PROFILE_FILLED = "is_profile_filled"
        private val CURRENT_USER_EMAIL = "current_user_email"
        private val CURRENT_USER_FULL_NAME = "current_user_full_name"
        private val CURRENT_USER_NICK_NAME = "current_user_nick_name"
        private val CURRENT_USER_DATE_OF_BIRTH = "date_of_birth"
        private val CURRENT_USER_GENDER = "gender"
    }

    override var firstSetup: Boolean
    set(value) = pref.edit().putBoolean("firstSetup", value).apply()
    get() = pref.getBoolean("firstSetup",true)

    override var login: String
        set(value) = pref.edit().putString("login", value).apply()
        get() = pref.getString("login", "").toString()

    override var password: String
        set(value) = pref.edit().putString("password", value).apply()
        get() = pref.getString("password", "").toString()

    override var currentUserEmail: String?
        get() = pref.getString(CURRENT_USER_EMAIL, null)
        set(value) = pref.edit().putString(CURRENT_USER_EMAIL, value).apply()

    override var isSignedIn: Boolean
        get() = pref.getBoolean(IS_SIGNED_IN, false)
        set(value) = pref.edit().putBoolean(IS_SIGNED_IN, value).apply()

    override var currentUserFullName: String?
        get() = pref.getString(CURRENT_USER_FULL_NAME, null)
        set(value) = pref.edit().putString(CURRENT_USER_FULL_NAME, value).apply()

    override var currentUserNickName: String?
        get() = pref.getString(CURRENT_USER_NICK_NAME, null)
        set(value) = pref.edit().putString(CURRENT_USER_NICK_NAME, value).apply()

    override var currentUserDateOfBirth: String?
        get() = pref.getString(CURRENT_USER_DATE_OF_BIRTH, null)
        set(value) = pref.edit().putString(CURRENT_USER_DATE_OF_BIRTH, value).apply()

    override var currentUserGender: String?
        get() = pref.getString(CURRENT_USER_GENDER, null)
        set(value) = pref.edit().putString(CURRENT_USER_GENDER, value).apply()

    override var isProfileFilled: Boolean
        get() = pref.getBoolean(IS_PROFILE_FILLED, false)
        set(value) = pref.edit().putBoolean(IS_PROFILE_FILLED, value).apply()
}