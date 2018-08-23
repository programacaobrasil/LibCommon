package com.programacaobrasil.lib.common.Helpers

import android.content.Intent
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.Uri

class AppHelper
{
    companion object {
        fun openPlayStore(activity: Activity) {
            val appPackageName = activity.packageName
            try {
                activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
            } catch (anfe: android.content.ActivityNotFoundException) {
                activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
            }

        }

        fun openDevelopePage(activity: Activity, developerId: String)
        {
            try {
                activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://dev?id=$developerId")))
            } catch (anfe: android.content.ActivityNotFoundException) {
                activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=$developerId")))
            }
        }

        fun openAppsPage(activity: Activity, pubNameSearch: String)
        {
            try {
                activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub: $pubNameSearch")))
            } catch (anfe: android.content.ActivityNotFoundException) {
                activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=pub: $pubNameSearch")))
            }
        }

        fun isNetworkAvaliabe(context: Context): Boolean{
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = cm.activeNetworkInfo

            return info != null && info.isConnected ; true ; false
        }
    }
}