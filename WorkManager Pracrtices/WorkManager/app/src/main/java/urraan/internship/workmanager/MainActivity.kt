package urraan.internship.workmanager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import urraan.internship.workmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val userText = binding.editTextUserComment.editableText.toString()
        binding.btnAnalyze.setOnClickListener {
            setOneTimeEmotionalAnalysisRequest(userText)
        }


    }

    private fun setOneTimeEmotionalAnalysisRequest(userText: String) {

        val myWorkRequest = WorkManager.getInstance(this)

        val data = Data.Builder()
            .putString(Constants.KEY_USER_COMMENT_MESSAGE, userText)
            .build()

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(true)
            .build()

        val emotionWorkRequest = OneTimeWorkRequestBuilder<WorkerClass>()
            .setInputData(data)
            .setConstraints(constraints)
            .build()

        myWorkRequest.enqueue(emotionWorkRequest)
        myWorkRequest.getWorkInfoByIdLiveData(emotionWorkRequest.id)
            .observe(this, {
                binding.textViewWorkState.text = it.state.name

                if(it.state == WorkInfo.State.SUCCEEDED){

                val userEmotionResult = it.outputData.getString(Constants.KEY_USER_EMOTION_RESULT)
                Toast.makeText(this,userEmotionResult, Toast.LENGTH_LONG).show()
                }
            })
    }
}