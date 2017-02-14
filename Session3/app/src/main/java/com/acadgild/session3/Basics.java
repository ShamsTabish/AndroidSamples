package com.acadgild.session3;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Basics extends AppCompatActivity {
     final int CONTACT_REQUEST=99;

    TextView sampleText;

    EditText firstName;
    EditText lastName;

    Button navigatorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics);
        sampleText = (TextView) findViewById(R.id.textView);

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);

        navigatorButton = (Button) findViewById(R.id.navigatorButton);

        navigatorButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        navigate();
                    }
                }
        );
    }

    void navigate() {
        Intent gotoNextScreen = new Intent(getApplicationContext(), SecondScreen.class);
        Bundle data=new Bundle();
        data.putString("city",firstName.getText().toString());
        gotoNextScreen.putExtras(data);


        gotoNextScreen.putExtra("name","Acadgild.. :)");

        startActivity(gotoNextScreen);
    }

    public void changeText(View v) {
        sampleText.setText(firstName.getText() + "-" + lastName.getText());
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
    }

    public void sendInfo(View view) {
//        Intent sendInfo=new Intent();
//        sendInfo.setAction(Intent.ACTION_SEND);
//
//        PackageManager packageManager=getPackageManager();
//        List activities=packageManager.queryIntentActivities(sendInfo,PackageManager.MATCH_ALL);
//
//
//        Toast.makeText(this, "No Of Matching apps are "+activities.size(), Toast.LENGTH_SHORT).show();
//
//        if(activities.size()>0)
//            startActivity(sendInfo);
//        else
//            Toast.makeText(this, "No App available to invoke ur intent..", Toast.LENGTH_SHORT).show();


//        Intent browse = new Intent(Intent.ACTION_VIEW);
//        browse.setData(Uri.parse("http://google.com"));
//
//        PackageManager packageManager=getPackageManager();
//        List activities=packageManager.queryIntentActivities(browse,PackageManager.MATCH_ALL);
//
//
//        Toast.makeText(this, "No Of Matching apps are "+activities.size(), Toast.LENGTH_SHORT).show();
//
//        startActivity(browse);

//        Intent dialer=new Intent();
//        dialer.setAction(Intent.ACTION_DIAL);
//        dialer.setData(Uri.parse("tel:8989757657"));
//
//        startActivity(dialer);


        Intent contactLoader=new Intent();
        contactLoader.setAction(Intent.ACTION_PICK);
        contactLoader.setData(Uri.parse("contents://contacts"));
        contactLoader.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);

        startActivityForResult(contactLoader,CONTACT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CONTACT_REQUEST){
            if(resultCode==RESULT_OK){
                Toast.makeText(this, "Contact Select ", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "Contact selection was aborted..", Toast.LENGTH_SHORT).show();

        }

    }
}
