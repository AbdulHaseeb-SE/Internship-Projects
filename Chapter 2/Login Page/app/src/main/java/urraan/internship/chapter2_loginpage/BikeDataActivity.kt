package urraan.internship.chapter2_loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import urraan.internship.chapter2_loginpage.databinding.ActivityBikeDataBinding
import urraan.internship.chapter2_loginpage.entity.Bike
import urraan.internship.chapter2_loginpage.entity.BikeDatabase

class BikeDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBikeDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBikeDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bikeDao = BikeDatabase.getDatabase(applicationContext).bikeDao

        binding.btnSave.setOnClickListener {
            if (isTextfieldEmpty(
                    binding.edittextBikeModel?.text.toString(),
                    binding.edittextCompanyName?.text.toString(),
                    binding.textfieldEngineCapacity.editText?.text.toString(),
                    binding.edittextPrice?.text.toString()
                )
            ) {
                Snackbar.make(binding.root, "Text Fields are Empty!!!", Snackbar.LENGTH_LONG).show()
            } else {
                lifecycleScope.launch(Dispatchers.IO){
                    bikeDao.insertBikeData(Bike(
                        model_No = binding.edittextBikeModel.text.toString(),
                        company = binding.edittextCompanyName.text.toString(),
                        engine_capacity = binding.edittextEngineCapacity.text.toString(),
                        price = binding.edittextPrice.text.toString().toInt()
                    ))
                    withContext(Dispatchers.Main){
                        finish()
                    }
                }
            }
        }
    }
}