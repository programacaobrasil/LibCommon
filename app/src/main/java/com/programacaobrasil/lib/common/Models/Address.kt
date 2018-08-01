package com.programacaobrasil.lib.common.Models

class Address {
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    var publicPlace: String? = null // logradouro
    var number: String? = null
    var neighborhood: String? = null // Bairro
    var city: String? = null
    var uf: String? = null
    var zipCode: String? = null // CEP
    var country: String? = null

    override fun toString(): String {
        var address = publicPlace
        val number = this.number
        val neighborhood = this.neighborhood
        val city = this.city
        val uf = this.uf
        val zipCode = this.zipCode

        if (!number.isNullOrEmpty()) address += ", " + number!!
        if (!neighborhood.isNullOrEmpty()) address += " - " + neighborhood!!
        if (!city.isNullOrEmpty()) address += ", " + city!!
        if (!uf.isNullOrEmpty()) address += " - " + uf!!
        if (!zipCode.isNullOrEmpty()) address += ", " + zipCode!!

        return address!!
    }
}
