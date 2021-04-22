package com.silvia.simulasi.MenuAbout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.silvia.simulasi.Login;
import com.silvia.simulasi.PrefManager;
import com.silvia.simulasi.R;

public class About extends AppCompatActivity {
    Button btnlogout;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btnlogout = findViewById(R.id.btnlogout);
        prefManager = new PrefManager(this);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefManager.logoutUser();
            }
        });

    }
}