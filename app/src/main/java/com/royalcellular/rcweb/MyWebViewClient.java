package com.royalcellular.rcweb;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {
@Override
public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        String hostname;

        // YOUR HOSTNAME
        hostname = "http://royalcellular.in";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(hostname));
        view.getContext().startActivity(intent);
        return true;
        }
}