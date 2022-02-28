package com.erkutaras.statelayout.lottieext

import com.airbnb.lottie.LottieAnimationView
import com.erkutaras.statelayout.StateLayout

fun StateLayout.setLottieAsset(assetName: String) {
    getInfoLayout()?.findViewById<LottieAnimationView>(R.id.imageView_state_layout_info)?.run {
        setAnimation(assetName)
    }
}
