package com.example.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;
    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.sleepy_princess);
        mediaPlayer.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent notifIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,
                notifIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        //Менеджер уведомлений
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //создать канал для уведомлений
        NotificationChannel channel = new NotificationChannel("my channel", "music",
                NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(channel);
        //создать само уведомление
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this, "my channel")
                .setChannelId("my channel")
                .setContentTitle("Уведомление")
                .setContentText("Работать!!!")
                .setSmallIcon(R.drawable.rofl)
                .setContentIntent(pendingIntent);
        Notification myNotif = notifBuilder.build();
        notificationManager.notify(947291, myNotif);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}