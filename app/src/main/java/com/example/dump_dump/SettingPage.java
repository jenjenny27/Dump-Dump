package com.example.dump_dump;


import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SettingPage extends AppCompatActivity {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch musicSwitch;
    BackgroundServices backgroundServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialize the switch
        musicSwitch = findViewById(R.id.musicSwitch);

//        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // Bind to the BackgroundServices service
        Intent serviceIntent = new Intent(this, BackgroundServices.class);
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);

        // Set a listener for the switch
        musicSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // If the switch is turned off, stop the music
            if (!isChecked && backgroundServices != null) {
                backgroundServices.stopMusic();
            }else if (isChecked && backgroundServices != null) {
                // If the switch is turned on, start the music
                backgroundServices.playMusic();
            }
        });

        // Close button
        ImageButton closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> finish());
    }


    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            // Cast the IBinder to LocalBinder and get the service instance
            BackgroundServices.LocalBinder binder = (BackgroundServices.LocalBinder) service;
            backgroundServices = binder.getService();

            // Update the switch state based on music playback
            updateSwitchState();
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            backgroundServices = null;
        }
    };

    private void updateSwitchState() {
        // Update the switch state based on music playback
        if (backgroundServices != null) {
            musicSwitch.setChecked(backgroundServices.isMusicPlaying());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unbind from the service
        if (backgroundServices != null) {
            unbindService(serviceConnection);
        }
    }
}