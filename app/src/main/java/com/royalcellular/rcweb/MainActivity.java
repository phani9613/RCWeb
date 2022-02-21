package com.royalcellular.rcweb;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;


public class MainActivity extends AppCompatActivity {
            private WebView mWebView;

            @Override
            @SuppressLint("SetJavaScriptEnabled")
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                Intent webViewIntent = getIntent();
                String url = "http://freshclearmajesticstars.neverssl.com/";
                mWebView = findViewById(R.id.activity_main_webview);

                mWebView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        return false;
                    }
                });
                mWebView.loadUrl("about:blank");
                WebSettings webSettings = mWebView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setAppCacheEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setUseWideViewPort(true);
                webSettings.setLoadWithOverviewMode(true);
                mWebView.loadUrl(url);
                WifiManager manager=(WifiManager) getSystemService(Context.WIFI_SERVICE);
                String ip = null;
                try {
                    ip = InetAddress.getByAddress(
                            ByteBuffer
                                    .allocate(Integer.BYTES)
                                    .order(ByteOrder.LITTLE_ENDIAN)
                                    .putInt(manager.getConnectionInfo().getIpAddress())
                                    .array()
                    ).getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                System.out.print("MyIP "+ip);
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

