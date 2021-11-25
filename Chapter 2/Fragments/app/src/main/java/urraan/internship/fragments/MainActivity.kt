package urraan.internship.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import urraan.internship.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, firstFragment)
            commit()
        }

        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, firstFragment)
                commit()
            }
        }
        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}