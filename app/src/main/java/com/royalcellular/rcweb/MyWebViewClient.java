package com.royalcellular.rcweb;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {
@SuppressWarnings("deprecation")
@Override
public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        String hostname;

        // YOUR HOSTNAME
        hostname = "https://www.google.com/";

        Uri uri = Uri.parse(hostname);
        if (request.getUrl() !=null || uri.getHost() != null && uri.getHost().endsWith(hostname)) {
        return false;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request.getUrl().toString()));
        view.getContext().startActivity(intent);
        return true;
        }
        }