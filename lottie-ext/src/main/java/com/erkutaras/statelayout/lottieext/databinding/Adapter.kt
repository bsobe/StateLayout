package com.erkutaras.statelayout.lottieext.databinding

import androidx.databinding.BindingAdapter
import com.erkutaras.statelayout.StateLayout
import com.erkutaras.statelayout.lottieext.infoLottie

@BindingAdapter("sl_infoLottieAsset")
fun setInfoLottieAsset(view: StateLayout, assetName: String) {
    view.infoLottie(assetName)
}

@BindingAdapter("sl_infoLottieRawRes")
fun setInfoLottieRawRes(view: StateLayout, rawRes: Int) {
    view.infoLottie(rawRes)
}
