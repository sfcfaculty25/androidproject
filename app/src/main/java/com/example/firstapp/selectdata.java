package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectdata);
        lv = findViewById(R.id.listviewdata);
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


}