package uz.gita.lesson50homework.data

import androidx.annotation.DrawableRes
import uz.gita.lesson50homework.R

/**
 *    Created by Kamolov Samandar on 25.05.2023 at 9:14
 */

data class Task2Data(
    @DrawableRes val image: Int,
    val title: String,
    val venue: String
)

object Task2List  {
    val listData = listOf(
        Task2Data(R.drawable.plane, "Plane", "Airport"),
        Task2Data(R.drawable.cat, "Cat", "Pet house"),
        Task2Data(R.drawable.bug, "Bug", "Insect"),
        Task2Data(R.drawable.desert, "Desert", "Sahara"),
        Task2Data(R.drawable.windows, "Windows", "Microsoft"),
        Task2Data(R.drawable.cat, "Cat", "Pet house"),
        Task2Data(R.drawable.bug, "Bug", "Insect"),
        Task2Data(R.drawable.desert, "Desert", "Sahara"),
        Task2Data(R.drawable.windows, "Windows", "Microsoft")
    ).shuffled()
}