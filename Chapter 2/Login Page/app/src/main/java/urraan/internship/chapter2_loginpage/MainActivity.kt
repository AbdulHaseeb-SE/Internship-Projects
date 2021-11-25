package urraan.internship.chapter2_loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import urraan.internship.chapter2_loginpage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var preferencesProvider: PreferencesProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferencesProvider = PreferencesProvider(applicationContext)

        val intent = getIntent()
        val userName = intent.getStringExtra("userName")
        val password = intent.getStringExtra("Password")

        binding.edittextUsernameLogin.setText(userName ?: "")
        binding.edittextPasswordLogin.setText(password ?: "")


        binding.btnRegisterUser.setOnClickListener {
            val intent = Intent(this, Register_UserActivity::class.java)
            startActivity(intent)
        }
        val usernamecheck = preferencesProvider.getValue(Constants.KEY_UserName)
        val passwordcheck = preferencesProvider.getValue(Constants.KEY_Password)

        binding.btnLoginUser.setOnClickListener {
            if (usernamecheck == binding.edittextUsernameLogin.text.toString() && passwordcheck
                == binding.edittextPasswordLogin.text.toString()
            ) {
                val intent = Intent(this, RecyclerViewBikeDetails::class.java)
                startActivity(intent)
                finish()
                } else {
                Toast.makeText(this, "Username or Password doesn't match", Toast.LENGTH_LONG).show()
            }
        }
    }
}