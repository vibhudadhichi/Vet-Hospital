package com.example.vibhu.vethospital;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

boolean shouldStartAct3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);


    }
    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
        }
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void thanks(View view) {

        shouldStartAct3 = true;

        EditText txtname = (EditText)findViewById(R.id.name1);
        String name = "Full Name: " + txtname.getText().toString() + "\n";
        EditText txtname1 = (EditText)findViewById(R.id.name2);
        name = name + "Pet: " + txtname1.getText().toString() + "\n";
        EditText txtname2 = (EditText)findViewById(R.id.name21);
        name = name + "Sex: " + txtname2.getText().toString() + "\n";
        EditText txtname3 = (EditText)findViewById(R.id.name3);
        name = name + "Age: " + txtname3.getText().toString() + "\n";
        EditText txtname4 = (EditText)findViewById(R.id.name41);
        name = name + "Booking Date: " + txtname4.getText().toString() + "\n";
        EditText txtname5 = (EditText)findViewById(R.id.name4);
        name = name + "Booking Time: " + txtname5.getText().toString() + "\n";
        Intent gmail = new Intent(Intent.ACTION_VIEW);
        gmail.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
        gmail.putExtra(Intent.EXTRA_EMAIL, new String[] { "vet-hospital@gmail.com" });
        gmail.setData(Uri.parse("vet-hospital@gmail.com"));
        gmail.putExtra(Intent.EXTRA_SUBJECT, "Booking Confirmation");
        gmail.setType("plain/text");
        gmail.putExtra(Intent.EXTRA_TEXT, "Hi Doctor,\n\nPlease see the below mentioned details :\n" + name);
        startActivity(gmail);

    }


    @Override
    protected void onResume() {
        super.onResume();
        if(shouldStartAct3){

            Intent in = new Intent(this, MainActivity3.class);
            startActivity(in);
            shouldStartAct3= false;
        }
    }
}
