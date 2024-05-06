package com.example.dump_dump;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this,HomePageActivity.class);
            startActivity(intent);
            finish();
        }, 3000);

        Intent serviceIntent = new Intent(this, BackgroundServices.class);
        startService(serviceIntent);
    }
}
