package com.example.medical_clinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void login(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    // sign up 的 botton :btnlogin 还没写
}