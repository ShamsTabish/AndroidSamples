package com.acadgild.session3;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondScreen extends AppCompatActivity {

    TextView cityLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        cityLabel=(TextView)findViewById(R.id.cityLabel);

        Bundle dataBundle=getIntent().getExtras();
        String city=dataBundle.getString(getString(R.string.city));
        Toast.makeText(this, city, Toast.LENGTH_SHORT).show();


        Intent passedIntent=getIntent();
        String name=passedIntent.getStringExtra("name");

        cityLabel.setText("city: "+city+ " "+name);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        Intent browse=new Intent(Intent.ACTION_VIEW, Uri.parse("http://news.google.com"));

        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,browse,0);
        builder.setContentIntent(pendingIntent);
        builder.setContentText("Main Title");
        builder.setContentText("Description of the notification that we created...");
        builder.setSubText("This is sub text, it could occupy more info..");

        NotificationManager notificationService=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

            notificationService.notify(1,builder.build());

    }
}
