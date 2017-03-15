package com.acadgild.session10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MaterialDesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        RecyclerView faceBookRecycler=(RecyclerView)findViewById(R.id.myRecyclerView);

        List<FacebookUser> facebookUsers=new ArrayList<FacebookUser>();
        facebookUsers.add(new FacebookUser("Pooja","Delhi"));
        facebookUsers.add(new FacebookUser("Sahitya","Banglore"));
        facebookUsers.add(new FacebookUser("Monjit","Banglore"));
        facebookUsers.add(new FacebookUser("Gajendra","--"));
        facebookUsers.add(new FacebookUser("Sujit","Banglore"));
        facebookUsers.add(new FacebookUser("Bhanu","--"));
        facebookUsers.add(new FacebookUser("Hemanth","Banglore"));


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        faceBookRecycler.setLayoutManager(linearLayoutManager);

        RecyclerViewAdapter myAdapter=new RecyclerViewAdapter(facebookUsers,this);
        faceBookRecycler.setAdapter(myAdapter);
        faceBookRecycler.setHasFixedSize(true);


    }
}
