package com.example.along.exercise3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intView();
        // MyApp a = new MyApp();



    }

    public void intView(){
        Gson gson = new Gson();
        film myFilm = gson.fromJson(MyApp.getMessage(),film.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Result> arrayList = new ArrayList<>();
        for (int i = 0; i<myFilm.getResults().size();i++){
            arrayList.add(i,myFilm.getResults().get(i));
        }
        FilmAdapter filmAdapter = new FilmAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(filmAdapter);


    }
}