package com.programacaobrasil.lib.common.Helpers

import java.text.Normalizer;

class StringHelper
{
    companion object {
        fun removerSpace(str: String): String {
            return str.replace(" ".toRegex(), "")
        }

        fun removeAccents(str: String): String {
            return Normalizer.normalize(str, Normalizer.Form.NFD).replace("[^\\p{ASCII}]", "");
        }
    }
}