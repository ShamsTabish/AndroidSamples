package com.acadgild.session9;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class FilesDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files_demo);
    }

    //UI related Method
    public void displayFileDetails(View view) {

        TextView textView = (TextView) view;

        File myFile = getFilesDir();

//        String details = getFileDetails(myFile);
//
//        details = details + getFileDetails(myFile.getParentFile());

      String  details="\n\n///////////////Cache/////////////////\n";




        details+=getFileDetails(new File(myFile.getParentFile().getAbsolutePath()+File.separator+"cache"));

        details+="\n\n///////////////Root/////////////////\n";
        for (File file : File.listRoots()) {
            details += getFileDetails(file);
        }

        textView.setText(details);
    }


    private String getFileDetails(File file) {

        String fileOrDir=(file.isDirectory() ? "Directory" : "File");

        String fileProperties = "\n\n" + file.getAbsolutePath() + " \t " +fileOrDir ;

        StringBuffer fileDataBuffer = new StringBuffer();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            fileDataBuffer.append("\n\n-----" + file.getName() + "----------");
            for (File f : files) {
                fileDataBuffer.append("\n\t\t" + f.getAbsolutePath()+"\t\t--->>"+(f.isDirectory()?"Directory" : "File"));
            }
        }

        return fileProperties + fileDataBuffer.toString();
    }



    public void  gotoFileReader(View button){
        Intent fileIntent=new Intent(this,FileReaderWriter.class);
        startActivity(fileIntent);
    }
    public void displayExternalStorage(View v){
        Intent intent=new Intent(this,ExternalStorage.class);
        startActivity(intent);
    }
}
