package com.example.advanceandroid.boardcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

import com.example.advanceandroid.databinding.ActivitySmsactivityBinding;

public class SMSActivity extends AppCompatActivity {

    private ActivitySmsactivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySmsactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SmsReceiver receiver = new SmsReceiver(binding.edtOtp);
        IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(receiver,filter);
    }
}