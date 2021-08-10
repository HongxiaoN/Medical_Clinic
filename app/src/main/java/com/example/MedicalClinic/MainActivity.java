package com.example.MedicalClinic;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private FirebaseAuth mAuth;
    private CheckBox checkBoxRemember;
    private TextView register;
    private Button btnLogIn;
    private EditText editTextEmail, editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        register = (TextView) findViewById(R.id.register);
        checkBoxRemember = (CheckBox) findViewById(R.id.checkboxRemember);
        preferences = getSharedPreferences("b07", Context.MODE_PRIVATE);
        editor = preferences.edit();
        checkSharedPreference();
        btnLogIn.setOnClickListener(this);
        register.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }

    private void checkSharedPreference() {
        String remember = preferences.getString(getString(R.string.ref_key_remember), "False");
        String email = preferences.getString(getString(R.string.ref_key_email), "");
        String password = preferences.getString(getString(R.string.ref_key_password), "");
        editTextEmail.setText(email);
        editTextPassword.setText(password);
        checkBoxRemember.setChecked(remember.equals("True"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogIn:
                logIn();
                break;
            case R.id.register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }

    private void logIn() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        editor.putString(getString(R.string.ref_key_remember), checkBoxRemember.isChecked() ? "True" : "False");
        editor.putString(getString(R.string.ref_key_email), checkBoxRemember.isChecked() ? email : "");
        editor.putString(getString(R.string.ref_key_password), checkBoxRemember.isChecked() ? password : "");
        editor.apply();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please provide valid email!");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Min password length should be 6 characters!");
            editTextPassword.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful())
                    Toast.makeText(MainActivity.this, "Failed to login!", Toast.LENGTH_LONG).show();

                else {
                    String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    FirebaseDatabase.getInstance().getReference("UserTypes")
                            .child(userID).child("userType").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String userType = snapshot.getValue(String.class);
                            if (userType == null) {
                                Toast.makeText(MainActivity.this, "Failed to login!", Toast.LENGTH_LONG).show();
                            }
                            else if (userType.equals("Doctor")) {
                                Intent intent = new Intent(MainActivity.this, DoctorDashboardActivity.class);
                                intent.putExtra(getString(R.string.user_key), userID);
                                startActivity(intent);
                            }
                            else if (userType.equals("Patient")) {
                                Intent intent = new Intent(MainActivity.this, PatientDashboardActivity.class);
                                intent.putExtra(getString(R.string.user_key), userID);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });

                }
            }
        });

    }

}
