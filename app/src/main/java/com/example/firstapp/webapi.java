package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class webapi extends AppCompatActivity {

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webapi);

        tv = findViewById(R.id.txtapidata);

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,"http://api.tvmaze.com/search/shows?q=golden%20girls",null,new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i=0;i<response.length();i++){

                        JSONObject jsonObject = response.getJSONObject(i);

                        JSONObject getshow = jsonObject.getJSONObject("show");
                        tv.setText(""+getshow.get("genres"));

                        //JSONArray genres = new JSONArray(getshow);
//                        for (int j=0;j<genres.length();j++)
//                        {
//                            tv.setText(""+ genres.getJSONObject(j).toString());
//                        }

                      //  Log.d("my-api","==== "+jsonObject.getString("title"));
                      //  Log.d("my-api","==== "+jsonObject.getString("userId"));
                       // Log.d("my-api","==== "+jsonObject.getString("id"));
                      //  arrayList.add(new DBHelper(Integer.parseInt(jsonObject.getString("userId")),Integer.parseInt(jsonObject.getString("id")),jsonObject.getString("title")));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
               // recyclerView.setAdapter(new Users(arrayList));
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
               tv.setText(error.getLocalizedMessage().toString());
            }
        });
        requestQueue.add(jsonArrayRequest);


//        RequestQueue queue = Volley.newRequestQueue(this);
//       String url = "https://corona.lmao.ninja/v2/all";
////
//// Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            tv.setText( jsonObject.getString("cases") );
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        // Display the first 500 characters of the response string.
//                      //  tv.setText("Response is: " + response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                tv.setText("That didn't work!");
//            }
//        });
//
//// Add the request to the RequestQueue.
//        queue.add(stringRequest);
    }
}