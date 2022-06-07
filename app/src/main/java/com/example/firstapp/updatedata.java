package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class updatedata extends AppCompatActivity {

    EditText u_email, u_pass;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);
        u_email = findViewById(R.id.update_email);
        u_pass = findViewById(R.id.update_pass);
        btn_save = findViewById(R.id.btn_save);

        Intent getdata = getIntent();
        String stdid = getdata.getStringExtra("stdid");
        u_email.setText(getdata.getStringExtra("email"));
        u_pass.setText(getdata.getStringExtra("pass"));

        btn_save.setOnClickListener(view->{
            DatabaseReference databaseReference = FirebaseDatabase
                    .getInstance("https://firstapp-4043d-default-rtdb.asia-southeast1.firebasedatabase.app").
                            getReference("Student");
            Std s1 = new Std(stdid,u_email.getText().toString(),u_pass.getText().toString(),"");
            databaseReference.child(stdid).setValue(s1);
            Intent x = new Intent(updatedata.this,selectdata.class);
            startActivity(x);

        });
    }
}