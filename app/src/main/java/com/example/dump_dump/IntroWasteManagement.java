package com.example.dump_dump;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class IntroWasteManagement extends AppCompatActivity {

    ImageButton imagebutton;
    private WebView webView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_wastemanagement);

        imagebutton = findViewById (R.id.homepageButton);
        imagebutton.setOnClickListener(v -> openLearnPageActivity());

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript if needed

        webView.loadUrl("file:///android_asset/waste.html");
        // Set layout parameters to match content dimensions
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
    }

    public void openLearnPageActivity(){
        Intent intent = new Intent(this, LearnPageActivity.class);
        startActivity(intent);
    }
}
