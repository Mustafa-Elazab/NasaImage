package com.mostafa.nasaimage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.mostafa.nasaimage.cycles.home_cycle.fragment.detail.DetailFragment
import com.mostafa.nasaimage.cycles.home_cycle.fragment.home.HomeFragment

class TestAppFragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            HomeFragment::class.java -> HomeFragment()
            DetailFragment::class.java -> DetailFragment()

            else -> super.instantiate(classLoader, className)
        }
    }
}