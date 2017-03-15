package com.acadgild.session8;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class MyPreferences extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.my_preferences);

        SharedPreferences myPref= PreferenceManager.getDefaultSharedPreferences(this);
        myPref.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
                Log.e("WORKING ","--------------PREF-------------");
                Intent i=new Intent(getBaseContext(),NavigateToActivity.class);
                i.putExtra("city",s);
                startActivity(i);
                Toast.makeText(getBaseContext(), "Something was changed..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
