package com.erkutaras.statelayout.sample

import android.os.Bundle
import android.widget.Toast
import com.erkutaras.statelayout.StateLayout
import com.erkutaras.statelayout.lottieext.infoLottie
import com.erkutaras.statelayout.sample.databinding.ActivityInfoLottieSampleBinding

class InfoLottieSampleActivity : SampleBaseActivity(), StateLayout.OnStateLayoutListener {

    private lateinit var binding: ActivityInfoLottieSampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoLottieSampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.stateLayout
            .infoTitle("Ooops.... :(")
            .infoMessage("Unexpected error occurred. Please refresh the page!")
            .infoButtonText("Refresh")
            .infoLottie("like_heart.json")
            .infoButtonListener {
                onStateLayoutInfoButtonClick()
            }
    }

    override fun getMenuResId(): Int = R.menu.menu_sample

    override fun onStateLayoutInfoButtonClick() {
        Toast.makeText(this, "Refreshing Page...", Toast.LENGTH_SHORT).show()
    }
}
