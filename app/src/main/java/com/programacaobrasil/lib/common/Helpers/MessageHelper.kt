package com.programacaobrasil.lib.common.Helpers

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import com.programacaobrasil.lib.common.Interfaces.IAlertResult
import com.programacaobrasil.lib.common.R

class MessageHelper {
    companion object {
        fun showToastSimpleShort(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun showAlertConfirm(context: Context, title: String, message: String, result: IAlertResult) {
            val alertDialog = AlertDialog.Builder(context)
            alertDialog.setTitle(title)
            alertDialog.setMessage(message)
            alertDialog.setCancelable(false) // não fecha a janela ao clicar fora

            alertDialog.setPositiveButton(context.resources.getString(R.string.text_confirm), DialogInterface.OnClickListener { dialogInterface, i -> result.onConfirm() })

            alertDialog.setNegativeButton(context.resources.getString(R.string.text_cancel), DialogInterface.OnClickListener { dialogInterface, i -> result.onCancel() })

            alertDialog.create()
            alertDialog.show()
        }
    }
}