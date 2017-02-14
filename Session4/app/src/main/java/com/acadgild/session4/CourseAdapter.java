package com.acadgild.session4;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CourseAdapter extends BaseAdapter{
    Context context;
    List<OnlineCourse> courseList;

    public CourseAdapter(Context context,List<OnlineCourse> courses){
        this.context=context;
        courseList=courses;
    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public OnlineCourse getItem(int i) {
        return courseList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view= LayoutInflater.from(context).inflate(R.layout.single_list_item,viewGroup,false);

            ImageView icon=(ImageView)view.findViewById(R.id.courseImage);
            TextView courseName=(TextView)view.findViewById(R.id.courseName);
            TextView courseDuration=(TextView)view.findViewById(R.id.courseDuration);

            OnlineCourse course=courseList.get(i);

            icon.setImageResource(R.mipmap.ic_launcher);
            courseName.setText(course.name);
            courseName.setBackgroundColor(Color.CYAN);
            courseDuration.setText(Integer.toString(course.duration));
        }
        return view;
    }
}
