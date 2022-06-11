package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class updatedata extends AppCompatActivity {

    EditText u_email, u_pass;
    Button btn_save;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);
        u_email = findViewById(R.id.update_email);
        u_pass = findViewById(R.id.update_pass);
        btn_save = findViewById(R.id.btn_save);
        img = findViewById(R.id.img_update);

        Intent getdata = getIntent();
        Glide.with(updatedata.this).load("https://firebasestorage.googleapis.com/v0/b/firstapp-4043d.appspot.com/o/images"+"%2F"+getdata.getStringExtra("imgname")+"?alt=media&token=f011aef1-c00b-44a5-97d6-75f50916e254").into(img);

        String stdid = getdata.getStringExtra("stdid");
        u_email.setText(getdata.getStringExtra("email")+getdata.getStringExtra("imgname"));
        u_pass.setText(getdata.getStringExtra("pass"));
       // img.setImageResource(getdata.getIntExtra("imgname",0));

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}