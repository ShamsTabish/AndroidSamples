package com.example.acadgild.session5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ContextMenuDemo extends AppCompatActivity {

    ImageView img1Box;
    ImageView img2;
    ImageView rose;
    ImageView sunflwer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_demo);
        img1Box = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        rose = (ImageView) findViewById(R.id.rose);
        sunflwer = (ImageView) findViewById(R.id.sun);

        //Step1
        registerForContextMenu(img1Box);
        registerForContextMenu(rose);
    }

    //Step 2
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Step 3 inflate the Menu
        if (v.getId() == R.id.rose)
            getMenuInflater().inflate(R.menu.rose_menu, menu);
        else
            getMenuInflater().inflate(R.menu.options_menu, menu);
    }

    //Step 4


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.share:
                Intent send = new Intent();
                send.setAction(Intent.ACTION_SEND);
                startActivity(send);
                break;
            case R.id.gotoSite:
                Intent gotoS = new Intent();
                gotoS.setAction(Intent.ACTION_VIEW);
                gotoS.setData(Uri.parse("http://google.com"));
                startActivity(gotoS);
                break;
            default:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }


        return super.onContextItemSelected(item);
    }
}
