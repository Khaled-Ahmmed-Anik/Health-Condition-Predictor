package com.khlaedahmmedanik.healthconditionpredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class logIn extends AppCompatActivity {


    //variables
    TextInputLayout username,password;
    TextView wrongpasswordmsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title.
        //hide the title bar.
        getSupportActionBar().hide();
        setContentView(R.layout.activity_log_in);

        //hooks
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
    }

    private Boolean validateName(){
        String val=username.getEditText().getText().toString();
        if(val.isEmpty()){
            username.setError("Field cannot be empty");
            return false;
        }else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatepass(){
        String val=password.getEditText().getText().toString();
        if(val.isEmpty()){
            password.setError("Field cannot be empty");
            return false;
        }else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


    public void go(View view){

        if(!validateName() || !validatepass())return;

        String name=username.getEditText().getText().toString();
        String passString=password.getEditText().getText().toString();

       // if(name.equals(id) && passString.equals(pass)){

            //check data is in the database
            int x=0;
            String role="";//store the role

            for (int i = 0; i < databaseHelper.allUserInfo.size(); i++) {

                userOfAllType temp=databaseHelper.allUserInfo.get(i);

                if(temp.name.equals(name) && temp.password.equals(passString)){
                    role=temp.role;
                    userFirstInterface.myIndex=i;
                    x=1;
                    break;
                }

            }

            if(x==0){
                wrongpasswordmsg=findViewById(R.id.wrongpasswordmsg);
                wrongpasswordmsg.setVisibility(View.VISIBLE);
                Toast.makeText(this, "name or password not matched", Toast.LENGTH_SHORT).show();
                return;
            }else {
                wrongpasswordmsg=findViewById(R.id.wrongpasswordmsg);
                wrongpasswordmsg.setVisibility(View.INVISIBLE);
            }

            // check done

            Toast.makeText(this, "Log-In successful "+role, Toast.LENGTH_SHORT).show();//check korteci




            if(role.equals("user")){
                //go to general user interfase
                 Intent intent=new Intent(logIn.this,userFirstInterface.class);
                 startActivity(intent);
                 finish();
            }else if(role.equals("premimumUser")){
                //go to primium user interfase
                //  Intent intent=new Intent(logeinPage.this,generalUserService.class);
                //  startActivity(intent);
            }else if(role.equals("doctorServiceProvider")){
                //go to primium user interfase
                //  Intent intent=new Intent(logeinPage.this,doctorServiceProviderWork.class);
                //  startActivity(intent);
            }else if(role.equals("ambulanceServiceProvider")){
                //go to primium user interfase
                // Intent intent=new Intent(logeinPage.this,ambulanceServiceProviderWork.class);
                // startActivity(intent);
            }


            //finish();
       // }else {

       // }
    }

    public void goSignUp(View view){
        //go to signUp page interfase
        Intent intent=new Intent(logIn.this,signUpPage.class);
        startActivity(intent);
    }

}