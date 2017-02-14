package com.acadgild.session2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_two);
        TextView tc=(TextView)findViewById(R.id.t2);
//        String b=getIntent().getExtras().getString("Name");
//        tc.setText(b);
        Intent i=new Intent();
        setResult(RESULT_OK,i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
