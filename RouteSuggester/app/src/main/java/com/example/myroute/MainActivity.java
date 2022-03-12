package com.example.myroute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showCommunityStats(View view) {
        //Intent intent = new Intent(this,communityStats.class);
        TextView mainScreenStats = findViewById(R.id.textView2);
        Integer percentageCommunity = getPercentage();
        mainScreenStats.setText("Community GreenRate: "+percentageCommunity.toString());
    }

    private int getPercentage() {
        int percentage;
        percentage = 100;
        return percentage;
    }

    public void showMyStats(View view) {
        TextView mainScreenStats = findViewById(R.id.textView2);
        Integer percentageMy = getPercentage();
        mainScreenStats.setText("My GreenRate: "+percentageMy.toString());
    }

    public void showLessons(View view) {
        Intent intent = new Intent(this,lessonWindow.class);
        // Maybe send some data here
        startActivity(intent);
    }

    public void showLogin(View view) {
        Intent intent = new Intent(this,loginPage.class);
    }
}