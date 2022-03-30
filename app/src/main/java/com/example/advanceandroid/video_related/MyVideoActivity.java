package com.example.advanceandroid.video_related;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.advanceandroid.R;
import com.example.advanceandroid.databinding.ActivityMyVideoBinding;

import java.util.Objects;

public class MyVideoActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    private ActivityMyVideoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Loading");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        binding.videoView.setMediaController(new MediaController(this));
        binding.videoView.setOnCompletionListener(this);

        // from raw folder
        String uriPath = "android.resource://"+getPackageName() +"/"+ R.raw.demo;
//        Uri uri = Uri.parse(uriPath);

        // from url
        String url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4";
        Uri uri = Uri.parse(url);
        binding.videoView.setVideoURI(uri);
        binding.videoView.requestFocus();
        binding.videoView.start();

        binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
                        if(i==MediaPlayer.MEDIA_INFO_BUFFERING_START){
                            pd.show();
                        }else if(i==MediaPlayer.MEDIA_INFO_BUFFERING_END){
                            pd.dismiss();
                        }
//                        else if(i==MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START){
//                            pd.show();
//                        }
                        return false;
                    }
                });
            }
        });

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }
}