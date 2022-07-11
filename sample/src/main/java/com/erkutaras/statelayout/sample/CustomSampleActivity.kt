package com.erkutaras.statelayout.sample

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.*
import android.widget.TextView
import androidx.core.widget.ContentLoadingProgressBar
import com.erkutaras.statelayout.sample.databinding.ActivityCustomSampleBinding

/**
 * Created by erkutaras on 21.12.2018.
 */
private const val WEB_URL = "https://medium.com/@erkutaras"

class CustomSampleActivity : SampleBaseActivity<ActivityCustomSampleBinding>() {

    private var hasError: Boolean = false
    private lateinit var loadingProgressBar: ContentLoadingProgressBar
    private lateinit var textViewProgress: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomSampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            loadingProgressBar = stateLayout.findViewById(R.id.contentLoadingProgressBar)
            textViewProgress = stateLayout.findViewById(R.id.textView_progress)
            webView.webViewClient = object : WebViewClient() {

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    hasError = false
                    if (url.equals(WEB_URL)) stateLayout.loading()
                    else stateLayout.loadingWithContent()
                }

                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?
                ) {
                    super.onReceivedError(view, request, error)
                    hasError = true
                    showInfoState()
                }
            }
            webView.webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    loadingProgressBar.progress = newProgress
                    textViewProgress.text = "$newProgress%"

                    if (!hasError && newProgress == 100) stateLayout.content()
                    if (hasError && newProgress == 100) showInfoState()
                }
            }
        }
        loadUrl()
    }

    override fun getMenuResId(): Int = R.menu.menu_custom

    private fun showInfoState() {
        with(binding) {
            stateLayout.info()
            stateLayout.findViewById<View>(R.id.button_refresh).setOnClickListener { loadUrl() }
            stateLayout.findViewById<View>(R.id.button_close).setOnClickListener { finish() }
        }
    }

    private fun loadUrl() {
        binding.webView.loadUrl(WEB_URL)
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) binding.webView.goBack()
        else super.onBackPressed()
    }
}