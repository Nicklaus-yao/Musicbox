package info.niyao.musicbox;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.downloadButton) Button downloadButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        final DownloadThread thread = new DownloadThread();
//        thread.setName("DownloadThread");
//        thread.start();

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_SHORT).show();

//                Runnable runnable = new Runnable() {
//                    @Override
//                    public void run() {
//                        downloadSong();
//                    }
//                };
//                Thread thread = new Thread(runnable);
//                thread.setName("DownloadThread");
//                thread.start();

//                DownloadThread thread = new DownloadThread();
//                thread.setName("DownloadThread");
//                thread.start();

                //Send Messages to Handler for processing
                for (String song : Playlist.songs){
//                    Message message = Message.obtain();
//                    message.obj = song;
//                    thread.mHandler.sendMessage(message);
                    Intent intent = new Intent(MainActivity.this, DownloadService.class)
                }
            }
        });

    }

}
