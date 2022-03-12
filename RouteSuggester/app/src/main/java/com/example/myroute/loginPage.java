package com.example.myroute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class loginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void loginNow(View view) {
        EditText username = (EditText)findViewById(R.id.editTextTextPersonName);
        EditText password = (EditText)findViewById(R.id.editTextTextPassword);
        

    }

    public void openRegister(View view) {
        Intent intent = new Intent(this,registerPerson.class);
        startActivity(intent);
    }
}