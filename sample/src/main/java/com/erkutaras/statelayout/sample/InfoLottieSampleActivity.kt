package com.erkutaras.statelayout.sample

import android.os.Bundle
import android.widget.Toast
import com.erkutaras.statelayout.StateLayout

class InfoLottieSampleActivity : SampleBaseActivity(), StateLayout.OnStateLayoutListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_state_info_lottie)
    }

    override fun getMenuResId(): Int = R.menu.menu_sample

    override fun onStateLayoutInfoButtonClick() {
        Toast.makeText(this, "Refreshing Page...", Toast.LENGTH_SHORT).show()
    }
}
