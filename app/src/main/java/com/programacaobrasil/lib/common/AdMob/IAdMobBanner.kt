package com.programacaobrasil.lib.common.AdMob

import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.reward.RewardItem

/**
 * Created by marcos.guedes on 03/04/2018.
 */

interface IAdMobBanner {
    fun onLoaded(view: AdView)
}