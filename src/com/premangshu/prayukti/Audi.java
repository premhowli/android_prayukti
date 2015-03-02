package com.premangshu.prayukti;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import java.io.IOException;
import android.content.res.AssetFileDescriptor;
import android.util.Log;

public class Audi extends Service{
    private static final String LOGCAT = null;
    MediaPlayer player;

    public void onCreate(){
        super.onCreate();
        Log.d(LOGCAT, "Service Started!");
        AssetFileDescriptor afd;
        try {
// Read the music file from the asset folder
            afd = getAssets().openFd("audio.mp3");
// Creation of new media player;

// Set the player music source.
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),afd.getLength());
// Set the looping and play the music.
            player.setLooping(true);
            player.prepare();
            player.start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int onStartCommand(Intent intent, int flags, int startId){
        player.start();
        Log.d(LOGCAT, "Media Player started!");
        if(player.isLooping() != true){
            Log.d(LOGCAT, "Problem in Playing Audio");
        }
        return 1;
    }

    public void onStop(){
        player.stop();
        player.release();
    }

    public void onPause(){
        player.stop();
        player.release();
    }
    public void onDestroy(){
        player.stop();
        player

                .release();
    }
    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }
}