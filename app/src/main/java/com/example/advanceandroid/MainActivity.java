package com.example.advanceandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.advanceandroid.audio_related.AudioRelatedActivity;
import com.example.advanceandroid.databinding.ActivityMainBinding;
import com.example.advanceandroid.payment_razorpay.PaymentActivity;
import com.example.advanceandroid.sensor.MySensorActivity;
import com.example.advanceandroid.video_related.ExoPlayerActivity;
import com.example.advanceandroid.video_related.MyVideoActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAudio.setOnClickListener(view -> {
            startActivity(new Intent(this, AudioRelatedActivity.class));
        });
        binding.btnVideo.setOnClickListener(view -> {
            startActivity(new Intent(this, ExoPlayerActivity.class));
        });
        binding.btnSensor.setOnClickListener(view -> {
            startActivity(new Intent(this, MySensorActivity.class));
        });
        binding.btnPayment.setOnClickListener(view -> {
            startActivity(new Intent(this, PaymentActivity.class));
        });
    }
}