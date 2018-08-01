package com.programacaobrasil.lib.common.Helpers

import android.app.NotificationManager
import android.support.v4.app.NotificationCompat
import android.media.RingtoneManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

import com.programacaobrasil.lib.common.R

class NotificationHelper {
    companion object {
        fun sendNotification(context: Context, destination : Class<*>, notificationIcon : Int, notificationTitle: String, notificationBody: String) {
            val intent = Intent(context, destination)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            val pendingIntent = PendingIntent.getActivity(context, 0, intent,
                    PendingIntent.FLAG_ONE_SHOT)

            val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val notificationBuilder = NotificationCompat.Builder(context)
                    .setAutoCancel(true)   //Automatically delete the notification
                    .setSmallIcon(notificationIcon) //Notification icon
                    .setContentIntent(pendingIntent)
                    .setContentTitle(notificationTitle)
                    .setContentText(notificationBody)
                    .setColor(context.getResources().getColor(R.color.colorAccent))
                    .setSound(defaultSoundUri) as NotificationCompat.Builder


            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.notify(0, notificationBuilder.build())
        }

        /*private val notificationIcon: Int
            get() {
                val useWhiteIcon = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP
                return if (useWhiteIcon) R.mipmap.ic_launcher else R.mipmap.ic_launcher
            }*/
    }
}