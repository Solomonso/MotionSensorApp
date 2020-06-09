package com.example.motionsensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {
    private String TAG = "Demo";
    TextView textView;
    private RequestQueue requestQueue;
    private String motion_dev;
    private String time;
    private static final String URL = "http://192.168.178.62/RequestApi/frontDoor.php";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        requestQueue = Volley.newRequestQueue(this);
       load();
        textView = findViewById(R.id.textView7);
    }

    public void load()
    {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("motion");
                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject motion = jsonArray.getJSONObject(i);
                        Log.i(TAG, String.valueOf(motion));
                        motion_dev = motion.getString("motion_dev");
                        time = motion.getString("time_detected");
                        textView.setText(motion_dev + ", " + time + ", " + "\n\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }
}