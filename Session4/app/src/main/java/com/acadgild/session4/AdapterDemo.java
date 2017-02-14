package com.acadgild.session4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class AdapterDemo extends AppCompatActivity {

    String []adapterList={"Array Adapter","Base Adapter","Grid View ","List View"};
    int i=0;
    ArrayAdapter<String> displayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_demo);

        ListView listOfAdapters=(ListView)findViewById(R.id.listOfAdapters);

        Button button=(Button)findViewById(R.id.btn);

        displayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,adapterList);

        listOfAdapters.setAdapter(displayAdapter);


    }
    public  void changeText(View v){
        if(i<adapterList.length)
            adapterList[i++]="--------------------";
            displayAdapter.notifyDataSetChanged();
    }
    public void showBaseAdapter(View v){
        Intent gotoBaseAdapter=new Intent(this,BaseAdapterDemo.class);
        startActivity(gotoBaseAdapter);
    }
    public void showPicers(View v){
        Intent picker=new Intent(this,DateAndTimePickers.class);
        startActivity(picker);
    }
}

