package com.acadgild.extrasessionproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AdapterDemo extends AppCompatActivity {

    List<String > robots=new ArrayList<>();
    ListView robotList;
    static int index=0;
    ArrayAdapter<String> robotListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_demo);
        robotList=(ListView)findViewById(R.id.robotList);

        robots.add("Chitti");
        robots.add("Android");
        robots.add("Droid");
        robots.add("G-One");
        robots.add("Ra-One");

        robotListAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,robots);

        robotList.setAdapter(robotListAdapter);
    }
    public void addItem(View v){
        robots.add("New Robot"+(index++));
        robotListAdapter.notifyDataSetChanged();
    }

    public void removeItem(View v){
        robots.remove(robots.size()-1);
        robotListAdapter.notifyDataSetChanged();
    }
}
