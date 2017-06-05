package info.niyao.musicbox;
// Created on 6/4/2017


import android.os.Looper;
import android.util.Log;

public class DownloadThread extends Thread {
    private static final String TAG = DownloadThread.class.getSimpleName();
    public DownloadHandler mHandler;

    @Override
    public void run() {
        Looper.prepare();
        mHandler = new DownloadHandler();
        //Looper is auto associated with this thread
        Looper.loop();

    }

}
