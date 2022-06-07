package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity
{

    TextView username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        SharedPreferences sharedPreferences = getSharedPreferences("SP",MODE_PRIVATE);
        username.setText(sharedPreferences.getString("username",""));
        password.setText(sharedPreferences.getString("password",""));

    }
}