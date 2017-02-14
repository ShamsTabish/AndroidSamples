package com.acadgild.session2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class AndroidActivityLifecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_android_lifecycle);

        Log.i("Session2", "Activity Created");

        for (int i = 0; i < 20; i++) {
            int j = add5(i);
            Log.i("Session2", "Activity i*j =>" + (i * j));
        }

        Intent i = new Intent(AndroidActivityLifecycle.this, ActTwo.class);
        Bundle b = new Bundle();
        b.putString("Name", "Heyaa....");
        i.putExtras(b);
        startActivity(i);

    }

    int add5(int number) {
        return number + 5;
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Session2", "Activity Started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Session2", "Activity Paused");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Session2", "Activity Restarted");
    }

    @Override
    protected void onResume() {
        super.onResume();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        Intent intent = new Intent(AndroidActivityLifecycle.this,ActTwo.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
//        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentTitle("Notifications Title");
        builder.setContentText("Your notification content here.");
        builder.setSubText("Tap to view the website.");

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Will display the notification in the notification bar
        notificationManager.notify(1, builder.build());



        Log.i("Session2", "Activity Resumed");
        Toast toast = Toast.makeText(AndroidActivityLifecycle.this, "--------------------------Resuming the Activity -------------------------- :)", Toast.LENGTH_LONG);
        toast.setGravity(0, 45, 45);
        toast.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Session2", "Activity Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Session2", "Activity Destroy..");
    }

    public void showMessage(View v) {
//        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
//        sendIntent.putExtra("sms_body", "default content");
//        sendIntent.set
//        sendIntent.setType("vnd.android-dir/mms-sms");
//        startActivity(sendIntent);


        Intent shareIntent=new Intent(Intent.ACTION_VIEW);
        shareIntent.setData(Uri.parse("http://google.com"));

        Bundle bundle=new Bundle();
        bundle.putString("From ","Bangalore");
        shareIntent.putExtras(bundle);
        startActivity(shareIntent);
        Toast.makeText(AndroidActivityLifecycle.this, "Button Pressed", Toast.LENGTH_LONG).show();
    }
}
