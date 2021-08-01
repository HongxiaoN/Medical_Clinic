package com.example.medical_clinic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;

public class DisplayDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_doctor);

        CheckBox checkbox1 = findViewById(R.id.checkBox6);
        checkbox1.setText("Jane Doe");

        CheckBox checkbox2 = findViewById(R.id.checkBox4);
        checkbox2.setText("Jane Doe1");

        CheckBox checkbox3 = findViewById(R.id.checkBox7);
        checkbox2.setText("Jane Doe2");

        CheckBox checkbox4 = findViewById(R.id.checkBox8);
        checkbox2.setText("wait for database");



    }
}