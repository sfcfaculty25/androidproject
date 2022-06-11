package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class selectdata extends AppCompatActivity
{

     //holder for data from database
    ArrayList<Std> data;
    EditText txtsearch;
    Button btnsearch;

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectdata);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        lv = findViewById(R.id.listviewdata);
        btnsearch = findViewById(R.id.btn_search);
        txtsearch = findViewById(R.id.txtsearch);

        btnsearch.setOnClickListener(view->{
            search();
        });

        fetch();
    }
    public void fetch()
    {
        //connection String
        DatabaseReference firebaseDatabase  = FirebaseDatabase.getInstance("https://firstapp-4043d-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Student");


        data = new ArrayList<>();
        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                //load data from database in class
                for(DataSnapshot firedata : snapshot.getChildren())
                {
                    Std s1 = firedata.getValue(Std.class);
                    data.add(s1);
                }

               FetchDatabase f1 = new FetchDatabase(selectdata.this,data);
               lv.setAdapter(f1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {


            }
        });
    }

    public void search()
    {
        //connection String
        DatabaseReference firebaseDatabase  = FirebaseDatabase.getInstance("https://firstapp-4043d-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Student");


        data = new ArrayList<>();
        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                //load data from database in class
                for(DataSnapshot firedata : snapshot.getChildren())
                {
                    Std s1 = firedata.getValue(Std.class);
                    if(s1.stdname.equals(txtsearch.getText().toString()))
                    {
                        data.add(s1);
                    }
                }
               FetchDatabase f1 = new FetchDatabase(selectdata.this,data);
               lv.setAdapter(f1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}