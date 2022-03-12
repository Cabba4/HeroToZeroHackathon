package com.example.myroute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class loginPage extends AppCompatActivity {

    private RequestQueue queue;
    String testUrl = "http://10.0.2.2:5000/api/v1/user/john.doe@example.com/super_secret_pass";
    String receivedPass= "bad";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        queue = Volley.newRequestQueue(this);
    }

    public void loginNow(View view) {
        EditText username = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, testUrl,
                response -> {
                    Toast.makeText(this,response,Toast.LENGTH_LONG).show();
                    try {
                        JSONArray credentials = new JSONArray(response);
                        receivedPass = credentials.getJSONObject(0).getString("password");
                        if(password.equals(receivedPass))
                        {
                            Toast.makeText(this,receivedPass,Toast.LENGTH_LONG).show();
                        }

                    } catch (JSONException e) {
                        Toast.makeText(this,receivedPass,Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                    //
                   // parseJsonAndUpdateUI(response);  	//<= Sub function which parses the json object
                },
                volleyError -> {
                    Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
                });

        // Sending request by adding it to queue
        queue.add(stringRequest);

    }

    public void openRegister(View view) {
        Intent intent = new Intent(this,registerPerson.class);
        startActivity(intent);
    }
}