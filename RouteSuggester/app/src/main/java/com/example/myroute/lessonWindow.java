package com.example.myroute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;

public class lessonWindow extends AppCompatActivity {
    ListView l;
    listObject taskStore;
    ArrayList<listObject> taskList = new ArrayList<>();
    private RequestQueue queue;
    String listDatafromBackend = "https://21wsp4pw.course.tamk.cloud/api/v2/tasks/";
    String userId = getIntent().getStringExtra("Id");
    String superPass = "/super_secret_pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_window);
        //getList();
        //showChange();
        //Toast.makeText(this,listDatafromBackend+userId+superPass,Toast.LENGTH_LONG).show();
        queue = Volley.newRequestQueue(this);
    }
    private int counter =0;
    public void getList(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, listDatafromBackend,
                response -> {
                    try {
                        JSONArray tasks = new JSONArray(response);
                        while(tasks.getJSONObject(counter).has("name"))
                        {
                            taskStore.setTask_id(tasks.getJSONObject(counter).getInt("task_id"));
                            taskStore.setName(tasks.getJSONObject(counter).getString("name"));
                            taskStore.setCompletion(tasks.getJSONObject(counter).getInt("completion"));
                            taskStore.setDescription(tasks.getJSONObject(counter).getString("description"));
                            taskStore.setGoal(tasks.getJSONObject(counter).getInt("goal"));
                            taskStore.setType(tasks.getJSONObject(counter).getString("type"));
                            taskStore.setWeight(tasks.getJSONObject(counter).getInt("weight"));
                            taskList.add(taskStore);
                            counter++;
                        }
                        //task_id = tasks.getJSONOb
                        Toast.makeText(this,taskStore.toString(),Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //Toast.makeText(this,response,Toast.LENGTH_LONG).show();
                    //parseJsonAndUpdateUI(response);  	//<= Sub function which parses the json object
                },
                volleyError -> {
                    Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
                });
        // Sending request by adding it to queue
        queue.add(stringRequest);
    }

    public void showChange(View view) {
       getList();
        l = findViewById(R.id.listView);
        ArrayAdapter<listObject> arr;
        arr
                = new ArrayAdapter<listObject>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                taskList);
        l.setAdapter(arr);
        //getList();
    }
}