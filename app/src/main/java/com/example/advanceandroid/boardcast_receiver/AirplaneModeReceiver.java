package com.example.advanceandroid.boardcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0)!=0){

            Toast.makeText(context, "Airplane Mode on", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "Airplane Mode Off", Toast.LENGTH_LONG).show();
        }
    }
}
