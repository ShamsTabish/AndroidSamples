package com.acadgild.session11;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class OnUiTreadExecution extends AppCompatActivity {
    TextView someTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_ui_tread_execution);
        someTextView = (TextView) findViewById(R.id.textData);
        MyThread asynchTask=new MyThread();
        asynchTask.execute("My Executor"," second", "Third");

    }

    void waitForASecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class MyThread extends AsyncTask<String, Integer, Integer> {
        @Override
        protected Integer doInBackground(final String... params) {

            for (int i = 0; i < 10; i++) {

                waitForASecond();
                final int intermediateResult=i;
                someTextView.post(
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                someTextView.setText("Intermediate result.."+intermediateResult +" from "+params[0] +"\n"+params[1]+"\n"+params[2]);
                            }
                        }
                );


            }
            return null;
        }

    }


}
