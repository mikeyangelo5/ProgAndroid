package com.example.helloworld;

import android.content.ContentValues;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText newUsername, newPassword;
    Button btnSignUp;
    SqLite sqlitedb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        sqlitedb = new SqLite(this);

        newUsername = (EditText)findViewById(R.id.input_username);
        newPassword = (EditText)findViewById(R.id.input_password);
        btnSignUp = (Button)findViewById(R.id.button_signuppage);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = newUsername.getText().toString().trim();
                String password = newPassword.getText().toString().trim();

                ContentValues values = new ContentValues();


                if (password.equals("") || username.equals("")){
                    Toast.makeText(SignUpActivity.this, "Username or Password can't be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    values.put(sqlitedb.row_username, username);
                    values.put(sqlitedb.row_password, password);
                    sqlitedb.insertData(values);

                    Toast.makeText(SignUpActivity.this, "Sign Up Success!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
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