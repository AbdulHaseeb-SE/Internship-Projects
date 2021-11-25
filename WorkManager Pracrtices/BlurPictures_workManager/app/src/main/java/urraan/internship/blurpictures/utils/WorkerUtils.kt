package urraan.internship.blurpictures.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import coil.Coil
import coil.api.load
import coil.api.loadAny
import coil.request.LoadRequestBuilder
import coil.transform.BlurTransformation
import coil.transform.Transformation
import coil.util.CoilUtils
import urraan.internship.blurpictures.Constants
import urraan.internship.blurpictures.R

//WORKER UTILS

//Make Notification
fun makeStatusNotification(message: String, context: Context) {
    //make a Notification Channel if Necessary
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        val channelName = Constants.NOTIFICATION_CHANNEL_NAME
        val channelDescription = Constants.NOTIFICATION_CHANNEL_DESCRIPTION
        val importance = NotificationManager.IMPORTANCE_HIGH
        val notificationChannel = NotificationChannel(Constants.CHANNEL_ID, channelName, importance)
        notificationChannel.description = channelDescription

        //Adding the Channel
        val notificationManager = context.getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }
    val notificationPriorityHigh = NotificationCompat.PRIORITY_HIGH

    //Now create the Notification
    val notificationBuilder = NotificationCompat.Builder(context, Constants.CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(Constants.NOTIFICATION_TITLE)
        .setContentText(message)
        .setPriority(notificationPriorityHigh)
        .setVibrate(LongArray(1))

    //show notification
    NotificationManagerCompat.from(
        context
    ).notify(
        Constants.NOTIFICATION_ID, notificationBuilder.build()
    )
}

fun LoadRequestBuilder.getTransformation(context: Context , radius: Float){
    transformations(BlurTransformation(context, radius))
}