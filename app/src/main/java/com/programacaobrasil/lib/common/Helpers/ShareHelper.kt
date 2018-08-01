package com.programacaobrasil.lib.common.Helpers

import android.app.Activity
import android.content.Intent
import com.programacaobrasil.lib.common.R

class ShareHelper {
    companion object {
        fun shareContent(activity: Activity, subject: String, body: String) {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            shareIntent.putExtra(Intent.EXTRA_TEXT, body)
            activity.startActivity(Intent.createChooser(shareIntent, activity.resources.getString(R.string.text_shared_by)))
        }
    }
}