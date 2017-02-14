package com.acadgild.session4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapterDemo extends AppCompatActivity {
    List<OnlineCourse> onlineCourseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_demo);

        GridView courseList=(GridView) findViewById(R.id.courseList);

        initCourses();

        CourseAdapter courseAdapter=new CourseAdapter(this,onlineCourseList);
        courseList.setAdapter(courseAdapter);


    }

    void initCourses(){
        onlineCourseList=new ArrayList<OnlineCourse>();
        onlineCourseList.add(new OnlineCourse("Java",9,null));
        onlineCourseList.add(new OnlineCourse("Android",24,null));
        onlineCourseList.add(new OnlineCourse("Spark",30,null));
        onlineCourseList.add(new OnlineCourse("Hadoop",28,null));
        onlineCourseList.add(new OnlineCourse("RaspBerry",19,null));
        onlineCourseList.add(new OnlineCourse("DBMS",20,null));
        onlineCourseList.add(new OnlineCourse("Hardware",18,null));

    }
}

