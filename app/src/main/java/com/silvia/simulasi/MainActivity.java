package com.silvia.simulasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.silvia.simulasi.MenuAbout.About;
import com.silvia.simulasi.MenuEvaluasi.Evaluasi;
import com.silvia.simulasi.MenuEvaluasi.ListEvaluasi;
import com.silvia.simulasi.MenuMateri.ListMateri;
import com.silvia.simulasi.MenuRpp.Rpp;
import com.silvia.simulasi.MenuSilabus.Silabus;
import com.silvia.simulasi.MenuVideo.Video;

public class MainActivity extends AppCompatActivity {
    LinearLayout btnSilabus, btnRpp, btnMateri, btnVideo, btnEvaluasi, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSilabus = findViewById(R.id.btnSilabus);
        btnSilabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Silabus.class);
                startActivity(i);
            }
        });

        btnRpp = findViewById(R.id.btnRpp);
        btnRpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Rpp.class);
                startActivity(i);
            }
        });

        btnMateri = findViewById(R.id.btnMateri);
        btnMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListMateri.class);
                startActivity(i);
            }
        });

        btnVideo = findViewById(R.id.btnVideo);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Video.class);
                startActivity(i);
            }
        });

        btnEvaluasi = findViewById(R.id.btnEvaluasi);
        btnEvaluasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListEvaluasi.class);
                startActivity(i);
            }
        });

        btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, About.class);
                startActivity(i);
            }
        });


    }
}