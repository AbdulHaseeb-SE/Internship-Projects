package urraan.internship.chapter2_loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import urraan.internship.chapter2_loginpage.databinding.UpdateBikeDataBinding
import urraan.internship.chapter2_loginpage.entity.Bike
import urraan.internship.chapter2_loginpage.entity.BikeDatabase

class UpdateBikeDetails : AppCompatActivity() {
    private lateinit var binding: UpdateBikeDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UpdateBikeDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val getModelNo = intent.getStringExtra("modelNo")
        val getCompanyName = intent.getStringExtra("company")
        val getEngine = intent.getStringExtra("Engine")
        val getPrice = intent.getStringExtra("price")

        binding.editextUpdateModalNo.editText?.setText(getModelNo)
        binding.editextUpdateModalNo.editText?.isEnabled = false
        binding.edittextUpdateCompanyName.editText?.setText(getCompanyName)
        binding.edittextUpdateCompanyName.editText?.isEnabled = false
        binding.edittextUpdateEngine.editText?.setText(getEngine)
        binding.edittextUpdatePrice.editText?.setText(getPrice)

        val repo = BikeDatabase.getDatabase(applicationContext).bikeDao

        binding.btnUpdate.setOnClickListener {
            if (isTextfieldEmpty(
                    binding.editextUpdateModalNo.editText?.text.toString(),
                    binding.edittextUpdateCompanyName.editText?.text.toString(),
                    binding.edittextUpdateEngine.editText?.text.toString(),
                    binding.edittextUpdatePrice.editText?.text.toString()
            )){
                Snackbar.make(binding.root, "Some TextFields are empty!", Snackbar.LENGTH_LONG).show()
            }else
            {
                lifecycleScope.launch(Dispatchers.IO){
                    repo.updateBikeData(Bike(
                        model_No = binding.editextUpdateModalNo.editText?.text.toString(),
                        company = binding.edittextUpdateCompanyName.editText?.text.toString(),
                        engine_capacity = binding.edittextUpdateEngine.editText?.text.toString(),
                        price = binding.edittextUpdatePrice.editText?.text.toString().toInt()
                    )
                    )
                    withContext(Dispatchers.Main){
                        finish()
                    }
                }
            }
        }



    }
}