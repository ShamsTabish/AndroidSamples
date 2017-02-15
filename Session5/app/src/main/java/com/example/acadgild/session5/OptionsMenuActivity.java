package com.example.acadgild.session5;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class OptionsMenuActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
        text=(TextView)findViewById(R.id.textBox);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Option 1
        //Add the menu items..
//        menu.add(0, 0, 1, "One");
//        menu.add(0, 1, 2, "Two");
//        menu.add(0, 2, 3, "Three");

        //Option 2
        // Create a menu xml file in res/menu folder
        //Inflate the menu
        getMenuInflater().inflate(R.menu.options_menu, menu);


        // Common Step
        // override onOptionsItemSelected for event handling
        // alternatively you can provide onClick attibute for the xml option
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.app_bar_search:
                Toast.makeText(this, "Searching in the app", Toast.LENGTH_SHORT).show();
                break;
            case R.id.red:
                text.setBackgroundColor(Color.RED);
                break;
            case R.id.blue:
                text.setBackgroundColor(Color.BLUE);
                break;
            case R.id.green:
                text.setBackgroundColor(Color.GREEN);
                break;
            default:
                Toast.makeText(this, "T:" + item.getTitle() + " ID:" + item.getItemId(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
