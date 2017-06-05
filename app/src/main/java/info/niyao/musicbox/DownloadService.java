package info.niyao.musicbox;
// Created on 6/5/2017


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

public class DownloadService extends Service {
    private final String TAG = DownloadService.class.getSimpleName();

    @Override
    public int onStartCommand(Intent intent, @IntDef(value = {Service.START_FLAG_REDELIVERY, Service.START_FLAG_RETRY}, flag = true) int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
    
    private void downloadSong(String song) {
        long endtime = System.currentTimeMillis() + 10 * 1000;
        while (System.currentTimeMillis() < endtime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, song + " downloaded!");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
