package urraan.internship.practise1

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import urraan.internship.practise1.databinding.ActivityMainBinding
import urraan.internship.practise1.databinding.CustomDialogBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        var progress = 0

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.imageButton.setOnClickListener {
            binding.imageButton.setImageResource(R.drawable.pattern)
        }

        binding.editText.addTextChangedListener {
            if (it!!.isEmpty()) {
                binding.textView.text = "_______"
            } else if (binding.editText.text.isNotEmpty()) {
                binding.textView.text = binding.editText.text
            }
        }

        binding.toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.imageView.setImageResource(R.drawable.groot2)
            }
            if (!isChecked) {
                binding.imageView.setImageResource(R.drawable.groot)
            }
        }

        binding.btnIncrease.setOnClickListener {
            if (progress <= 90) {
                progress += 10
                updateProgressBar(binding,progress)
            }

        }
        binding.btnDecrease.setOnClickListener {
            if (progress >= 10) {
                progress -= 10
            updateProgressBar(binding,progress)
            }
        }

        binding.btnNext.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun updateProgressBar(binding: ActivityMainBinding, progress: Int) {
        binding.progressBar.progress = progress
        binding.txtViewProgress.text = "$progress%"

    }
