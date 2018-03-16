package com.example.along.exercise3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = this.getIntent();
        String title = intent.getStringExtra("title");
        String imagelink = intent.getStringExtra("imagelink");
        String decription = intent.getStringExtra("decription");
        String date = intent.getStringExtra("date");
        double rating = intent.getDoubleExtra("rating",5);
        float rating_fix = (float) Math.round(rating/2*10)/10;

        ImageView ivPlayer = findViewById(R.id.ivPlayer);
        Picasso.with(this).load(imagelink).into(ivPlayer);
        TextView tvTitleDetail = findViewById(R.id.tvTitleDetail);
        tvTitleDetail.setText(title);
        TextView tvDate = findViewById(R.id.tvDate);
        tvDate.setText("Release Date: "+date);
        TextView tvDescription = findViewById(R.id.tvDescription);
        tvDescription.setText(decription);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(rating_fix);

    }
}