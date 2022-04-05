package com.example.advanceandroid.paytm_all_in_one_sdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.advanceandroid.databinding.ActivityPaytmBinding;

public class PaytmActivity extends AppCompatActivity {

    private ActivityPaytmBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaytmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // still pending....

    }
}