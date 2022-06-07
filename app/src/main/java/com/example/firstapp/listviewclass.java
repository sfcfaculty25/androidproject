package com.example.firstapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class listviewclass extends BaseAdapter
{
    String[] planet = {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};

    String[] description = {"nearest planet","hottest planet","windy weather","planet with water","largest planet","it has rings","full of methane","coolest planet"};

    int[] img = {R.drawable.mercury,R.drawable.venus,R.drawable.earth,R.drawable.mars,R.drawable.jupiter,R.drawable.saturn,R.drawable.uranus,R.drawable.uranus};

    Context context;

    public listviewclass(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount() {
        return planet.length;
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
        View layout =  LayoutInflater.from(context).inflate(R.layout.listview_content,null);
        TextView tv = layout.findViewById(R.id.textView);

        //im.setImageResource(img[position]);
        tv.setText(planet[position]);

        Button btn_click = layout.findViewById(R.id.btn_del);

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MainActivity2.class);
                intent.putExtra("title",planet[position]);
                intent.putExtra("img",img[position]);
                intent.putExtra("desp",description[position]);
                context.startActivity(intent);
            }
        });

        return layout;
    }
}
