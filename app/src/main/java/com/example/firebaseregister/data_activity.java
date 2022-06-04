package com.example.firebaseregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class data_activity extends AppCompatActivity {
    TextView nameE,nameP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_activity);
        setTitle("User Info");
        nameE=findViewById(R.id.nameE);
        nameP=findViewById(R.id.nameP);

        Intent intent=getIntent();
        String showemail=getIntent().getStringExtra("email");
        String showpass=getIntent().getStringExtra("password");


        nameE.setText(showemail);
        nameP.setText(showpass);

    }
}