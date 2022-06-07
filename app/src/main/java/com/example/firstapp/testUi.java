package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class testUi extends AppCompatActivity {


    Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ui);

        dropdown = findViewById(R.id.fidget);


        List<String> items = new ArrayList<>();
        items.add("Select cars");
        items.add("Tesla");
        items.add("Audi");
        items.add("BMW");
        items.add("Ferrari");
        items.add("Kawasaki ninja");

ArrayAdapter<String> adapter = new ArrayAdapter<>(testUi.this,R.layout.support_simple_spinner_dropdown_item,items);

        dropdown.setAdapter(adapter);


    }
}