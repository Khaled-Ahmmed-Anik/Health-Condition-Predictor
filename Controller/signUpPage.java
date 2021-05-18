package com.khlaedahmmedanik.healthconditionpredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Math.min;

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
        String conPasswordS= String.valueOf(confirmPassword.getText());
        String emailS= String.valueOf(email.getText());
        String roleS= String.valueOf(role.getText());

        if(!checkAllValue(nameS,passwordS,emailS,roleS,conPasswordS))return;//check all values curreck or not;

        userOfAllType newUser=new userOfAllType(nameS,passwordS,emailS,roleS,"no records found");

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


    public static Boolean isNameValid(String val){
        if(val.isEmpty())return false;
        return true;
    }

    public static Boolean isMailValid(String val){
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(val);
        return m.matches();
    }

    public static Boolean isPassValid(String val){
       if(val.length()>=6)return true;
       return false;
    }

    public static Boolean isPassMatched(String val,String val1){
        if(val.length()!=val1.length())return false;
        for(int i=0;i<Math.min(val.length(),val1.length());i++){
            if(val.charAt(i)!=val1.charAt(i))return false;
        }
        return true;
    }

    public static Boolean isRoleValid(String val){
        String temp="user";
        for(int i=0;i<min(4,val.length());i++){
            if(temp.charAt(i)!=val.charAt(i))return false;
            if(i==3)return true;
        }

        for(int i=0;i<min(4,val.length());i++){
            if(temp.charAt(i)!=val.charAt(i))return false;
            if(i==3)return true;
        }
        temp="service provider";
        for(int i=0;i<min(temp.length(),val.length());i++){
            if(temp.charAt(i)!=val.charAt(i))return false;
        }

        return true;
    }




    public static boolean checkAllValue(String name,String pass,String email, String role,String confirmPass){
        if(!isNameValid(name))return false;
        if(!isMailValid(email))return false;
        if(!isPassValid(pass))return false;
        if(!isPassMatched(pass,confirmPass))return false;
        if(!isRoleValid(role))return false;
       // if(!isNameValid(name)||!isMailValid(email)|| isPassValid(pass)|| isRoleValid(role))return false;
        //will complete later
        return true;
    }

    public static Boolean validatepass(String val){
        if(val.isEmpty()){
            //  password.setError("Field cannot be empty");
            return false;
        }else {
            //  password.setError(null);
            //  password.setErrorEnabled(false);
            return true;
        }
    }

}
