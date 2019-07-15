package com.charles.alc4phase1

import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.*
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    private var webview: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        toolbar!!.title = "About ALC"
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(true)

        webview = about_alc_webview
        webview!!.settings.javaScriptEnabled = true
        webview!!.clearSslPreferences()
        webview!!.webViewClient = object: WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//                if (Uri.parse(url).host == getString(R.string.website_domain)) {
//                    return false
//                }
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
                return true
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler?.proceed()
            }
        }

        Log.ERROR
        webview!!.loadUrl("https://andela.com/alc/")
    }
}
