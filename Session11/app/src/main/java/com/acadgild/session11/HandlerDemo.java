package com.acadgild.session11;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HandlerDemo extends AppCompatActivity {
    TextView handerText;
    Handler myUiHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handelr_demo);
        handerText = (TextView) findViewById(R.id.handerText);


        new Thread(myThreadCode).start();

        myTread.start();
    }

    Thread myTread = new Thread() {
        @Override
        public void run() {
            super.run();

            myUiHandler.post(new Runnable() {
                @Override
                public void run() {
                    handerText.setText("New Code.. For THread...");

                }
            });
        }
    };


    Runnable myThreadCode = new Runnable() {
        @Override
        public void run() {

            handerText.setText("New Text thats set from the Thread...");

            myUiHandler.post(new Runnable() {
                @Override
                public void run() {

                    handerText.setText("New Text thats set from the Thread...");
                }
            });
        }
    };


}
