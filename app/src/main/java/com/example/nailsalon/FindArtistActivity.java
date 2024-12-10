package com.example.nailsalon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_artist_main);

        CardView exit = findViewById(R.id.cardFABack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindArtistActivity.this,HomeActivity.class));
            }
        });

        CardView nailtechnichian = findViewById(R.id.cardFANailTechnician);
        nailtechnichian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindArtistActivity.this,ArtistDetailActivity.class);
                it.putExtra("title","Nail Technician");
                startActivity(it);
            }
        });

        CardView manicurist = findViewById(R.id.cardFAManicurist);
        manicurist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindArtistActivity.this,ArtistDetailActivity.class);
                it.putExtra("title","Manicurist");
                startActivity(it);
            }
        });

        CardView pedicurist = findViewById(R.id.cardFAPedicurist);
        pedicurist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindArtistActivity.this,ArtistDetailActivity.class);
                it.putExtra("title","Pedicurist");
                startActivity(it);
            }
        });

        CardView masseuse = findViewById(R.id.cardFAMasseuse);
        masseuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindArtistActivity.this,ArtistDetailActivity.class);
                it.putExtra("title","Masseuse");
                startActivity(it);
            }
        });

        CardView makeupartist = findViewById(R.id.cardFAMakeupartist);
        makeupartist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindArtistActivity.this,ArtistDetailActivity.class);
                it.putExtra("title","Makeup Artist");
                startActivity(it);
            }
        });

    }
}