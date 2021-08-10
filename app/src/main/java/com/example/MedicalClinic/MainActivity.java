package com.example.MedicalClinic;
// this is for patient
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Write a message to the database
        // Successfully link in firebase
//        FirebaseDatabase.getInstance().getReference("Test2").setValue("bbb")
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(MainActivity.this, "Good", Toast.LENGTH_LONG).show();
//                        } else {
//                            Toast.makeText(MainActivity.this, "Bad", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
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