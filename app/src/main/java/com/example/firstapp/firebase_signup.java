package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class firebase_signup extends AppCompatActivity {

    EditText email,pass;
    Button btn_register;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_signup);

        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.textbox_email);
        pass = findViewById(R.id.textbox_pass);

        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(view -> {


            auth.createUserWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnSuccessListener(firebase_signup.this, new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(firebase_signup.this,"data has been inserted",Toast.LENGTH_LONG).show();
               email.setText("");
               pass.setText("");
                }
            });


            auth.createUserWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnFailureListener(firebase_signup.this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(firebase_signup.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                }
            });

        });

    }
}