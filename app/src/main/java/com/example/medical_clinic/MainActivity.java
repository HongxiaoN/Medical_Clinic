package com.example.medical_clinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Write a message to the database
//        FirebaseDatabase.getInstance().getReference("Test2").setValue("bbb");
    }

    public void displayDoctor(View view){
        Intent intent = new Intent(this, DisplayDoctorActivity.class);
        startActivity(intent);
    }

    public void displayAppointment(View view){
        Intent intent = new Intent(this, AppointmentActivity.class);
        startActivity(intent);
    }

}