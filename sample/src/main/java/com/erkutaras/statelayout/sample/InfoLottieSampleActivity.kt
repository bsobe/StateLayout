package com.erkutaras.statelayout.sample

import android.os.Bundle
import android.widget.Toast
import com.erkutaras.statelayout.StateLayout
import com.erkutaras.statelayout.lottieext.infoLottie
import kotlinx.android.synthetic.main.activity_info_lottie_sample.stateLayout

class InfoLottieSampleActivity : SampleBaseActivity(), StateLayout.OnStateLayoutListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_lottie_sample)

        stateLayout
            .infoTitle("Ooops.... :(")
            .infoMessage("Unexpected error occurred. Please refresh the page!")
            .infoButtonText("Refresh")
            //.infoLottie("like_heart.json")
            .infoButtonListener {
                onStateLayoutInfoButtonClick()
            }
    }

    override fun getMenuResId(): Int = R.menu.menu_sample

    override fun onStateLayoutInfoButtonClick() {
        Toast.makeText(this, "Refreshing Page...", Toast.LENGTH_SHORT).show()
    }
}
