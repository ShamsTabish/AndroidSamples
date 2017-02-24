package com.example.acadgild.session6;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.acadgild.session6.BookViewer;

public class FragmentDemo extends AppCompatActivity {

    FragmentOne fragmentOne = new FragmentOne();
    FragmentTwo fragmentTwo = new FragmentTwo();

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        textView =(TextView)findViewById(R.id.hello);

        registerForContextMenu(textView);



        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.container, fragmentOne);
        fragmentTransaction.add(R.id.container2, fragmentTwo);

        fragmentTransaction.commit();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,0,1,"Test Menu 1");
        menu.add(0,1,2,"Test Menu 2");
        menu.add(0,2,3,"Test Menu 3");
        menu.add(0,3,4,"Test Menu 4");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {



        Toast.makeText(this, "Item Selected is "+item.getTitle(), Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }

    public void deleteFragment(View textView) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.remove(fragmentOne);

        fragmentTransaction.commit();

//        Intent intent=new Intent(FragmentDemo.this, BookViewer.class);
//        startActivity(intent);
    }
}
