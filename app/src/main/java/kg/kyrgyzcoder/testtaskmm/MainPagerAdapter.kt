package kg.kyrgyzcoder.testtaskmm

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kg.kyrgyzcoder.display_fr.DisplayFragment
import kg.kyrgyzcoder.enter_fr.EnterFragment


class MainPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> EnterFragment()
            else -> DisplayFragment()
        }
    }
}