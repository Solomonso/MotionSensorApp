package com.example.motionsensorapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class AllSensorData extends Fragment {
    private static final String URL = "http://192.168.178.62/RequestApi/allSensorData.php";
    TextView allSensorData;
    public String TAG = "test";
    public String deviceName;
    public String timeDetected;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.all_sensor_data_layout,container,false);
        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()).getApplicationContext());

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,URL,  null, new Response.Listener<JSONObject>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(JSONObject response) {
                try {

                    //get the key for the whole json object which is an array
                    JSONArray jsonArray = response.getJSONArray("motion");
                    Log.i(TAG, String.valueOf(jsonArray));

                    //loop to get the details from the json array
                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject motion = jsonArray.getJSONObject(i);
                        //display the json the in the logcat
                        Log.i(TAG, String.valueOf(motion));
                        //get the json key motion_dev and time to display the value
                        deviceName = motion.getString("motion_dev");
                        timeDetected = motion.getString("time_detected");

                        allSensorData = (TextView) view.findViewById(R.id.allSensorData);
                        allSensorData.append("Device name " + deviceName + " detected motion at " + timeDetected + "\n\n");

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
        return view;
    }
}
