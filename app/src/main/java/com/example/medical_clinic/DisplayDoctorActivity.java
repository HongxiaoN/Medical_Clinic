package com.example.medical_clinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class DisplayDoctorActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_doctor);

        Button button1 = findViewById(R.id.button4);
        button1.setText("Doctor1");
        button1.setOnClickListener(this);


        Button button2 = findViewById(R.id.button5);
        button2.setText("Doctor2");
        button2.setOnClickListener(this);

        Button button3 = findViewById(R.id.button6);
        button3.setText("Doctor3");
        button3.setOnClickListener(this);

        Button button4 = findViewById(R.id.button7);
        button4.setText("Doctor4");
        button4.setOnClickListener(this);

        Button button5 = findViewById(R.id.button8);
        button5.setText("Doctor5");
        button5.setOnClickListener(this);

        Button button6 = findViewById(R.id.button9);
        button6.setText("Doctor6");
        button6.setOnClickListener(this);

        Button button7  = findViewById(R.id.button10);
        button7.setText("Doctor7");
        button7.setOnClickListener(this);

        Button button8  = findViewById(R.id.button11);
        button8.setText("Doctor8");
        button8.setOnClickListener(this);

        Button button9 = findViewById(R.id.button12);
        button9.setText("Doctor9");
        button9.setOnClickListener(this);

        Button button10 = findViewById(R.id.button13);
        button10.setText("Doctor10");
        button10.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button4:
                startActivity(new Intent(this, TimeChooser.class));
                //这里要在firebase里的appointment里“total appointment”创建一个医生1的key，然后后面是对这个key输入时间
                break;
            case R.id.button5:
                startActivity(new Intent(this, TimeChooser.class));
                //这里要在firebase里的appointment里“total appointment”创建一个医生2的key，然后后面是对这个key输入时间
                break;
            case R.id.button6:
                startActivity(new Intent(this, TimeChooser.class));
                //这里要在firebase里的appointment里“total appointment”创建一个医生3的key，然后后面是对这个key输入时间
                break;
            case R.id.button7:
                startActivity(new Intent(this, TimeChooser.class));
                //这里要在firebase里的appointment里“total appointment”创建一个医生4的key，然后后面是对这个key输入时间
                break;
            case R.id.button8:
                startActivity(new Intent(this, TimeChooser.class));
                //这里要在firebase里的appointment里“total appointment”创建一个医生5的key，然后后面是对这个key输入时间
                break;
            case R.id.button9:
                startActivity(new Intent(this, TimeChooser.class));
                //这里要在firebase里的appointment里“total appointment”创建一个医生6的key，然后后面是对这个key输入时间
                break;
            case R.id.button10:
                startActivity(new Intent(this, TimeChooser.class));
                //这里要在firebase里的appointment里“total appointment”创建一个医生7的key，然后后面是对这个key输入时间
                break;
            case R.id.button11:
                startActivity(new Intent(this, TimeChooser.class));
                //这里要在firebase里的appointment里“total appointment”创建一个医生8的key，然后后面是对这个key输入时间
                break;
            case R.id.button12:
                startActivity(new Intent(this, TimeChooser.class));
                //这里要在firebase里的appointment里“total appointment”创建一个医生9的key，然后后面是对这个key输入时间
                break;
            case R.id.button13:
                startActivity(new Intent(this, TimeChooser.class));
                //这里要在firebase里的appointment里“total appointment”创建一个医生10的key，然后后面是对这个key输入时间
                break;
        }
    }


}