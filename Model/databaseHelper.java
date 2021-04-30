package com.khlaedahmmedanik.healthconditionpredictor;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class databaseHelper {

    // I used firebase database previously, I feel like this project is not fesible for 1 preson
    // so, I decided to not going to connect this project with actual database
    // for this I will use some 'lists' as a dummy database  to reduce my work

    public static List<userOfAllType> allUserInfo=new ArrayList<userOfAllType>();
    public static List<diseaseInfo> allDiseaseInfo=new ArrayList<diseaseInfo>();




    public static userOfAllType getMyInfo(int i){
        userOfAllType info=allUserInfo.get(i);
        //will fetch user Info from database in info;

        return info;
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
