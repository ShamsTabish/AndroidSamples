package com.acadgild.session4;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DateAndTimePickers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time_pickers);

    }

    void setTime(View v) {
        TimePicker myTimePicker=new TimePicker();
        myTimePicker.show(getSupportFragmentManager(),"My Time Picker");
    }

    void setDate(View v) {
        DatePicker myDatePicker=new DatePicker();
        myDatePicker.show(getSupportFragmentManager(),"My Date Picker..");

    }

    public static class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new TimePickerDialog(getContext(),this,0,0,false);
        }

        @Override
        public void onTimeSet(android.widget.TimePicker timePicker, int i, int i1) {
            Toast.makeText(getContext(), i+":"+i1, Toast.LENGTH_SHORT).show();
        }
    }

    public static class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int date=calendar.get(Calendar.DATE);
            int month=calendar.get(Calendar.MONTH);
            int year=calendar.get(Calendar.YEAR);

            return new DatePickerDialog(getContext(),this,year,month,date);
        }

        @Override
        public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int date) {
            Toast.makeText(getContext(), date+"/"+(month+1)+"/"+year, Toast.LENGTH_SHORT).show();
        }

    }
}
