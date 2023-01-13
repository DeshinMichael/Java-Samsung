package com.example.happynewyear;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    AudioPlayer audioPlayer;
    AudioAttributes audioAttributes;
    SoundPool soundPool;
    int soundID1;
    int soundID2;
    boolean loaded = false;
    int streamID1;
    int streamID2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioPlayer = new AudioPlayer(this, R.raw.newyearsong);

        audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .build();

        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });
        soundID1 = soundPool.load(this, R.raw.fire_boom, 1);
        soundID2 = soundPool.load(this, R.raw.shampanesong, 1);

        audioPlayer.play();
    }

    @Override
    protected void onResume() {
        super.onResume();
        audioPlayer.play();
        if (loaded) {
            streamID1 = soundPool.play(soundID1,1.0f,1.0f,1,10,1f);
            streamID2 = soundPool.play(soundID2,1.0f,1.0f,1,0,1f);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        audioPlayer.stop();
    }
}