package com.acadgild.session12;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadReceiver2 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mainIntent=new Intent(context,MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mainIntent);
    }
}
