package com.erkutaras.statelayout.sample

import android.graphics.Bitmap
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.erkutaras.statelayout.StateLayout
import com.erkutaras.statelayout.sample.databinding.ActivityCustomSampleBinding
import com.erkutaras.statelayout.sample.databinding.LayoutCustomInfoBinding
import com.erkutaras.statelayout.sample.databinding.LayoutCustomLoadingBinding

/**
 * Created by erkutaras on 21.12.2018.
 */
private const val WEB_URL = "https://medium.com/@erkutaras"

class CustomSampleActivity : SampleBaseActivity() {

    private lateinit var binding: ActivityCustomSampleBinding

    private lateinit var layoutCustomInfoBinding: LayoutCustomInfoBinding

    private lateinit var layoutCustomLoadingBinding: LayoutCustomLoadingBinding

    private var hasError: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomSampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutCustomInfoBinding = LayoutCustomInfoBinding.inflate(layoutInflater)
        layoutCustomLoadingBinding = LayoutCustomLoadingBinding.inflate(layoutInflater)

        binding.webView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                hasError = false
                if (url.equals(WEB_URL)) binding.stateLayout.loading()
                else binding.stateLayout.loadingWithContent()
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                hasError = true
                showInfoState()
            }
        }
        binding.webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                layoutCustomLoadingBinding.contentLoadingProgressBar.progress = newProgress
                layoutCustomLoadingBinding.textViewProgress.text = "$newProgress%"

                if (!hasError && newProgress == 100) binding.stateLayout.content()
                if (hasError && newProgress == 100) showInfoState()
            }
        }
        loadUrl()
    }

    override fun getMenuResId(): Int = R.menu.menu_custom

    private fun showInfoState() {
        binding.stateLayout.info()
        layoutCustomInfoBinding.buttonRefresh.setOnClickListener { loadUrl() }
        layoutCustomInfoBinding.buttonClose.setOnClickListener { finish() }
    }

    private fun loadUrl() {
        binding.webView.loadUrl(WEB_URL)
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) binding.webView.goBack()
        else super.onBackPressed()
    }
}
