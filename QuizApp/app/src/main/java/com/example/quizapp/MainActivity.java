package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {
    MaterialCardView TarihCard, CografyaCard, GenelkulturCard, BilimCard, SporCard, SanatCard, MuzikCard, SinemaCard, EdebiyatCard, YazilimCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TarihCard=findViewById(R.id.TarihCard);
        CografyaCard=findViewById(R.id.CografyaCard);
        GenelkulturCard=findViewById(R.id.GenelkulturCard);
        BilimCard=findViewById(R.id.BilimCard);
        SporCard=findViewById(R.id.SporCard);
        SanatCard=findViewById(R.id.SanatCard);
        MuzikCard=findViewById(R.id.MuzikCard);
        SinemaCard=findViewById(R.id.SinemaCard);
        EdebiyatCard=findViewById(R.id.EdebiyatCard);
        YazilimCard=findViewById(R.id.YazilimCard);

        TarihCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TarihQuiz.class));
                finish();

            }
        });

        CografyaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CografyaQuiz.class));
                finish();
            }
        });
        GenelkulturCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GenelKulturQuiz.class));
                finish();
            }
        });
        BilimCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BilimQuiz.class));
                finish();
            }
        });
        SporCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SporQuiz.class));
                finish();
            }
        });
        SanatCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SanatQuiz.class));
                finish();
            }
        });
        MuzikCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MuzikQuiz.class));
                finish();
            }
        });
        SinemaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SinemaQuiz.class));
                finish();
            }
        });
        EdebiyatCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EdebiyatQuiz.class));
                finish();
            }
        });
        YazilimCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, YazilimQuiz.class));
                finish();
            }
        });
    }

   @Override
    public void onBackPressed() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder= new MaterialAlertDialogBuilder(MainActivity.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Uygulamadan çıkmak istediğinize emin misiniz");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface,int i) {
              dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface,int i) {
            finish();
            }
        });
        materialAlertDialogBuilder.show();
    }
}