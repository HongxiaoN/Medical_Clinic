package com.example.medical_clinic;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeChooser extends AppCompatActivity {
    //initialize variable
    TextView tvTimer1;
    int t1Hour, t1Minute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timechooser);

        //assign variable
        tvTimer1 = findViewById(R.id.tv_timer1);
        tvTimer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize time picker dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        TimeChooser.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                //initialize hour and minute
                                t1Hour = hourOfDay;
                                t1Minute = minute;
                                //store in string
                                String time = t1Hour + ":" + t1Minute;
                                //initialize 24 h time format
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    //initialize 12 h time format
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm:aa"
                                    );
                                    //set selected time in textview
                                    tvTimer1.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 12, 0, false
                );
                //set transparent background
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //Display previous selected time
                timePickerDialog.updateTime(t1Hour, t1Minute);
                //show dialog
                timePickerDialog.show();
            }
        });

        //doctor info
        TextView textView1 = findViewById(R.id.textView5);
        //这里输入doctor信息


    }

}
