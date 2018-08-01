package com.programacaobrasil.lib.common.Helpers

import java.util.Random

class NumberHelper {
    companion object {
        fun getRandomNumber(start: Int, end: Int): Int {
            //This gives a random integer between 65 (start) (inclusive) and 80 (end) (exclusive), one of 65,66,...,78,79
            val r = Random()

            return r.nextInt(end - start) + start
        }
    }
}
