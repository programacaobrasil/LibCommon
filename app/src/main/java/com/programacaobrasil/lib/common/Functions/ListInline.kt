package com.programacaobrasil.lib.common.Functions

import kotlin.reflect.KMutableProperty1

inline fun <reified T, Y> MutableList<T>.listOfField(property: KMutableProperty1<T, Y?>):MutableList<Y> {
    val yy = ArrayList<Y>()
    this.forEach { t: T ->
        yy.add(property.get(t) as Y)
    }
    return yy
}