package com.khlaedahmmedanik.healthconditionpredictor;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class databaseHelper {

    // I used firebase database previously, I feel like this project is not fesible to add huge backend work with in this time
    // so, I decided to not going to connect this project with actual database
    // for this I will use some 'lists' as a mock database  to reduce my work

    public static List<userOfAllType> allUserInfo=new ArrayList<userOfAllType>();
    public static List<diseaseInfo> allDiseaseInfo=new ArrayList<diseaseInfo>();




    public static userOfAllType getMyInfo(int i){
        userOfAllType info=allUserInfo.get(i);
        //will fetch user Info from database in info;

        return info;
    }

   public static void init(){
        userOfAllType a= new userOfAllType("anik","a","khaledahmmedanik@gmail.com","user","no records found");
        userOfAllType a1= new userOfAllType("anik98","ioiq1234","khaledahmmedanik@gmail.com","user","no records found");
        userOfAllType b= new userOfAllType("ambulance370","370","370ambulance@gmail.com","ambulanceServiceProvider","no records found");
        userOfAllType c= new userOfAllType("doctor370","370","370doctor@gmail.com","doctorServiceProvider","no records found");

        diseaseInfo aa=new diseaseInfo("Goitre","painful joints");
        diseaseInfo bb=new diseaseInfo("Scurvy","swollen gums,delayed wound healing");
        diseaseInfo cc=new diseaseInfo("Rickets","sleeplessness, pale face, diarrhoea, deformed skull");

        databaseHelper.allUserInfo.add(a);
        databaseHelper.allUserInfo.add(a1);
        databaseHelper.allUserInfo.add(b);
        databaseHelper.allUserInfo.add(c);


        databaseHelper.allDiseaseInfo.add(aa);
        databaseHelper.allDiseaseInfo.add(bb);
        databaseHelper.allDiseaseInfo.add(cc);
        //will fetch user Info from database in info;


    }

    public static serviceInfo getServiceInfo(){
        serviceInfo info=new serviceInfo();
        //will fetch user Info from database in info;

        return info;
    }

    public void addNewService(){
        //will add new service to database
    }

    public void addNewUserInfo(){
        //will add new user info to database
    }

    public void addDieaseInfo(){
        //will add new dieaseInfo to database
    }

}
