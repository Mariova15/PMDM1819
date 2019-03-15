package com.example.mario.juegosclasicos;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServicioMusica extends Service {

    public static final String ACCION_REPRODUCTOR_PAUSADO="com.example.mario.juegosclasico.intent.action.ACCION_REPRODUCTOR_PAUSADO";
    private MediaPlayer mp;


    public ServicioMusica() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this,R.raw.audio);

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if(mp!=null && mp.isPlaying())
            mp.pause();
        Intent intent=new Intent();
        intent.setAction(ACCION_REPRODUCTOR_PAUSADO);
        sendBroadcast(intent);
        super.onDestroy();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
