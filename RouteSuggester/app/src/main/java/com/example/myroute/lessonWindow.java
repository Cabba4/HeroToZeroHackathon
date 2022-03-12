package com.example.myroute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;

public class lessonWindow extends AppCompatActivity {

    ListView l;
    ArrayList<listObject> taskList = new ArrayList<>();
    private int id;
    private String name;
    private String description;
    private int weight;

    private RequestQueue queue;
    String listDatafromBackend = "https://mydatacomesfromhere.com";

    public void getList(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, listDatafromBackend,
                response -> {
                    //Toast.makeText(this,response,Toast.LENGTH_LONG).show();
                    parseJsonAndUpdateUI(response);  	//<= Sub function which parses the json object
                },
                volleyError -> {
                    Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
                });
        // Sending request by adding it to queue
        queue.add(stringRequest);
    }

    private void parseJsonAndUpdateUI(String response) {
        try {
            JSONObject list = new JSONObject(response);
            //id = list.getJSONArray();
            //name = list.getJSONArray();
            //description = list.getJSONArray();
            //weight = list.getJSONArray();
            taskList.add(new listObject(id,name,description,weight));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    String tutorials[]
            = { "Clean Kitchen", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_window);
        queue = Volley.newRequestQueue(this);
    }

    public void showChange(View view) {
        l = findViewById(R.id.listView);
        ArrayAdapter<listObject> arr;
        arr = new ArrayAdapter<listObject>(this,
                R.layout.support_simple_spinner_dropdown_item,
                taskList);
        l.setAdapter(arr);
    }

}