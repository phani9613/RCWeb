package com.royalcellular.rcweb;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


        public class MainActivity extends AppCompatActivity {
            private WebView mWebView;

            @Override
            @SuppressLint("SetJavaScriptEnabled")
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                mWebView = findViewById(R.id.activity_main_webview);
                WebSettings webSettings = mWebView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                mWebView.setWebViewClient(new MyWebViewClient());


            }

            @Override
            public void onBackPressed() {
                if(mWebView.canGoBack()) {
                    mWebView.goBack();
                } else {
                    super.onBackPressed();
                }
            }
    }

