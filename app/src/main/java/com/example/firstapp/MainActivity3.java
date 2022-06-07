package com.example.firstapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button btn_pdialog,btn_alert, btn_notify;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn_pdialog = findViewById(R.id.btn_pdialog);
        btn_alert = findViewById(R.id.btn_alert);

        btn_notify = findViewById(R.id.btn_notify);

        btn_notify.setOnClickListener(view -> {

            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "name", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity3.this, "CHANNEL_ID")
                    .setSmallIcon(R.drawable.ic_arrow)
                    .setContentTitle("My notification")
                    .setContentText("Hello World!")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setAutoCancel(true);

            notificationManager.notify(0, builder.build());


        });


        btn_pdialog.setOnClickListener(view -> {
            ProgressDialog progressDialog = new ProgressDialog(MainActivity3.this);
            progressDialog.setTitle("Information");
            progressDialog.setMessage("Are you sure sure?");
            progressDialog.show();
        });

        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                AlertDialog.Builder alertbox = new AlertDialog.Builder(MainActivity3.this);
                alertbox.setTitle("This is warning");
                alertbox.setMessage("Alertttt");

                alertbox.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity3.this,"in toast",Toast.LENGTH_LONG).show();
                    }
                });

                alertbox.setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity3.this,MainActivity.class);
                        startActivity(intent);
                    }
                });

                alertbox.show();

            }
        });




    }
}