package com.programacaobrasil.lib.common.AdMob

import android.app.Activity
import com.google.android.gms.ads.*
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener
import android.widget.AbsListView
import com.google.android.gms.ads.AdListener

/**
 * Created by marcos.guedes on 03/04/2018.
 */

class AdMobConfig {
    private var adRequest: AdRequest? = null
    private var mInterstitialAd: InterstitialAd? = null
    private var mRewardedVideoAd: RewardedVideoAd? = null

    private var mAdView : AdView? = null

    private var bannerId : String? = null
    private var interstitialId : String? = null
    private var rewardedId : String? = null

    fun setBannerId(id : String)
    {
        bannerId = id
    }

    fun setInterstitialId(id : String)
    {
        interstitialId = id
    }

    fun setRewardedId(id : String)
    {
        rewardedId = id
    }

    fun loadAdMobBanner(activity: Activity, adSize: AdSize, iAdMobBanner: IAdMobBanner)
    {
        if (mAdView != null) {
            iAdMobBanner.onLoaded(mAdView!!)
        }

        mAdView = AdView(activity)
        mAdView!!.setAdSize(adSize)
        mAdView!!.setAdUnitId(bannerId)

        val density = activity.resources.displayMetrics.density
        val height = Math.round(adSize.height * density)

        val params = AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, height)

        mAdView!!.layoutParams = params
        mAdView!!.loadAd(getAdRequest())
        mAdView!!.adListener = object : AdListener() {
            override fun onAdLoaded() {
                iAdMobBanner.onLoaded(mAdView!!)
            }
        }
    }

    fun loadAdMobInterstitial(activity: Activity, openLoad: Boolean) {
        if (interstitialId.isNullOrEmpty()) return

        mInterstitialAd = InterstitialAd(activity)
        mInterstitialAd!!.adUnitId = interstitialId
        mInterstitialAd!!.loadAd(getAdRequest())

        if (openLoad) {
            mInterstitialAd!!.adListener = object : AdListener() {
                override fun onAdLoaded() {
                    openAdMobInterstitial()
                }
            }
        }
    }

    fun openAdMobInterstitial() {
        if (mInterstitialAd != null && mInterstitialAd!!.isLoaded) {
            mInterstitialAd!!.show()
        }
    }

    fun initializeAdMobRewarded(activity: Activity, iAdMobRewarded: IAdMobRewarded) {
        if (rewardedId.isNullOrEmpty()) return

        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(activity)
        mRewardedVideoAd!!.rewardedVideoAdListener = object : RewardedVideoAdListener {
            override fun onRewardedVideoAdLoaded() {

            }

            override fun onRewardedVideoAdOpened() {

            }

            override fun onRewardedVideoStarted() {

            }

            override fun onRewardedVideoAdClosed() {
                loadAdMobRewarded()
            }

            override fun onRewarded(rewardItem: RewardItem) {
                iAdMobRewarded.onRewarded(rewardItem)
                loadAdMobRewarded()
            }

            override fun onRewardedVideoAdLeftApplication() {

            }

            override fun onRewardedVideoAdFailedToLoad(i: Int) {

            }
        }
        loadAdMobRewarded()
    }

    fun openAdMobRewardedVideo() {
        if (mRewardedVideoAd!=null && mRewardedVideoAd!!.isLoaded) {
            mRewardedVideoAd!!.show()
        } else {
            loadAdMobRewarded()
        }
    }

    private fun getAdRequest(): AdRequest {
        if (adRequest == null) {
            adRequest = AdRequest.Builder().build()
        }

        return adRequest!!
    }

    private fun loadAdMobRewarded() {
        mRewardedVideoAd!!.loadAd(rewardedId, getAdRequest())
    }
}