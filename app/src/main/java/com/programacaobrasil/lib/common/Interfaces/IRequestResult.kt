package com.programacaobrasil.lib.common.Interfaces

interface IRequestResult {
    fun onComplete(result: Any?)
    fun onFailure(ex: Exception)
}