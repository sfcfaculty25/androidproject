package com.example.firstapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class FetchDatabase extends BaseAdapter
{
    Context context;
    ArrayList<Std> data;
    StorageReference storageReference;

    public FetchDatabase(Context context, ArrayList<Std> data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount()
    {
        return data.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        DatabaseReference databaseReference = FirebaseDatabase
                .getInstance("https://firstapp-4043d-default-rtdb.asia-southeast1.firebasedatabase.app").
                        getReference("Student");

        storageReference = FirebaseStorage.getInstance().getReference("images");
        View root = LayoutInflater.from(context).inflate(R.layout.listview_content, null);

        TextView textview_stdname = root.findViewById(R.id.textView);
        TextView textview_course = root.findViewById(R.id.textView2);
        ImageView img = root.findViewById(R.id.dataimg);

        Button btn_del = root.findViewById(R.id.btn_del);
        Button btn_update  = root.findViewById(R.id.btn_update);
        Glide.with(context).load("https://firebasestorage.googleapis.com/v0/b/firstapp-4043d.appspot.com/o/"+storageReference.getName()+"%2F"+data.get(position).getImg()+"?alt=media&token=f011aef1-c00b-44a5-97d6-75f50916e254").into(img);

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = data.get(position).getStdid();
                databaseReference.child(id).removeValue();
                Intent i = new Intent(context,selectdata.class);
                context.startActivity(i);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent x = new Intent(context,updatedata.class);
                x.putExtra("imgname",data.get(position).getImg().toString());
                x.putExtra("stdid",data.get(position).getStdid());
                x.putExtra("email",data.get(position).getStdname());
                x.putExtra("pass",data.get(position).getCourse());
                context.startActivity(x);
            }
        });

//        storageReference.child(data.get(position).getImg()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                //img.setImageURI(uri);
//            }
//        });


        textview_stdname.setText(data.get(position).getStdname());
       textview_course.setText(storageReference.getName()+"%2F"+data.get(position).getImg());
        return root;
    }
}
