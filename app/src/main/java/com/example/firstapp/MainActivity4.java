package com.example.firstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;
import java.util.Set;

public class MainActivity4 extends AppCompatActivity {


    EditText txtuser, txtpass;
    Button btn_login;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txtuser = findViewById(R.id.txtuser);
        txtpass = findViewById(R.id.txtpass);

        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(view->{

            //creating sharedpreferences
        sharedPreferences = getSharedPreferences("SP",MODE_PRIVATE);
        //allowing editing
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username",txtuser.getText().toString());
        editor.putString("password",txtpass.getText().toString());

        editor.commit();

            Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
            startActivity(intent);

        });

//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


    }
}