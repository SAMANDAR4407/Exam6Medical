package uz.gita.exam6medical.presentation.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.exam6medical.R
import uz.gita.exam6medical.databinding.ScreenEnterViewBinding

/**
 *    Created by Kamolov Samandar on 28.05.2023 at 15:29
 */
class OnBoarding: Fragment(R.layout.screen_enter_view) {
    private val binding by viewBinding(ScreenEnterViewBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = PageAdapter(childFragmentManager,lifecycle)
        binding.apply {
            nextBtn.setOnClickListener {
                viewPager.currentItem = viewPager.currentItem+1
                if (viewPager.currentItem == 2){
                    startBtn.visibility = View.VISIBLE
                    nextBtn.visibility = View.GONE
                }
            }
            startBtn.setOnClickListener {
                findNavController().navigate(R.id.loginScreen)
            }

            viewPager.adapter = adapter
            viewPager.isUserInputEnabled = false
            wormDotsIndicator.attachTo(viewPager)
        }
    }
}