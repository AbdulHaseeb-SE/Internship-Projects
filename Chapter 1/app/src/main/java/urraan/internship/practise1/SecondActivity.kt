package urraan.internship.practise1

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import urraan.internship.practise1.databinding.ActivitySecondBinding
import urraan.internship.practise1.databinding.CustomDialogBinding
import java.util.*

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var mediaplayer: MediaPlayer


    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivitySecondBinding.inflate(layoutInflater)
            setContentView(binding.root)

            mediaplayer = MediaPlayer.create(this, R.raw.song)
           // audioManager = this.getSystemService(Context.AUDIO_SERVICE) as AudioManager
            binding.seekBar.max = mediaplayer.duration


            //**********PlayPauseButton
            binding.playPauseButton.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    mediaplayer.start()
                }
                if (!isChecked) {
                    mediaplayer.pause()
                }
            }

                //*********SeekBar
            binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mediaplayer.seekTo(progress)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }

            })


            //***************Button Mute
            binding.btnMute.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    mediaplayer.setVolume(0f, 0f)
                } else {
                    mediaplayer.setVolume(1f, 1f)
                }
            }


            //***********Spinner
            val months = arrayListOf(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
            )
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, months)
            binding.spinner.adapter = adapter

            //*********Date Picker
            binding.datePicker.setOnClickListener {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val monthName = arrayListOf("January","February","March","April","May","June","July",
                    "August","September","October","November","December")
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                Log.i("check","$year $month $day")

                val datePickerDialog = DatePickerDialog(
                    this, DatePickerDialog.OnDateSetListener {
                            view, year, monthOfYear, dayOfMonth ->

                        binding.txtDate.text = "$dayOfMonth / ${monthName[month]} / $year"

                    },
                    year, month, day
                )
                datePickerDialog.show()
            }

            //********Time Picker
            binding.btnTime.setOnClickListener{
                val calendar = Calendar.getInstance()
                val hour = calendar.get(Calendar.HOUR_OF_DAY)
                val min = calendar.get(Calendar.MINUTE)

                val timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener {
                        view, hourOfDay, minute ->
                    val amPm: String = if (hourOfDay < 12) {
                        "AM"
                    } else {
                        "PM"
                    }
                    Log.i("check", "$amPm $hourOfDay")
                   /* if (hourOfDay == 0){
                    binding.txtTime.text = "12 : $minute  $amPm"
                    }
                    else
                    {
                    }*/
                        binding.txtTime.text = "$hourOfDay : $minute $amPm"
                },
                hour, min, false)
                timePickerDialog.show()

            }

            //*********Rating Bar
            binding.ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                    val toastDuration = Toast.LENGTH_LONG
                when(rating.toInt()){
                    1 -> {
                        Toast.makeText(this,"Bad", Toast.LENGTH_LONG).show()
                        Log.i("check","1")
                    }
                    2 -> {
                        Toast.makeText(this, "Ok", toastDuration).show()
                        Log.i("check","2")

                    }
                    3 -> {
                        Toast.makeText(this, "Good", toastDuration).show()
                        Log.i("check","3")

                    }
                    4 -> Toast.makeText(this,"Very Good", toastDuration).show()
                    5 -> Toast.makeText(this,"Excellent", toastDuration).show()
                    6 -> Toast.makeText(this,"Super Excellent", toastDuration).show()
                    7 -> Toast.makeText(this,"Outstanding", toastDuration).show()
                }
            }
        }

    override fun onDestroy() {
        super.onDestroy()
        mediaplayer.stop()
    }

override fun onBackPressed() {
    val dialogBinding: CustomDialogBinding = CustomDialogBinding.inflate(LayoutInflater.from(this))
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(dialogBinding.root)
    dialog.setCancelable(false)
    dialogBinding.btnYes.setOnClickListener {
        finish()
    }
    dialogBinding.btnNo.setOnClickListener {
        dialog.dismiss()
    }
    dialog.show()


}
}

