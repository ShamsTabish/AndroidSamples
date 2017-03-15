package com.acadgild.session10;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FloatingActionButtonDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button_demo);
    }
    public void display(View v){

        Toast.makeText(this, "Hellooooooooo", Toast.LENGTH_SHORT).show();

        Snackbar mySnackbar=Snackbar.make(v,"Nice to see u here..",Snackbar.LENGTH_LONG);

        mySnackbar.setAction("Call me righ now!", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial=new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse("tel:78676568798"));
                startActivity(dial);
            }
        });

        mySnackbar.show();
    }
}
