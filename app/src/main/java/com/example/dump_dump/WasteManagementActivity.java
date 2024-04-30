package com.example.dump_dump;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class WasteManagementActivity extends AppCompatActivity {

    ImageButton homepageButton;
    ImageButton previousButton;

    ImageButton nextButton;
    private WebView webView;

    @SuppressLint({"SetJavaScriptEnabled", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waste_management);

        homepageButton = findViewById(R.id.homepageButton);
        homepageButton.setOnClickListener(v -> openLearnPageActivity());

        previousButton = findViewById(R.id.previousButton);
        previousButton.setOnClickListener(v -> loadPreviouspageContent());

        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(v -> loadnextpageContent());

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript if needed
        webView.setBackgroundColor(Color.parseColor("#C7CFC1"));

        // Load the HTML content into the WebView
        webView.loadUrl("file:///android_asset/waste.html");

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
                if (url.equals("file:///android_asset/waste.html") ) {
                    // Set the height of the WebView to match the screen height
                    previousButton.setVisibility(android.view.View.GONE);
                    ViewGroup.LayoutParams params = webView.getLayoutParams();
                    params.height = getScreenHeight();
                    webView.setLayoutParams(params);
                } else {
                    // Reset the height of the WebView
                    previousButton.setVisibility(android.view.View.VISIBLE);
                    ViewGroup.LayoutParams params = webView.getLayoutParams();
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    webView.setLayoutParams(params);
                }

                if (url.equals("file:///android_asset/quiz.html")) {
                    // Set the height of the WebView to match the screen height
                    nextButton.setVisibility(android.view.View.GONE);

                } else {
                    // Reset the height of the WebView
                    nextButton.setVisibility(android.view.View.VISIBLE);
                }

            }
        });
    }

    public void openLearnPageActivity() {
        Intent intent = new Intent(this, LearnPageActivity.class);
        startActivity(intent);
    }

    private void loadPreviouspageContent() {
        String currentUrl = webView.getUrl();

        // Check if the current URL is "file:///android_asset/waste.html"
        if (currentUrl != null && currentUrl.equals("file:///android_asset/RA9003.html")) {
            // If the current URL is "waste.html", load "RA9003.html"
            webView.loadUrl("file:///android_asset/waste.html");
        }
        if (currentUrl != null && currentUrl.equals("file:///android_asset/index.html")){
            webView.loadUrl("file:///android_asset/RA9003.html");
        }
        if (currentUrl != null && currentUrl.equals("file:///android_asset/quiz.html")){
            webView.loadUrl("file:///android_asset/index.html");
        }
    }

    private void loadnextpageContent() {
        String currentUrl = webView.getUrl();

        // Check if the current URL is "file:///android_asset/waste.html"
        if (currentUrl != null && currentUrl.equals("file:///android_asset/waste.html")) {
            // If the current URL is "waste.html", load "RA9003.html"
            webView.loadUrl("file:///android_asset/RA9003.html");
        }
        if (currentUrl != null && currentUrl.equals("file:///android_asset/RA9003.html")){
            webView.loadUrl("file:///android_asset/index.html");
        }
        if (currentUrl != null && currentUrl.equals("file:///android_asset/index.html")){
            webView.loadUrl("file:///android_asset/quiz.html");

        }
    }


    private int getScreenHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }

}