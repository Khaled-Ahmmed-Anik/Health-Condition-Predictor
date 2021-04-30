package com.khlaedahmmedanik.healthconditionpredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUpPage extends AppCompatActivity {

    Button save;
    EditText name,email,password,confirmPassword,role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        name=findViewById(R.id.fullName);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirmPassword);
        role=findViewById(R.id.role);
        save=findViewById(R.id.save);
    }


    public void savePrassed(View V){
        if(role.equals("primiumUser")){
            if(!makePay())return;
        }
        String nameS= String.valueOf(name.getText());
        String passwordS= String.valueOf(password.getText());
        String emailS= String.valueOf(email.getText());
        String roleS= String.valueOf(role.getText());

        if(!checkAllVale())return;//check all values curreck or not;

        userOfAllType newUser=new userOfAllType(nameS,passwordS,emailS,roleS);

        //save to database;

        databaseHelper.allUserInfo.add(newUser);// added in dummy database
        Toast.makeText(this, "Added to database", Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(signUpPage.this,logIn.class);
        startActivity(intent);



        //then go reset the interfase;


    }

    public boolean makePay(){
        //will complete later
        return true;
    }

    public boolean checkAllVale(){
        //will complete later
        return true;
    }
}