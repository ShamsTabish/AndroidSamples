package com.example.acadgild.session5;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class ActionBarDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_demo);

        ActionBar actionBar=getActionBar();
        if(actionBar!=null){
            manipulateActionBar(actionBar);
            actionBar.hide();
        }else {
            android.support.v7.app.ActionBar action=getSupportActionBar();
            manipulateActionBar(action);
            Toast.makeText(this, "ActionBar is not available..", Toast.LENGTH_SHORT).show();
            action.hide();
        }

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        toolbar.setTitle("Main title");
        toolbar.setSubtitle("Subtitle");

    }

    void manipulateActionBar(ActionBar actionBar){
        actionBar.setTitle("Hello This is new title...");
        actionBar.setSubtitle("This is Subtitle");
        actionBar.setLogo(R.drawable.rose);
        actionBar.setIcon(R.drawable.ic_search_black_24dp);
    }

    void manipulateActionBar(android.support.v7.app.ActionBar actionBar){
        actionBar.setTitle("Hello This is new title...");
        actionBar.setSubtitle("This is Subtitle");
        actionBar.setLogo(R.drawable.rose);
        actionBar.setIcon(R.drawable.ic_search_black_24dp);
    }

}
