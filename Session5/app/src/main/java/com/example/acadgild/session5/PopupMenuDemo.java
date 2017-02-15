package com.example.acadgild.session5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PopupMenuDemo extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu_demo);
        imageView = (ImageView) findViewById(R.id.myImage);
    }

    public void showPopup(View image) {
        PopupMenu menu = new PopupMenu(PopupMenuDemo.this, imageView);
        menu.inflate(R.menu.rose_menu);

        menu.setOnMenuItemClickListener(new MenuItemHandler(this));
        menu.show();

    }
}

class MenuItemHandler implements PopupMenu.OnMenuItemClickListener {
    Context c;

    MenuItemHandler(Context context) {
        c = context;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Intent send = new Intent();
                send.setAction(Intent.ACTION_SEND);
                c.startActivity(send);
                break;
            case R.id.gotoSite:
                Intent gotoS = new Intent();
                gotoS.setAction(Intent.ACTION_VIEW);
                gotoS.setData(Uri.parse("http://google.com"));
                c.startActivity(gotoS);
                break;
            default:
                Toast.makeText(c, item.getTitle(), Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}