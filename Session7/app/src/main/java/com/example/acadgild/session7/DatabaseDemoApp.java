package com.example.acadgild.session7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acadgild.model.Student;

import java.util.List;

public class DatabaseDemoApp extends AppCompatActivity {

    TextView resultArea;
    EditText studentName, studentId;

    final String DATABASE_NAME = "StudentDB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_demo_app);
        resultArea = (TextView) findViewById(R.id.resultsArea);
        studentName = (EditText) findViewById(R.id.name);
        studentId = (EditText) findViewById(R.id.studentID);

        studentName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Toast.makeText(DatabaseDemoApp.this, studentName.getText(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        displayResult(resultArea);
    }

    public void displayResult(View v) {
        Student studentDB = new Student(this, DATABASE_NAME);
        List<String> students = studentDB.getAllStudents();

        resultArea.setText(students.toString());
    }

    public void insertStudent(View v) {
        String name, id;
        name = studentName.getText().toString();
        id = studentId.getText().toString();

        Student studentDB = new Student(this, DATABASE_NAME);
        studentDB.insert(name, Integer.parseInt(id));

        displayResult(v);
    }

    public void updateStudent(View v) {
        String name;
        String id;
        name = studentName.getText().toString();
        id = studentId.getText().toString();


        Student studentDB = new Student(this, DATABASE_NAME);
        studentDB.updateStudent(name, id);
        displayResult(v);

    }

    public void deleteStudent(View v) {
        String name;
        String id;
        name = studentName.getText().toString();
        id = studentId.getText().toString();


        Student studentDB = new Student(this, DATABASE_NAME);
        studentDB.delete(name, id);
        displayResult(v);

    }

}
