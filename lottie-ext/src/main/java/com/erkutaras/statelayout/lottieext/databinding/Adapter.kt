package com.erkutaras.statelayout.lottieext.databinding

import androidx.databinding.BindingAdapter
import com.erkutaras.statelayout.StateLayout
import com.erkutaras.statelayout.lottieext.setLottieAsset

@BindingAdapter("sl_lottieAsset")
fun setLottieAsset(view: StateLayout, assetName: String) {
    view.setLottieAsset(assetName)
}
