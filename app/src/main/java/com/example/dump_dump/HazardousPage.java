package com.example.dump_dump;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HazardousPage extends AppCompatActivity {

    ImageButton imagebutton;
    ImageButton previousButton;

    ImageButton nextButton;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compostable_page);

        imagebutton = findViewById (R.id.backButton);
        imagebutton.setOnClickListener(v -> openWasteSegregationActivity());

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript if needed
        webView.loadUrl("file:///android_asset/hazardous.html");

        // Set layout parameters to match content dimensions
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        // Set up WebViewClient to detect page loading
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                // Check if the waste.html page is being loaded
                if (url.equals("file:///android_asset/hazardous.html")) {
                    // Set the height of the WebView to match the screen height
                    ViewGroup.LayoutParams params = webView.getLayoutParams();
                    params.height = getScreenHeight();
                    webView.setLayoutParams(params);
                } else {
                    // Reset the height of the WebView
                    ViewGroup.LayoutParams params = webView.getLayoutParams();
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    webView.setLayoutParams(params);
                }
            }
        });
    }

    public void openWasteSegregationActivity(){
        Intent intent = new Intent(this, WasteSegregationActivity.class);
        startActivity(intent);
    }


    private int getScreenHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
