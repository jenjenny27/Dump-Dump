package com.example.dump_dump;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.os.IBinder;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.media.MediaPlayer;
import android.content.ComponentName;
import android.content.ServiceConnection;

public class HomePageActivity extends AppCompatActivity {
    Button button;
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

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        Intent serviceIntent = new Intent(this, BackgroundServices.class);
        bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE);

        button =  findViewById (R.id.button2);
        button.setOnClickListener(v -> openLearnPageActivity());

        settingButton = findViewById(R.id.settingButton);
        settingButton.setOnClickListener(v -> showAlertDialogue());


    }

    public void openLearnPageActivity(){
        Intent intent = new Intent(this, LearnPageActivity.class);
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