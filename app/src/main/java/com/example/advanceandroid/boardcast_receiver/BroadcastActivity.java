package com.example.advanceandroid.boardcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.advanceandroid.databinding.ActivityBroadcastBinding;

public class BroadcastActivity extends AppCompatActivity {

    private ActivityBroadcastBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBroadcastBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(new AirplaneModeReceiver(),filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(new AirplaneModeReceiver());
    }
}