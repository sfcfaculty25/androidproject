package com.example.firstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class datainsert extends AppCompatActivity {

    EditText data_email, data_pass;
    Button btn_add, btn_display,btn_choose;
    ImageView im;

    String id;

    StorageReference storageReference;

    Uri imguri;

    //connection string
    DatabaseReference databaseReference = FirebaseDatabase
            .getInstance("https://firstapp-4043d-default-rtdb.asia-southeast1.firebasedatabase.app").
                    getReference("Student");
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datainsert);

        storageReference = FirebaseStorage.getInstance().getReference("images");

        data_email = findViewById(R.id.data_email);
        data_pass = findViewById(R.id.data_pass);
        btn_add = findViewById(R.id.btn_add);
        btn_choose = findViewById(R.id.btnchoose);
        im = findViewById(R.id.img_upload);

        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                choosefile();
            }
        });


        btn_add.setOnClickListener(view ->
        {
      id = System.currentTimeMillis()+"";
        Std std = new Std(id,data_email.getText().toString(),data_pass.getText().toString(),id+"."+getextension(imguri));
           //insert
            databaseReference.child(id).setValue(std);

            Toast.makeText(datainsert.this, "Inserted", Toast.LENGTH_SHORT).show();

           fileupload();

            data_email.setText("");
            data_pass.setText("");
        });

        btn_display = findViewById(R.id.btn_show);
        btn_display.setOnClickListener(view->{
            Intent i =new Intent(datainsert.this, selectdata.class);
            startActivity(i);
        });
    }

    public void choosefile()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }

    public String getextension(Uri uri)
    {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return  mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }


    public void fileupload()
    {
        StorageReference ref = storageReference.child(id + "." + getextension(imguri));
        ref.putFile(imguri).addOnSuccessListener(datainsert.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( resultCode == RESULT_OK && data!=null)
        {
            imguri = data.getData();
            im.setImageURI(imguri);
        }
        else
        {
            Toast.makeText(this, "Null image", Toast.LENGTH_SHORT).show();
        }
    }
}