package com.premangshu.prayukti;


/**
 * Created by Premangshu on 02-03-2015.
 */

import android.app.Activity;
import android.os.Bundle;
import android.media.MediaPlayer;
import java.io.IOException;
import android.content.res.AssetFileDescriptor;


public class Audio extends Activity {
    MediaPlayer player=new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        }}

// Always use try catch block two avoid error exception.

    //If an activity is pause, say out of user visibility you have call this in order to avoid collision of other sound of other activity
    public void onPause() {
        super.onPause();
        player.pause();
    }

    //To resume this player we have to call following method.
    public void onResume() {
        super.onResume();
        player.start();
    }

    //When activity is going to stop we have to call this to release the media player
    protected void onStop() {
        super.onStop();
        player.stop();
        player = null;
    }
}

