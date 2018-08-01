package com.programacaobrasil.lib.common.Helpers

import android.util.Base64;

import java.text.NumberFormat;
import java.util.Locale;

class ConvertHelper {
    companion object {
        fun convertToBRL(value: Double): String {
            val ptBr = Locale("pt", "BR")
            return NumberFormat.getCurrencyInstance(ptBr).format(value)
        }

        fun encodeToBase64(input: String): String {
            return String(Base64.encode(input.toByteArray(), Base64.DEFAULT)).replace("\n".toRegex(), "")
        }

        fun decodeFromBase64(input: String): String {
            return String(Base64.decode(input, Base64.DEFAULT))
        }
    }

}