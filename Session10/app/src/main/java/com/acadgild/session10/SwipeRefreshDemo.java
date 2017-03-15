package com.acadgild.session10;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SwipeRefreshDemo extends AppCompatActivity {

    SwipeRefreshLayout refreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_demo);
        refreshLayout=(SwipeRefreshLayout)findViewById(R.id.refreshlayout);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

                refreshLayout.setRefreshing(true);
                try {  Thread.sleep(3000);               } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Toast.makeText(SwipeRefreshDemo.this, "Refreshing the Contents", Toast.LENGTH_SHORT).show();
                refreshLayout.setRefreshing(false);
            }
        });

    }



}
