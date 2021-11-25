package urraan.internship.chapter2

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import urraan.internship.chapter2.databinding.ActivityRecieveMessageBinding

class RecieveMessageActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityRecieveMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecieveMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = getIntent()
        var recievedMessage = intent.getStringExtra("Some_Message")
        binding.recieveMessageTextView.text = recievedMessage
    }
}