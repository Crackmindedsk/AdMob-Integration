package sharlene.work.ads

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

//import com.google.android.gms.ads.AdRequest
//import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

//    private lateinit var adView: AdView
    private var minterstitialAd:InterstitialAd?=null
    private var TAG= "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * Banner Ad
        MobileAds.initialize(this){}

        adView=findViewById(R.id.ad_view)
        val adRequest= AdRequest.Builder().build()
        adView.loadAd(adRequest)*/

        val adRequest=AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712",adRequest,object :InterstitialAdLoadCallback(){
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d(TAG, adError.message)
                minterstitialAd=null
            }

            override fun onAdLoaded(interstitialAd:InterstitialAd) {
                Log.d(TAG, "Ad was loaded.")
                minterstitialAd=interstitialAd
            }
        })
    }



}



