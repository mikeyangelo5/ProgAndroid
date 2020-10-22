package com.example.helloworld;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    private Switch wifiswitch;
    private WifiManager wifiManager;

    private static final String TAG = HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.i(TAG, "onCreate: Called");
        TabLayout tabLayout = findViewById(R.id.Tabs);
        TabItem tabItem1 = findViewById(R.id.First);
        TabItem tabItem2 = findViewById(R.id.Second);

//        BroadcastsReceiver broadcastsReceiver = new BroadcastsReceiver();
//        IntentFilter filter = new IntentFilter(ConnectivityManager.EXTRA_NO_CONNECTIVITY);
//        this.registerReceiver(broadcastsReceiver, filter); //aktif saat home act dijalankan

        final ViewPager viewPager = findViewById(R.id.FragmentsViewer);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        wifiswitch = findViewById(R.id.wifiSwitcher);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        initBroadcastReceiver();

        if (wifiManager.isWifiEnabled()) {
            wifiswitch.setChecked(true);
            wifiswitch.setText("Wifi is on");
        } else {
            wifiswitch.setChecked(false);
            wifiswitch.setText("Wifi is Off");
        }
    }
    protected void onStart(){
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver, intentFilter);
    }
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
    }
    BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
            switch (wifiState){
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiswitch.setChecked(true);
                    wifiswitch.setText("Wifi ON");
                    notification("Connected");
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiswitch.setChecked(false);
                    wifiswitch.setText("Wifi OFF");
                    notification("Disconnected");
                    break;
            }
        }
    };
    public void notification(String message){
        String CHANNEL_ID = "NOTIFICATION";
        NotificationChannel notificationChannel = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            notificationChannel = new NotificationChannel(CHANNEL_ID, "notification", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
            android.app.Notification notification1 = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.notification)
                    .setContentTitle("WIFI")
                    .setContentText(message)
                    .build();
            int notificationID = 1;
            notificationManager.notify(notificationID, notification1);
        }
    }
    private void initBroadcastReceiver(){
        final WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked && !wifiManager.isWifiEnabled()){
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
                        Intent intent = new Intent(Settings.Panel.ACTION_WIFI);
                        HomeActivity.this.startActivityForResult(intent, 1);
                    } else {
                        wifiManager.setWifiEnabled(true);
                    }
                } else if(!isChecked && wifiManager.isWifiEnabled()){
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
                        Intent intent = new Intent(Settings.Panel.ACTION_WIFI);
                        HomeActivity.this.startActivityForResult(intent, 1);
                    } else {
                        wifiManager.setWifiEnabled(false);
                    }
                }
            }
        });
    }
}