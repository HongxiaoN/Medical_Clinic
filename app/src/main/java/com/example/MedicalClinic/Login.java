package com.example.MedicalClinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signup(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    // btnlogin 还没写？
}