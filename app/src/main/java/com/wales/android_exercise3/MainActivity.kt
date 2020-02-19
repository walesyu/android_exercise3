package com.wales.android_exercise3

import android.app.Activity
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.webkit.*
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //var webViewClient = WebViewClient()
        webView.webViewClient = MyWebViewClient(this)
        webView.webChromeClient = WebChromeClient()

        //webView.webViewClient
        webView.loadUrl("https://www.google.com/")
    }
}

class MyWebViewClient internal constructor(private val activity: Activity) : WebViewClient() {

    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
        webView.loadUrl(url)
        return true
    }

    override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
        Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
    }
}


