package com.example.dump_dump;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.IBinder;
import android.widget.ImageButton;

public class WasteSegregationActivity extends AppCompatActivity {
    ImageButton imagebutton;
    ImageButton settingButton;
    private MediaPlayer mediaPlayer;

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            BackgroundServices.LocalBinder binder = (BackgroundServices.LocalBinder) service;
            BackgroundServices backgroundServices = binder.getService();
            mediaPlayer = backgroundServices.getMediaPlayer();
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mediaPlayer = null;
        }
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waste_segregation);

        imagebutton = findViewById (R.id.backButton);
        imagebutton.setOnClickListener(v -> openLearnPageActivity());

        imagebutton = findViewById (R.id.button5);
        imagebutton.setOnClickListener(v -> openCompostableActivity());

        imagebutton = findViewById (R.id.button8);
        imagebutton.setOnClickListener(v -> openRecyclableActivity());

        imagebutton = findViewById (R.id.button6);
        imagebutton.setOnClickListener(v -> openNonBioActivity());

        imagebutton = findViewById (R.id.button7);
        imagebutton.setOnClickListener(v -> openHazardousActivity());

        imagebutton = findViewById (R.id.button9);
        imagebutton.setOnClickListener(v -> openHealthCareActivity());

        settingButton = findViewById(R.id.settingButton);
        settingButton.setOnClickListener(v -> showAlertDialogue());
    }

    public void openLearnPageActivity(){
        Intent intent = new Intent(this, LearnPageActivity.class);
        startActivity(intent);
    }

    public void openCompostableActivity(){
        Intent intent = new Intent(this, CompostablePage.class);
        startActivity(intent);
    }

    public void openNonBioActivity(){
        Intent intent = new Intent(this, NonBioPage.class);
        startActivity(intent);
    }

    public void openRecyclableActivity(){
        Intent intent = new Intent(this, RecyclablePage.class);
        startActivity(intent);
    }

    public void openHazardousActivity(){
        Intent intent = new Intent(this, HazardousPage.class);
        startActivity(intent);
    }

    public void openHealthCareActivity(){
        Intent intent = new Intent(this, HealthCarePage.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        unbindService(connection);
    }

    public void showAlertDialogue(){
        Intent intent = new Intent(this, SettingPage.class);
        startActivity(intent);
    }


}
