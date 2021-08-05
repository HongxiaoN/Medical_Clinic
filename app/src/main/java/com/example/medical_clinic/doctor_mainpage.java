package com.example.medical_clinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class doctor_mainpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_mainpage);
    }

    public void displayListOfPatients(View view){
        Intent intent = new Intent(this, ListOfPatientActivity.class);
        startActivity(intent);
    }

    public void displayDoctorSchedule(View view){
        Intent intent = new Intent(this, doctor_schedulepage.class);
        startActivity(intent);
    }

}