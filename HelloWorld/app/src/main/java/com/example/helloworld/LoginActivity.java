package com.example.helloworld;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText username;
    private EditText password;
    private Button loginbutton;
    private Button SignUpButton;
    private SqLite sqlitedb;
    LogInCheck loggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.input_username);
        password = findViewById(R.id.input_password);
        loginbutton = findViewById(R.id.button_login);
        SignUpButton = findViewById(R.id.button_signup);
        sqlitedb = new SqLite(this);
        loggedIn = new LogInCheck(this);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( LoginActivity.this,
                        SignUpActivity.class);
                startActivity(i);
            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUsername = username.getText().toString().trim();
                String getPassword = password.getText().toString().trim();
                boolean res = sqlitedb.checkUser(getUsername,getPassword);
                if(res){
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    LogInCheck.saveSPBoolean(LogInCheck.LoggedIn, true);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (LogInCheck.getLoggedIn()){
            startActivity(new Intent(LoginActivity.this, HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }
    public static Spanned fromHtml(String html){
        Spanned results;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            results = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        }else {
            results = Html.fromHtml(html);
        }
        return results;
    }
}