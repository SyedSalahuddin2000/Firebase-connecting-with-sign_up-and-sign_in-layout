package com.example.firebaseregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button buttonRegister;
    EditText userName,userEmail,userPassword;
    FirebaseAuth auth;
    ProgressBar progressBar;
    TextView logintext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        buttonRegister=findViewById(R.id.buttonRegister);
//        userName=findViewById(R.id.userName);
        userEmail=findViewById(R.id.userEmail);
        userPassword=findViewById(R.id.userPassword);
        auth=FirebaseAuth.getInstance();
        logintext=findViewById(R.id.logintext);
        logintext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                progressBar.setVisibility(View.VISIBLE);
//                String name=userName.getText().toString();
                String email=userEmail.getText().toString();
                String password=userPassword.getText().toString();
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
//                            progressBar.setVisibility(View.INVISIBLE);
//                            userName.setText("");
                            userEmail.setText("");
                            userPassword.setText("");
                            Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                        }
                        else {
                            progressBar.setVisibility(View.INVISIBLE);
//                            userName.setText("");
                            userEmail.setText("");
                            userPassword.setText("");
                            Toast.makeText(MainActivity.this, "Oops! something went wrong", Toast.LENGTH_LONG).show();

                        }
                        Intent intent=new Intent(MainActivity.this, login.class);
                        startActivity(intent);
                    }
                });

            }
        });

    }
}