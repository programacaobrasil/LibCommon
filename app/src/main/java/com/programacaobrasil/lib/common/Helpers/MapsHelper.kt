package com.programacaobrasil.lib.common.Helpers

import android.location.Geocoder
import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.programacaobrasil.lib.common.Models.Address
import java.util.*


class MapsHelper {
    companion object {
        fun openCoordenates(activity: Activity, label: String, endereco: String) {
            val _endereco = getEndereco(activity, endereco)
            val latitude = _endereco!!.latitude.toString()
            val longitude = _endereco!!.longitude.toString()

            //String uri = "geo: -8.123109,-35.030556";
            val uri = String.format(Locale.ENGLISH, "geo:0,0?q=") + android.net.Uri.encode(String.format("%s@%s,%s", label, latitude, longitude), "UTF-8")
            activity.startActivity(Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)))
        }

        fun getEndereco(activity: Activity, address: String): Address {
            val geocoder = Geocoder(activity)
            var _address: Address? = null
            try {
                val addresses = geocoder.getFromLocationName(address, 1)
                if (addresses != null && addresses.size > 0) {
                    _address = Address()
                    val address = addresses[0]

                    _address!!.latitude = address.latitude
                    _address!!.longitude = address.longitude
                    _address!!.publicPlace = address.thoroughfare
                    _address!!.number = address.subThoroughfare
                    _address!!.neighborhood = address.subLocality
                    _address!!.city = address.subAdminArea
                    _address!!.uf = address.adminArea
                    _address!!.zipCode = address.postalCode
                    _address!!.country = address.countryName
                }
            } catch (ex: Exception) {
            }

            return _address!!
        }
    }
}
