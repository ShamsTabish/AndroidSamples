package com.acadgild.session12;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_received);

        IntentFilter selectMessage = new IntentFilter("android.intent.action.SCREEN_ON");
        BroadReceiver2 myReceiver = new BroadReceiver2();
        registerReceiver(myReceiver, selectMessage);

    }
}
