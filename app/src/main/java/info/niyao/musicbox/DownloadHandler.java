package info.niyao.musicbox;
// Created on 6/4/2017


import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class DownloadHandler extends Handler {
    private static final String TAG = DownloadHandler.class.getSimpleName();
    private DownloadService mService;

    @Override
    public void handleMessage(Message msg) {
        downloadSong(msg.obj.toString());
        mService.stopSelf(msg.arg1);

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

    public void setService(DownloadService service) {
        mService = service;
    }
}
