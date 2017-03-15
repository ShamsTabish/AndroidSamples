package com.acadgild.session9;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorage extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int permissionStatus=ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permissionStatus== PackageManager.PERMISSION_DENIED){
            Toast.makeText(this, "Sorry Cant proceed ..", Toast.LENGTH_SHORT).show();

        }


        setContentView(R.layout.activity_external_storage);
        textView=(TextView)findViewById(R.id.txtExternal);
    }
    public void showExternalStorageStatus(View tv){


        StringBuffer dataBuffer=new StringBuffer();
        dataBuffer.append("\nCurrent State:"+Environment.getExternalStorageState());
        dataBuffer.append("\nMOUNTED:"+Environment.MEDIA_MOUNTED);
        dataBuffer.append("\nMOUNTED_READ_ONLY:"+Environment.MEDIA_MOUNTED_READ_ONLY);

        if(Environment.getExternalStorageState() .equals( Environment.MEDIA_MOUNTED))
            Toast.makeText(this, "The SD card is installed\n You can store files there", Toast.LENGTH_LONG).show();


        File filess=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"newDir/session1/2/3");

        filess.mkdirs();

        dataBuffer.append("\n\nExternal Storage Details: \n");
        dataBuffer.append(filess.getFreeSpace()/(1024*1024)+" mb / "+filess.getTotalSpace()/(1024*1024)+"mb\n\n");

        Toast.makeText(this, "Path: "+filess.getAbsolutePath(), Toast.LENGTH_SHORT).show();

        //Writing to External Storage..
        dataBuffer.append("\n\n---------------------\n");
        for (String s : Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).list()) {
            dataBuffer.append("\n"+s);
        }


        File f=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

        try {
            FileOutputStream writer=new FileOutputStream(new File(f,"MyNewFile.txt"));

            writer.write("Hi, Today is Monday...\n\n\n New Session\n\n\nhello this is new file".getBytes());
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileInputStream reader=new FileInputStream(new File(f,"myfile.txt"));
            byte []dataFromFile=new byte[reader.available()];
            reader.read(dataFromFile);
            reader.close();

            dataBuffer.append("\n\n\nFileContents are :\n"+new String(dataFromFile));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        textView.setText(dataBuffer.toString());

    }
}
