package com.acadgild.session12;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


public class MyBroadcastDemo extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Toast.makeText(context, "Broadcast Received", Toast.LENGTH_SHORT).show();
        Intent msgReceived = new Intent(context, PinkActivity.class);
        msgReceived.setFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(msgReceived);

        for (int i=0;i<20;i++)
        {

            Log.i("MainActivity--- "," Event ocuured"+i );


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
