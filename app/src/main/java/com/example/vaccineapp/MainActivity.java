package com.example.vaccineapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
// 1- adapter view
    RecyclerView recyclerView;
//    2 data source
    ModelClass[]myListData;
//    3 adapter
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.recyclerView);
        myListData=new ModelClass[]{
                new ModelClass("Hepatitis B Vaccine",R.drawable.vaccine1),
                new ModelClass("Tetanus Vaccine",R.drawable.vaccine4),
                new ModelClass("Pneumococcal Vaccine",R.drawable.vaccine5),
                new ModelClass("Rotavirus Vaccine",R.drawable.vaccine6),
                new ModelClass("Measles Virus Vaccine",R.drawable.vaccine7),
                new ModelClass("Cholera virus Vaccine",R.drawable.vaccine8),
                new ModelClass("Covid-19 Vaccine",R.drawable.vaccine9),
        };
//        adapter
        adapter= new CustomAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Vaccine name: "+myListData[pos].getTitle(), Toast.LENGTH_SHORT).show();
    }
}