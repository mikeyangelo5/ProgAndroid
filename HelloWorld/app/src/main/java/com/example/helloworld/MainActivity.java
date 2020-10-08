package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText usernameinput;
    private EditText passwordinput;
    private Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "OnCreate: Called");
        Log.i(TAG, "OnCreate: Called Two Times");
        setContentView(R.layout.activity_main);
        usernameinput = findViewById(R.id.input_username);
        passwordinput = findViewById(R.id.input_password);
        loginbutton = findViewById(R.id.button_login);
    }
}