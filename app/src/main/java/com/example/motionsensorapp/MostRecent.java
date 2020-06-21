package com.example.motionsensorapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Objects;

public class MostRecent extends Fragment {
    private static final String URL = "http://192.168.178.62/RequestApi/frontDoor.php";
    TextView frontDoorTime;
    TextView frontDoorTimesDetected;
    TextView bedTime;
    public String TAG = "hello";
    private String motion_dev;
    private String time;
    private int number2;
    private int numberOfTimesDetectedFrontDoor;
    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.most_recent_layout, container, false);
        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()).getApplicationContext());

        //Log.i(TAG, number2 + " null");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,URL,  null, new Response.Listener<JSONObject>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = response.getJSONArray("motion");
                    Log.i(TAG, String.valueOf(jsonArray));

                    JSONArray json = response.getJSONArray("motion");
                    JSONObject json2 = json.getJSONObject(0);
                    number2 = json2.getInt("id");
                    //Log.i(TAG, number2 + " ");
                    //Log.i(TAG, number2 + " final");
//
//                    for(int i = 0; i < jsonArrayBed.length(); i++)
//                    {
//                        JSONObject motionBed = jsonArrayBed.getJSONObject(i);
//                        Log.i(TAG, String.valueOf(motionBed));
//                        String timeBed = motionBed.getString("motion_dev");
//                        bedTime = (TextView) view.findViewById(R.id.time2);
//                        bedTime.setText(timeBed);
//                    }

                    //loop to display front door details
                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject motion = jsonArray.getJSONObject(i);
                        //display the json the in the logcat
                        Log.i(TAG, String.valueOf(motion));
                        //get from the api
                        motion_dev = motion.getString("motion_dev");
                        time = motion.getString("time_detected");
                        numberOfTimesDetectedFrontDoor = motion.getInt("id");
//                        number = numberOfTimesDetectedFrontDoor;
                        //set text view to display details to the screen
                        frontDoorTimesDetected = (TextView) view.findViewById(R.id.front_door_number_of_times);
                        frontDoorTime = (TextView) view.findViewById(R.id.time1);
                        //display the details to the screen
                       // frontDoorTime.setText(time);
                        frontDoorTime.setText(time);
                        frontDoorTimesDetected.setText(String.valueOf(numberOfTimesDetectedFrontDoor));
                        TextView name = (TextView) view.findViewById(R.id.textView2);
                        name.setText(motion_dev);
                        //for graph view
                        GraphView graph = (GraphView) view.findViewById(R.id.graph);
                        //assert motionTimes != null;
                        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                                new DataPoint(0,0),
                                new DataPoint(1, numberOfTimesDetectedFrontDoor),
                                new DataPoint(2, 0),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
                        });
                        graph.addSeries(series);

                        //styling
                        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                            @Override
                            public int get(DataPoint data) {
                                return Color.rgb((int)data.getX()*255/4, (int) Math.abs(data.getY()*255/6),100);
                            }
                        });
                        series.setSpacing(50);
                        // draw values on top
                        series.setDrawValuesOnTop(true);
                        series.setValuesOnTopColor(Color.RED);
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
