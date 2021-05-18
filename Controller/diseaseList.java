package com.khlaedahmmedanik.healthconditionpredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.khlaedahmmedanik.healthconditionpredictor.R;

public class diseaseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getActionBar().setTitle("Hello world App");
        setTitle("Disease List :");
        setContentView(R.layout.activity_disease_list);
    }
    public static String disceaseSyntomps(String newText){
        String ret="Not found";
        databaseHelper.init();
        for(diseaseInfo x : databaseHelper.allDiseaseInfo) {

            String name = x.symptoms,nam = x.diseaseName;

            if(newText.equals(nam)){
                return name;
            }
        }

        return ret;
    }
}
