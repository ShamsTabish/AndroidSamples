package com.acadgild.session13_client;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyCustomSMSClient extends AppCompatActivity {
    TextView smsView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_custom_smsclient);

        smsView=(TextView)findViewById(R.id.smsView);

    }

    public void loadSMS(View v){
        ContentResolver myResolver=getContentResolver();
        Cursor cursor=myResolver.query(Uri.parse("content://com.acadgild.message"),null,null,null,null);

        StringBuffer mySms=new StringBuffer();
        while (cursor.moveToNext()){
            for (int i=0;i<cursor.getColumnCount();i++){
                mySms.append("\n"+cursor.getColumnName(i));

                if (cursor.getType(i) == Cursor.FIELD_TYPE_STRING)
                    mySms.append(" :   " + cursor.getString(i));
                else if (cursor.getType(i) == Cursor.FIELD_TYPE_INTEGER)
                    mySms.append(" :   " + cursor.getInt(i));
                else if (cursor.getType(i) == Cursor.FIELD_TYPE_BLOB)
                    mySms.append(" :   " + cursor.getBlob(i));
                else if (cursor.getType(i) == Cursor.FIELD_TYPE_FLOAT)
                    mySms.append(" :   " + cursor.getFloat(i));

            }
            mySms.append("\n\n**************************\n\n\n");
        }
        cursor.close();

    }
}
