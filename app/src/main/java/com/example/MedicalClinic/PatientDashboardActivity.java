package com.example.MedicalClinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PatientDashboardActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btnBook, btnUpcomingAppointments, btnPreviousAppointments, btnLogout;

    private Patient loggedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        ((Button) findViewById(R.id.btnBook)).setOnClickListener(this);

        ((Button) findViewById(R.id.btnUpcomingAppointments)).setOnClickListener(this);

        ((Button) findViewById(R.id.btnPreviousAppointments)).setOnClickListener(this);

        ((Button) findViewById(R.id.logOut)).setOnClickListener(this);

        String userID = getIntent().getStringExtra(getString(R.string.user_key));

        FirebaseDatabase.getInstance().getReference("Patients")
                .child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                loggedInUser = snapshot.getValue(Patient.class);
                loggedInUser.setID(snapshot.getKey());

                if (loggedInUser == null)
                    Toast.makeText(PatientDashboardActivity.this, "Failed retrieve User Info!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    @Override
    public void onClick(View view) {
    }
}