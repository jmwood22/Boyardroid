package com.crunchers.boyardroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;


public class MusicService extends Service {

    private final IBinder mBinder = new ServiceBinder();
    MediaPlayer mPlayer;

    public MusicService() { }

    public class ServiceBinder extends Binder {
     	 MusicService getService()
    	 {
    		return MusicService.this;
    	 }
    }

    @Override
    public IBinder onBind(Intent arg0){return mBinder;}

    @Override
    public void onCreate (){
	  super.onCreate();

       mPlayer = MediaPlayer.create(this, R.raw.yoshi);
       mPlayer.setLooping(true);
       mPlayer.setVolume(100,100);
       mPlayer.start();
	}
    
    @Override
	public int onStartCommand (Intent intent, int flags, int startId)
	{
         mPlayer.start();
         return START_STICKY;
	}
    
    @Override
    public void onDestroy() {
        super.onDestroy();
    	mPlayer.stop();
    	mPlayer.release();
    }
}

    
    