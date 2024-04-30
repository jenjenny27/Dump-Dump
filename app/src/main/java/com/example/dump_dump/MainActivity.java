package com.example.dump_dump;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(MainActivity.this,HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

        Intent serviceIntent = new Intent(this, BackgroundServices.class);
        startService(serviceIntent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish(); // Finish the current activity
    }
}
