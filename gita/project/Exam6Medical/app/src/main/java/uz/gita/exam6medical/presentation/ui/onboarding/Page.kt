package uz.gita.exam6medical.presentation.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.exam6medical.R
import uz.gita.exam6medical.databinding.ScreenPageBinding

/**
 *    Created by Kamolov Samandar on 28.05.2023 at 12:34
 */
class Page: Fragment() {
    private val binding by viewBinding(ScreenPageBinding::bind)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.screen_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            when(arguments?.getInt("POS",0)){
                0->{
                    imagePage.setImageResource(R.drawable.pager1)
                    textPage.text = "Thousands of\ndoctors & experts to\nhelp your health!"
                }
                1->{
                    imagePage.setImageResource(R.drawable.pager2)
                    textPage.text = "Health checks &\nconsultations easily\nanywhere anytime"
                }
                else->{
                    imagePage.setImageResource(R.drawable.pager3)
                    textPage.text = "Let's start living\nhealthy and well\nwith us right now!"
                }
            }
        }
    }
}