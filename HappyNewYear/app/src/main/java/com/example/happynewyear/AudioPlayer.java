package com.example.happynewyear;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
    private MediaPlayer mediaPlayer;
    private Context context;
    private int soundId;
    public AudioPlayer(Context context, int soundId) {
        this.context = context;
        this.soundId = soundId;
        mediaPlayer = MediaPlayer.create(context, soundId);
    }
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    public void play() {
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    //что делать если музыка закончилась
                    stop();
                }
            });
        } else{
            mediaPlayer = MediaPlayer.create(context, soundId);
        }
        mediaPlayer.start();
    }
}
