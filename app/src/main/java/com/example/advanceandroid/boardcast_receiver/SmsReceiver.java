package com.example.advanceandroid.boardcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;

public class SmsReceiver extends BroadcastReceiver {

    EditText editText;

    SmsReceiver(EditText editText){
        this.editText = editText;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){

            SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

            for(SmsMessage sms : messages){

                String msg = sms.getMessageBody();
                String otp = msg.split(": ")[1];

                Log.i("msg",otp);

                editText.setText(otp);

            }

        }
    }
}
