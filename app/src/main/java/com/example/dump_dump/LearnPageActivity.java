package com.example.dump_dump;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.IBinder;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;

public class LearnPageActivity extends AppCompatActivity {
    Button button;
    ImageButton imagebutton;
    ImageButton settingButton;
    private MediaPlayer mediaPlayer;


    private ServiceConnection connection = new ServiceConnection() {
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
        setContentView(R.layout.activity_learn_page);

        button = findViewById (R.id.wasteSegButton);
        button.setOnClickListener(v -> openWasteSegAct());

        imagebutton = findViewById (R.id.homepageButton);
        imagebutton.setOnClickListener(v -> openHomePageActivity());

        button = findViewById (R.id.wasteManageButton);
        button.setOnClickListener(v -> openWasteManageAct());

        settingButton = findViewById(R.id.settingButton);
        settingButton.setOnClickListener(v -> showAlertDialogue());
    }

    public void openWasteSegAct(){
        Intent intent = new Intent(this, WasteSegregationActivity.class);
        startActivity(intent);
    }

    public void openWasteManageAct(){
        Intent intent = new Intent(this, WasteManagementActivity.class);
        startActivity(intent);
    }

    public void openHomePageActivity(){
        Intent intent = new Intent(this, HomePageActivity.class);
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
