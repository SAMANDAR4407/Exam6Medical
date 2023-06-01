package uz.gita.exam6medical.presentation.ui.onboarding

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *    Created by Kamolov Samandar on 28.05.2023 at 12:38
 */

class PageAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        Page().apply {
            arguments = bundleOf(Pair ("POS", position))
        }
}