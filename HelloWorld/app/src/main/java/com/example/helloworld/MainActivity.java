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
        loginbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonclicked();
            }
        });
    }
    private void buttonclicked(){
        if(usernameinput.getText().toString().equals("admin") && passwordinput.getText().toString().equals("admin")){
            Toast.makeText(getApplicationContext(),"Welcome " + usernameinput.getText(), Toast.LENGTH_LONG).show();
            Intent home = new Intent(MainActivity.this,Homescreen.class);
            startActivity(home);
        } else {
            Toast.makeText(getApplicationContext(), "Username Dan Password anda tidak benar", Toast.LENGTH_LONG).show();
        }
    }
}