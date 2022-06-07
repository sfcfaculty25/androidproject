package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    ImageView img;
    TextView title, description;
    Button btn_back;


    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img = findViewById(R.id.img_full);
        title = findViewById(R.id.title);
        description = findViewById(R.id.descript);
        btn_back = findViewById(R.id.btn_back);

        Intent i = getIntent();

        title.setText(i.getStringExtra("title"));
        description.setText(i.getStringExtra("desp"));
    img.setImageResource(i.getIntExtra("img",0));

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}