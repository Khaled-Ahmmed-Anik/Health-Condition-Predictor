package com.khlaedahmmedanik.healthconditionpredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class userFirstInterface extends AppCompatActivity {

   /* userOfAllType myInfo;
    TextView myName;
    ListView previousHistory,showSearchedResult;
    SearchView searchBar;*/

    userOfAllType myInfo;
    public static int myIndex;
    TextView myName,myMail;
    SearchView searchView;
    Button dis;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title.
        //hide the title bar.
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user_first_interface);



        myInfo=databaseHelper.getMyInfo(myIndex);

        //hooks
        searchView=findViewById(R.id.search_bar);
        searchView.setQueryHint("symptoms, symptoms");
        myName=findViewById(R.id.setName);
        myMail=findViewById(R.id.setMail);
        myName.setText("Name : "+myInfo.name);
        myMail.setText("Email : "+myInfo.email);

        dis=findViewById(R.id.dis);

        imageView=findViewById(R.id.image);


      //search work
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText) {
                int j=0;
                String nam;
                for(diseaseInfo x : databaseHelper.allDiseaseInfo){

                    String name=x.symptoms;nam=x.diseaseName;
                    int newTextLength=newText.length();
                    int nameLength=name.length();
                    int minLenght=Math.min(newTextLength,nameLength);
                    int cnt=0;

                    //Toast.makeText(DetailsActivity.this, newText+" "+x.name, Toast.LENGTH_SHORT).show();
                    if(nameLength<newTextLength)continue;
                    for(int i=0;i<minLenght;i++){

                        if(newText.charAt(i)==name.charAt(i)){
                            cnt++;
                        }else {
                            break;
                        }
                    }
                    if(cnt==minLenght){

                        if(nam.equals("Goitre")){
                            imageView.setVisibility(View.VISIBLE);
                            imageView.setBackgroundResource(R.drawable.goitre);
                        }else if(nam.equals("Rickets")){
                            imageView.setVisibility(View.VISIBLE);
                            imageView.setBackgroundResource(R.drawable.rickes);
                        }

                        return false;
                    }
                    j++;
                }



                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                imageView.setVisibility(View.INVISIBLE);

                // Toast.makeText(DetailsActivity.this, Integer.toString(mainWork.productListList.size()), Toast.LENGTH_SHORT).show();

                //customAdapter.getFilter().filter(newText);
                return false;
            }
        });

        //search done

        //will  add onClickLisener of select particulaer service if user is primium;


    }

    public void tipDis(View V){
        Intent intent=new Intent(userFirstInterface.this,diseaseList.class);
        startActivity(intent);
    }

    //will add payment method to get services\

    public  void showCustomToast(int i){
        Toast.makeText(this, databaseHelper.allDiseaseInfo.get(i).diseaseName, Toast.LENGTH_SHORT).show();
    }


    public void logout(View V){
        Intent intent=new Intent(userFirstInterface.this,logIn.class);
        startActivity(intent);
        finish();
    }

    public void book(View V){
        Intent intent=new Intent(userFirstInterface.this,booking.class);
        startActivity(intent);
    }
}