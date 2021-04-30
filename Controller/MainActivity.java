package com.khlaedahmmedanik.healthconditionpredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=5000; // how many milisecound starting activity stay

    //variables
    Animation topAnim,bottomAnim;
    TextView logo,slogan;
    userOfAllType a= new userOfAllType("anik","a","khaledahmmedanik@gmail.com","user");
    userOfAllType b= new userOfAllType("ambulance370","370","370ambulance@gmail.com","ambulanceServiceProvider");
    userOfAllType c= new userOfAllType("doctor370","370","370doctor@gmail.com","doctorServiceProvider");

    diseaseInfo aa=new diseaseInfo("Goitre","painful joints");
    diseaseInfo bb=new diseaseInfo("Scurvy","swollen gums,delayed wound healing");
    diseaseInfo cc=new diseaseInfo("Rickets","sleeplessness, pale face, diarrhoea,deformed skull");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title.
        //hide the title bar.
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //Animations
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks
        logo=findViewById(R.id.logo);
        slogan=findViewById(R.id.slogan);

        logo.setAnimation(topAnim);
        slogan.setAnimation(bottomAnim);

        //set pre  database data
        databaseHelper.allUserInfo.add(a);
        databaseHelper.allUserInfo.add(b);
        databaseHelper.allUserInfo.add(c);


        databaseHelper.allDiseaseInfo.add(aa);
        databaseHelper.allDiseaseInfo.add(bb);
        databaseHelper.allDiseaseInfo.add(cc);

        //all pre addition done

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,logIn.class);
               // startActivity(intent);
               // finish();
                Pair[] pairs =new Pair[2];
                pairs[0]=new Pair<View,String>(logo,"logoImg");
                pairs[1]=new Pair<View,String>(slogan,"sloganImg");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                   // finish();
                }

            }

        },SPLASH_SCREEN);

    }
}