package com.khlaedahmmedanik.healthconditionpredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class diseaseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getActionBar().setTitle("Hello world App");
        setTitle("Disease List :");
        setContentView(R.layout.activity_disease_list);
    }
}