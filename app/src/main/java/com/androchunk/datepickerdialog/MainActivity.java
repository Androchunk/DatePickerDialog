package com.androchunk.datepickerdialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerFragment.DatePickerListener {

    private TextView tvDisplayDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplayDate = findViewById(R.id.tvDisplaydate);

        Button btnShowDatePicker = findViewById(R.id.btnShowDatePicker);
        btnShowDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePickerFragment=new DatePickerFragment();
                datePickerFragment.setCancelable(false);
                datePickerFragment.show(getSupportFragmentManager(),"date Picker");
            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH,day);
        String date= DateFormat.getDateInstance().format(cal.getTime());
        tvDisplayDate.setText(date);

    }
}
