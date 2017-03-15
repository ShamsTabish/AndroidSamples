package com.acadgild.session8;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NavigateToActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate_to);
        String city=getIntent().getStringExtra("city");
        Toast.makeText(this, "Name: "+city+" : "+ PreferenceManager.getDefaultSharedPreferences(this).getString(city,"___"), Toast.LENGTH_SHORT).show();
    }
}
