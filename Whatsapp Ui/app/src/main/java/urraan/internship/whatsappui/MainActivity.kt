package urraan.internship.whatsappui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.google.android.material.tabs.TabLayoutMediator
import urraan.internship.whatsappui.adapters.ViewPagerAdapter
import urraan.internship.whatsappui.databinding.ActivityMainBinding
import urraan.internship.whatsappui.fragments.CallsFragment
import urraan.internship.whatsappui.fragments.ChatFragment
import urraan.internship.whatsappui.fragments.StatusFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val adapter = ViewPagerAdapter(
            allFragments = arrayListOf(
                ChatFragment(),
                StatusFragment(),
                CallsFragment()
            ),
            supportFragmentManager,
            lifecycle
        )
        binding.viewPager2.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 ->
                    tab.apply {
                        text = buildSpannedString {
                            bold { append("Chat") }
                        }
                    }
                1 ->
                    tab.apply {
                        text = buildSpannedString {
                            bold { append("Status") }
                        }
                    }
                2 ->
                    tab.apply {
                        text = buildSpannedString {
                            bold { append("Calls") }
                        }
                    }            }
        }.attach()


    }
}