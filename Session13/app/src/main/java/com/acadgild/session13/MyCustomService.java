package com.acadgild.session13;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyCustomService  extends Service{

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("Service Create","Service Started......");
    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
            Log.i("Start :"," The new value of I is "+(-9000000));
//        for(int i=0;i<999999;i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Start :"," The new value of I is "+(-9000000));

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("Service Binder","Bounded");
        for(int i=0;i<999999;i++){
            Log.i("StartCommand:"," The new value of I is "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
