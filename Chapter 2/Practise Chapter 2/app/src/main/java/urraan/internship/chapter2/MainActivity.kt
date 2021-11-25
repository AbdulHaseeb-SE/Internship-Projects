package urraan.internship.chapter2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import urraan.internship.chapter2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //******Getting Image Uri
        val selectedImage =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { uri ->
                if (uri.resultCode == RESULT_OK) {
                    val fullPhotoUri = uri.data?.data
                    binding.imgView.setImageURI(fullPhotoUri)
                }
            }

        binding.btnChooseImage.setOnClickListener {
            //********Implicit Intent
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            selectedImage.launch(intent)
        }

        binding.button.setOnClickListener {
            val intent = Intent(this, RecieveMessageActivity::class.java)
                intent.putExtra("Some_Message", binding.editTextView.text.toString())
            startActivity(intent)
        }
    }
}