package com.acadgild.session12;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {
    static int id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    void showNotification(View v) {


        Intent pinkIntent=new Intent(this,PinkActivity.class);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle(id + "Main Title for the Notification");
        notificationBuilder.setSubText("Thuis is s a sub text");
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);

        notificationBuilder.addAction(R.mipmap.ic_launcher,"Open This Activity", PendingIntent.getActivity(this,0,pinkIntent,0,null));

        NotificationManager myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotificationManager.notify(id++, notificationBuilder.build());


    }

    void showInboxNotification(View v) {

        NotificationCompat.InboxStyle inboxStyle = new android.support.v4.app.NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Big Title");
        inboxStyle.addLine("Line1");
        inboxStyle.addLine("Line2");
        inboxStyle.addLine("Line3");
        inboxStyle.addLine("Line4");
        inboxStyle.addLine("Line5");
        inboxStyle.setSummaryText("15 Messages received...");

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle(id + "Main Title for the Notification");
        notificationBuilder.setSubText("Thuis is s a sub text");
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setStyle(inboxStyle);


        NotificationManager myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotificationManager.notify(id++, notificationBuilder.build());
    }

    void showBigNotification(View v) {

        NotificationCompat.BigTextStyle bigTextStyle = new android.support.v4.app.NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("Big Title");
        bigTextStyle.bigText("hello this sis a  big text message that gets displayed. hello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayedhello this sis a  big text message that gets displayed");
        bigTextStyle.setSummaryText("15 Messages received...");

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle(id + "Main Title for the Notification");
        notificationBuilder.setSubText("Thuis is s a sub text");
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setStyle(bigTextStyle);


        NotificationManager myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotificationManager.notify(id++, notificationBuilder.build());
    }
    void showBigPictureNotification(View v) {

        NotificationCompat.BigPictureStyle bigPictureStyle = new android.support.v4.app.NotificationCompat.BigPictureStyle();
        bigPictureStyle.setBigContentTitle("Big Title");
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.images));
        bigPictureStyle.setSummaryText("15 Messages received...");

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle(id + "Main Title for the Notification");
        notificationBuilder.setSubText("Thuis is s a sub text");
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setStyle(bigPictureStyle);
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));



        NotificationManager myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotificationManager.notify(id++, notificationBuilder.build());
    }

}
