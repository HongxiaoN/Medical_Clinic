package com.example.medical_clinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Write a message to the database
                FirebaseDatabase.getInstance().getReference("Test2").setValue("bbb")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Good", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Bad", Toast.LENGTH_LONG).show();
                        }
                    }
                });
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