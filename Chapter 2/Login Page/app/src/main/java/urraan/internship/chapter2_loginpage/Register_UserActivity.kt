package urraan.internship.chapter2_loginpage

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import urraan.internship.chapter2_loginpage.databinding.ActivityRegisterUserBinding
import kotlin.jvm.internal.MagicApiIntrinsics

class Register_UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterUserBinding
    private lateinit var preferenceProvider: PreferencesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        preferenceProvider = PreferencesProvider(applicationContext)
        val dialogBuilder = AlertDialog.Builder(this)


        binding.btnLoginUser.setOnClickListener {
            if (binding.edittextPhoneNumberRegistration.text.toString() == preferenceProvider.getValue(
                    Constants.KEY_PhoneNumber
                )
            ) {
                Toast.makeText(
                    this,
                    "Phone Number already exist \n kindly use different",
                    Toast.LENGTH_LONG
                ).show()
            } else {
            preferenceProvider.insertValue(Constants.KEY_PhoneNumber, binding.edittextPhoneNumberRegistration.text.toString())
            preferenceProvider.insertValue(Constants.KEY_UserName, binding.edittextUsernameRegistration.text.toString())
            preferenceProvider.insertValue(Constants.KEY_Password, binding.edittextPasswordRegistration.text.toString())


                val intent = Intent(this, MainActivity::class.java)


                dialogBuilder.setTitle("Successfully Register!")
                    .setMessage("Do you want to Login using these Credentials?")
                    .setIcon(R.drawable.ic_baseline_check_circle_outline_24)
                    .apply {
                        setPositiveButton("Yes", DialogInterface.OnClickListener{dialog, it  ->
                            intent.putExtra("userName", preferenceProvider.getValue(Constants.KEY_UserName))
                            intent.putExtra("Password", preferenceProvider.getValue(Constants.KEY_Password))
                            intent.putExtra("PhoneNumber", preferenceProvider.getValue(Constants.KEY_PhoneNumber))
                            startActivity(intent)
                            finish()
                        })
                        setNegativeButton("No",DialogInterface.OnClickListener{dialog, it ->
                            dialog.dismiss()
                        })
                    }
                dialogBuilder.create()
                dialogBuilder.show()
            Log.i("check", "PhoneNumber = ${preferenceProvider.getValue(Constants.KEY_PhoneNumber)} \n" +
                    "UserName = ${preferenceProvider.getValue(Constants.KEY_UserName)} \n" +
                    "Password = ${preferenceProvider.getValue(Constants.KEY_Password)}")
                makeTextViewsEmpty()
            }
        }



    }

    private fun makeTextViewsEmpty() {
        binding.edittextUsernameRegistration.setText("")
        binding.edittextPasswordRegistration.setText("")
        binding.edittextPhoneNumberRegistration.setText("")
    }
}
