package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText username;
    private EditText password;
    private Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "OnCreate: Called");
        Log.i(TAG, "OnCreate: Called Two Times");
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.input_username);
        password = findViewById(R.id.input_password);
        loginbutton = findViewById(R.id.button_login);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonclicked();
            }
        });
    }

    private void buttonclicked(){
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            Intent homescreen = new Intent(MainActivity.this,Homescreen.class);
            Toast.makeText(getApplicationContext(), "Welcome " + username.getText(), Toast.LENGTH_LONG).show();
            startActivity(homescreen);
        } else {
            Toast.makeText(getApplicationContext(), "Username atau Password Tidak Benar ", Toast.LENGTH_LONG).show();
        }
    }
}