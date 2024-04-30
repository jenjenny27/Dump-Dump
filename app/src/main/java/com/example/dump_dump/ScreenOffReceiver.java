package com.example.dump_dump;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenOffReceiver extends BroadcastReceiver {
    private BackgroundServices backgroundServices;

    public ScreenOffReceiver(BackgroundServices backgroundServices) {
        this.backgroundServices = backgroundServices;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals(Intent.ACTION_SCREEN_OFF)) {
            // Pause the music playback when the screen is turned off
            backgroundServices.stopMusic();
        } else if (action != null && action.equals(Intent.ACTION_SCREEN_ON)) {
            // Resume music playback when the screen is turned on
            backgroundServices.resumeMusic();
        }
    }
}
