package com.acadgild.session11;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ThreadDemo extends AppCompatActivity {
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);
        resultView = (TextView) findViewById(R.id.myResult);
        MyAsynchTash mythread=new MyAsynchTash();
        mythread.execute("My AsynchTask Class Demo...  ");
    }

    void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    int calculate(){
        int result = 0;
        for (int i = 1; i < 9000; i++) {

            delay(1);
            result += i;
        }
        return result;
    }

    class MyAsynchTash extends AsyncTask<String,Integer,Integer>{
        String param;
        @Override
        protected Integer doInBackground(String... params) {
            param=params[0];
            Log.i("ThreadLog","  Parameter is  == > "+params[0]);
            return calculate();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(ThreadDemo.this, "Starting the operations .........", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            resultView.setBackgroundColor(Color.CYAN);
            resultView.setText("The Result of operation is "+result+"\n\n"+param);
        }
    }

}
