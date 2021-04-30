package com.khlaedahmmedanik.healthconditionpredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class serviceProviderInterface extends AppCompatActivity {

    userOfAllType myInfo;
    TextView myName;
    ListView allRequset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_interface);

        myInfo=databaseHelper.getMyInfo(0);


        myName=findViewById(R.id.name);
        myName.setText(myInfo.name);

        allRequset.findViewById(R.id.allRequst);

        //will add onClickLisaner to all request so that requset can be confirm by serviceProvider

    }

    //will add payCommuission method


    //will add announcement method to announce ony notice, free campign
}