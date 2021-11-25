package urraan.internship.blurpictures

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import coil.Coil
import coil.api.load
import coil.api.loadAny
import urraan.internship.blurpictures.databinding.ActivityMainBinding
import urraan.internship.blurpictures.utils.getTransformation
import urraan.internship.blurpictures.worker.BlurImageWorker

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartBlurring.setOnClickListener {
            performAnalysisRequest()
        }
        binding.btnLoadImage.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.breakfast)
        }
    }

    private fun performAnalysisRequest() {
        val workRequest = WorkManager.getInstance(this)

        val blurredLevelData = workDataOf(
            "tag" to binding.radioButtonMostBlurred.tag.toString()
        )
        val setConstraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<BlurImageWorker>()
            .setInputData(blurredLevelData)
            .setConstraints(setConstraints)
            .build()

        workRequest.enqueue(oneTimeWorkRequest)
        workRequest.getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
            .observe(this, {
                binding.Status.text = it.state.name
                if (it.state == WorkInfo.State.SUCCEEDED){
                    when (binding.radioGroupBlurLevels.checkedRadioButtonId) {
                        R.id.radioButton_LittleBlurred -> {
                            binding.imageView.load(R.drawable.breakfast){
                                getTransformation(applicationContext, 10f)
                            }
                        }
                        R.id.radioButton_MoreBlurred -> {
                            binding.imageView.loadAny(R.drawable.breakfast){
                                getTransformation(applicationContext, 15f)
                            }
                        }
                        R.id.radioButton_MostBlurred -> {
                            binding.imageView.loadAny(R.drawable.breakfast) {
                                getTransformation(applicationContext, 20f)
                            }
                        }

                    }                }
            })
    }
}