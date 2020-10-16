package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            startActivity(new Intent(this, HomeActivity.class));
            Toast.makeText(getApplicationContext(), "Welcome " + username.getText(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Username atau Password Tidak Benar ", Toast.LENGTH_LONG).show();
        }
        onNotificationBtnClicked();
    }
    private void onNotificationBtnClicked(){
        String CHANNEL_ID = "MY_NOTIF_CHANNEL";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("My Notification")
                .setContentText("My Notification Content")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        int notificationID = 1;
        notificationManagerCompat.notify(notificationID, builder.build());
    }
}