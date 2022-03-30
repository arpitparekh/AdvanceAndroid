package com.example.advanceandroid.sensor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;

import com.example.advanceandroid.databinding.ActivityMySensorBinding;

import java.util.Random;

public class MySensorActivity extends AppCompatActivity implements SensorEventListener {

    private ActivityMySensorBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMySensorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SensorManager manager = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        Sensor light = manager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        Sensor speed = manager.getDefaultSensor(Sensor.TYPE_GRAVITY);

        manager.registerListener(this,light,SensorManager.SENSOR_DELAY_NORMAL);

        manager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        },speed,SensorManager.SENSOR_DELAY_NORMAL);

    }

    int random(){
        Random random = new Random();
        return random.nextInt(266);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(sensorEvent.values[0]<4.0f){
            binding.getRoot().setBackgroundColor(Color.rgb(random(),random(),random()));
        }else{
            binding.getRoot().setBackgroundColor(Color.BLACK);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}