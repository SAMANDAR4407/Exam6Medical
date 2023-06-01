package uz.gita.exam6medical.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.exam6medical.R
import uz.gita.exam6medical.databinding.HostScreenBinding
import uz.gita.exam6medical.presentation.ui.appointment.AppointmentScreen
import uz.gita.exam6medical.presentation.ui.article.ArticleScreen
import uz.gita.exam6medical.presentation.ui.history.HistoryScreen
import uz.gita.exam6medical.presentation.ui.home.HomeScreen
import uz.gita.exam6medical.presentation.ui.profile.ProfileScreen

/**
 *    Created by Kamolov Samandar on 28.05.2023 at 13:54
 */

@AndroidEntryPoint
class HostFragment : Fragment(R.layout.host_screen){

    private val binding by viewBinding(HostScreenBinding::bind)
    private val homeScreen by lazy{ HomeScreen() }
    private val appointment by lazy{ AppointmentScreen() }
    private val history by lazy{ HistoryScreen() }
    private val article by lazy{ ArticleScreen() }
    private val profile by lazy{ ProfileScreen() }
    private lateinit var currentScreen: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addAllFragments()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        clicks()

    }

    private fun addAllFragments() {
        childFragmentManager.beginTransaction().add(R.id.container, homeScreen).commit()
        currentScreen = homeScreen
    }

    private fun clicks() {

        binding.bottomNav.setOnItemSelectedListener {
            val tr = childFragmentManager.beginTransaction()
            when(it.itemId){
                R.id.home -> {
                    currentScreen = homeScreen
                    tr.replace(R.id.container, currentScreen).commit()
                }
                R.id.appointment -> {
                    currentScreen = appointment
                    tr.replace(R.id.container, currentScreen).commit()
                }
                R.id.history -> {
                    currentScreen = history
                    tr.replace(R.id.container, currentScreen).commit()
                }
                R.id.articles -> {
                    currentScreen = article
                    tr.replace(R.id.container, currentScreen).commit()
                }
                R.id.profile -> {
                    currentScreen = profile
                    tr.replace(R.id.container, currentScreen).commit()
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}