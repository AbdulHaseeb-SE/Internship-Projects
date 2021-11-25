package urraan.internship.workmanager

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import urraan.internship.workmanager.Constants.KEY_USER_EMOTION_RESULT

class WorkerClass(
    context: Context,
    workParams: WorkerParameters
): Worker(context, workParams) {
    override fun doWork(): Result {
        val text = inputData.getString(Constants.KEY_USER_COMMENT_MESSAGE)
        val outputData = Data.Builder()
            .putString(KEY_USER_EMOTION_RESULT, getUserEmotions(text))
            .build()
        return Result.success(outputData)
    }
    private fun getUserEmotions(userCommentText: String?): String{
        val emotionList = listOf("Sad","Happy","Enjoying","Surprised","Afraid","Tired","Bored")
        return emotionList.random()
    }
}

