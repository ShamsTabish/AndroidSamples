package com.acadgild.session13;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MyContentResolver extends AppCompatActivity implements InFragmentAccess {

    private String name="ACAD_GILD" ;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


    TextView contactView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_resolver);

        contactView = (TextView) findViewById(R.id.contactDisplay);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.fragmentContainer,new MyFragment());
        transaction.add(R.id.fragmentContainer,new MyFragment());
        transaction.commit();




        Intent serviceIntent=new Intent(this,MyCustomService.class);
        startService(serviceIntent);


        StringBuffer contactBuffer = new StringBuffer();

        ContentResolver contactsClient = getContentResolver();
        Cursor contactsCursor = contactsClient.query(Uri.parse("content://sms/inbox"), null, null, null, null);

        while (contactsCursor.moveToNext()) {
            int noOfColumns = contactsCursor.getColumnCount();
            for (int i = 0; i < noOfColumns; i++) {
                contactBuffer.append("\n" + contactsCursor.getColumnName(i));


                if (contactsCursor.getType(i) == Cursor.FIELD_TYPE_STRING)
                    contactBuffer.append(" :   " + contactsCursor.getString(i));
                else if (contactsCursor.getType(i) == Cursor.FIELD_TYPE_INTEGER)
                    contactBuffer.append(" :   " + contactsCursor.getInt(i));
                else if (contactsCursor.getType(i) == Cursor.FIELD_TYPE_BLOB)
                    contactBuffer.append(" :   " + contactsCursor.getBlob(i));
                else if (contactsCursor.getType(i) == Cursor.FIELD_TYPE_FLOAT)
                    contactBuffer.append(" :   " + contactsCursor.getFloat(i));


            }
            contactBuffer.append("\n\n--------------------------\n\n");
        }

        contactView.setText(contactBuffer.toString());


    }


}
