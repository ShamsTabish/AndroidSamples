package com.acadgild.session9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReaderWriter extends AppCompatActivity {

    final  String FILE_NAME="hello.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_reader_writer);
    }

    public void showFileOperations(View tv) {
//        String outputFile=getFilesDir().getAbsolutePath()+File.separator+"hello.txt";

        try {

           File file= File.createTempFile("Hello-tmpFile","-tmp",getCacheDir());

//            FileOutputStream myFile=new FileOutputStream(file);

            FileOutputStream myFile = new FileOutputStream(getFilesDir().getAbsolutePath()+"/"+FILE_NAME);//openFileOutput(FILE_NAME,MODE_PRIVATE);

            Toast.makeText(this, getFilesDir().getAbsolutePath()+" ", Toast.LENGTH_SHORT).show();
            myFile.write("Hello these are the new contents in the file ..\n\n\nOWwww \n\n\n Did u understand..??..".getBytes());
            myFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void showContents(View v){
        TextView textView=(TextView)findViewById(R.id.textFile);

        try {
            FileInputStream fileReader=openFileInput(FILE_NAME);
            byte []data=new byte[fileReader.available()];
            fileReader.read(data);
            fileReader.close();

            textView.setText(new String (data));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
