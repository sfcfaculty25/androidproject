package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class firebaseinsert extends AppCompatActivity {

    Button btn_insert;

    EditText fname,lname,contact,uname,pass;

    DatabaseReference firebaseDatabase  = FirebaseDatabase.getInstance("https://firstapp-4043d-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("emp");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebaseinsert);

        btn_insert = findViewById(R.id.btn_insert);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        contact = findViewById(R.id.contact);
        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.pass);


        btn_insert.setOnClickListener(view -> {

//            Random random = new Random();
//            int code  = random.nextInt(466767);
          //  long phone = Long.parseLong(contact.getText().toString());
//            Random random = new Random();
//            int code = random.nextInt(457575767);
           String id = System.currentTimeMillis()+"";
           Empdata empdata = new Empdata(id,fname.getText().toString(),lname.getText().toString(),contact.getText().toString(),uname.getText().toString(),pass.getText().toString());
            firebaseDatabase.child(id).setValue(empdata);
            Toast.makeText(firebaseinsert.this,"Data has been inserted",Toast.LENGTH_LONG).show();

        });

    }
}