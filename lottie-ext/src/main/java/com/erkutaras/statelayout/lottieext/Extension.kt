package com.erkutaras.statelayout.lottieext

import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.erkutaras.statelayout.StateLayout

fun StateLayout.infoLottie(assetName: String): StateLayout {
    getInfoLayout()?.findViewById<LottieAnimationView>(R.id.imageView_state_layout_info)?.run {
        setAnimation(assetName)
        visibility = View.VISIBLE
    }
    return this
}

fun StateLayout.infoLottie(rawRes: Int): StateLayout {
    getInfoLayout()?.findViewById<LottieAnimationView>(R.id.imageView_state_layout_info)?.run {
        setAnimation(rawRes)
        visibility = View.VISIBLE
    }
    return this
}
