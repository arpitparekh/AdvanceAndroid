package com.example.advanceandroid.video_related;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.advanceandroid.R;
import com.example.advanceandroid.databinding.ActivityExoPlayerBinding;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;

public class ExoPlayerActivity extends AppCompatActivity {

    private ActivityExoPlayerBinding binding;
    private ExoPlayer player;
    private int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExoPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //set video quality
        DefaultTrackSelector trackSelector = new DefaultTrackSelector(this);
        trackSelector.setParameters(trackSelector.buildUponParameters().setMaxVideoSizeSd());

        player = new ExoPlayer.Builder(this).setTrackSelector(trackSelector).build();

        MediaItem item = MediaItem.fromUri(Uri.parse("android.resource://"+getPackageName() +"/"+ R.raw.demo));

        player.setMediaItem(item);

        binding.exoPlayer.setPlayer(player);

        player.play();


    }
}