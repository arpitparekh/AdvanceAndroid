package com.example.advanceandroid.audio_related;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.example.advanceandroid.R;
import com.example.advanceandroid.databinding.ActivityAudioRelatedBinding;

import java.io.IOException;

public class AudioRelatedActivity extends AppCompatActivity {

    private ActivityAudioRelatedBinding binding;
    private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAudioRelatedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String uriPath = "android.resource://"+getPackageName() +"/"+ R.raw.music;
        Uri uri = Uri.parse(uriPath);

        player = MediaPlayer.create(this,uri);
        player.setVolume(100,100);
        try {
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    while(player!=null){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                binding.seekBar.setProgress(player.getCurrentPosition());
                            }
                        });

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                player.seekTo(binding.seekBar.getProgress());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                player.seekTo(binding.seekBar.getProgress());
            }
        });

        binding.btnStart.setOnClickListener(view -> {

            binding.avLottie.resumeAnimation();
            if(!player.isPlaying()){

                player.start();
            }

        });
        binding.btnPause.setOnClickListener(view -> {
            binding.avLottie.pauseAnimation();
            player.pause();
        });
        binding.btnStop.setOnClickListener(view -> {
            binding.avLottie.pauseAnimation();
            player.stop();
        });

    }
}