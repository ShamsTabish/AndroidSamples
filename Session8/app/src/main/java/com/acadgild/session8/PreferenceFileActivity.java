package com.acadgild.session8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class PreferenceFileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String PREFERNCE_KEY = "name";


        setContentView(R.layout.activity_preference_file);
        // Not a Settings/Screen based Preference
        getPreferences(MODE_PRIVATE)
                .edit()
                .putString("name", "Hello this is the updated info......")
                .commit();


        TextView textView = (TextView) findViewById(R.id.preferenceText);

        String value = getPreferences(MODE_PRIVATE)
                .getString("name", "-----------No DATA---------");


        textView.setText(textView.getText()+"\n\n"+getString(R.string.forJavaCodeBasedDisplay)+"\n\nThe Stored data is \n\n" + value);
        //---------------

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setting = new Intent(PreferenceFileActivity.this, MyPreferences.class);
                startActivity(setting);
            }
        });
    }

    void openYesNoDialog(View v){
        YesNoDialog myDialog=new YesNoDialog();
        myDialog.show(getSupportFragmentManager(),"MyDialog..");
    }
}
