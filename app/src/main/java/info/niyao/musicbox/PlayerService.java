package info.niyao.musicbox;
// Created on 6/8/2017


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.Messenger;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

public class PlayerService extends Service {
    private static final String TAG = PlayerService.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    public Messenger mMessenger = new Messenger(new PlayerHandler(this));

    @Override
    public void onCreate() {
        //Not needed for a Service: super.onCreate();
        Log.d(TAG, "onCreate");
        mMediaPlayer = MediaPlayer.create(this, R.raw.jingle);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopSelf();
            }
        });
        return Service.START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return mMessenger.getBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnBind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        mMediaPlayer.release();
    }


    //Client Methods
    public void play(){
        mMediaPlayer.start();
    }

    public void pause(){
        mMediaPlayer.pause();
    }

    public boolean isPlaying(){
        return mMediaPlayer.isPlaying();
    }
}









