package com.app.fitbitauthdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.fitbitauthdemo.Utility.AuthenticatingWebView
import com.app.fitbitauthdemo.Utility.AuthenticatingWebViewCallbackMethods
import java.util.HashMap
import com.app.fitbitauthdemo.Utility.*
import java.net.URL


class MainActivity : AppCompatActivity(), AuthenticatingWebViewCallbackMethods {

    lateinit var authenticatingWebView: AuthenticatingWebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        authenticatingWebView =
            AuthenticatingWebView(
                findViewById(R.id.webView),
                this
            )

        val urlFitbit = URL("$FITBIT_CONNECT_BASE_URL?response_type=code&client_id=$CLIENT_ID&redirect_uri=$FITBIT_REDIRECT_URL&scope=$DEFAULT_SCOPES")
        Log.e(MAIN_ACTIVITY_TAG, urlFitbit.toString())

        authenticatingWebView.makeRequest(urlFitbit.toString())
    }

    override fun displayResults(authorizationReturnParameters: HashMap<String, String>) {
        Log.e(MAIN_ACTIVITY_TAG, ""+authorizationReturnParameters)
    }

    override fun stopProgressDialog() {

    }

    override fun startProgressDialog() {

    }
}
