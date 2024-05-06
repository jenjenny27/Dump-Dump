package com.example.dump_dump;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BackgroundServices extends Service {

    private final IBinder binder = new LocalBinder();
    private MediaPlayer mediaPlayer;
    private ScreenOffReceiver screenOffReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        if (mediaPlayer == null) {
            Log.e("BackgroundServices", "Failed to create MediaPlayer");
            stopSelf(); // Stop the service if MediaPlayer creation fails
            return;
        }

        mediaPlayer.setOnErrorListener((mp, what, extra) -> {
            Log.e("BackgroundServices", "MediaPlayer error: " + what + ", " + extra);
            return false;
        });

        mediaPlayer.setOnCompletionListener(mp -> {
            // Handle completion if needed
        });

        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        // Register the BroadcastReceiver for screen off and screen on events
        screenOffReceiver = new ScreenOffReceiver(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(screenOffReceiver, filter);
    }

    public boolean isMusicPlaying() {
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public void stopMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void playMusic() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public class LocalBinder extends Binder {
        BackgroundServices getService() {
            return BackgroundServices.this;
        }
    }

    public void resumeMusic() {
        boolean wasPlayingBeforeScreenOff = true;
        if (wasPlayingBeforeScreenOff) {
            mediaPlayer.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (screenOffReceiver != null) {
            unregisterReceiver(screenOffReceiver);
        }
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
