package urraan.internship.blurpictures.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import urraan.internship.blurpictures.utils.makeStatusNotification
import java.lang.Exception


class BlurImageWorker(
    private val context: Context,
    params: WorkerParameters
) : Worker(
    context, params
) {
    override fun doWork(): Result {
        return try {
            makeStatusNotification("Blurring starts", context)

            val tagData = inputData.getString("tag") ?: return Result.failure()

            Result.success()
        }catch (e : Exception){
            Result.failure()
        }
    }
}