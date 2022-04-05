package com.example.advanceandroid.notification;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;

import com.example.advanceandroid.R;
import com.example.advanceandroid.databinding.ActivityShowNotificationBinding;

public class ShowNotificationActivity extends AppCompatActivity {

    private ActivityShowNotificationBinding binding;
    private NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            manager = getSystemService(NotificationManager.class);
            NotificationChannel channel = new NotificationChannel("101","MyChannel", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }

        binding.btnShowNotification.setOnClickListener(view -> {

            String msg = binding.edtMessage.getText().toString();

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"101")
                        .setSmallIcon(R.drawable.ic_payment)
                        .setContentTitle("This is Your Notification")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setContentText(msg);

                manager.notify(0,builder.build());
            }

        });

    }
}