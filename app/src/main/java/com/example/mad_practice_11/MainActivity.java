package com.example.mad_practice_11;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView web;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.web_view);
        progress = findViewById(R.id.progress_bar);

        web.setWebViewClient(new WebClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(getString(R.string.url));
    }

    public class WebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            progress.setVisibility(View.VISIBLE);
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progress.setVisibility(View.GONE);
        }
    }
}