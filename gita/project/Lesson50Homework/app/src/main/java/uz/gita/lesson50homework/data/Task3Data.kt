package uz.gita.lesson50homework.data

import androidx.annotation.DrawableRes
import uz.gita.lesson50homework.R

/**
 *    Created by Kamolov Samandar on 26.05.2023 at 10:11
 */

data class Task3Data(
    @DrawableRes
    val image: Int,
    val title: String,
    val number: String
)

object Task3List{
    val listData = listOf(
        Task3Data(R.drawable.mastercard, "Credit Card", "8600****1111"),
        Task3Data(R.drawable.paypal, "PayPal", "8600****1234"),
        Task3Data(R.drawable.google, "Google Pay", "8600****7777")
    )
}