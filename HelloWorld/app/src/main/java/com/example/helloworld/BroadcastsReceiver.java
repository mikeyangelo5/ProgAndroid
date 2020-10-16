package com.example.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcastsReceiver extends android.content.BroadcastReceiver {
    private static final String TAG = android.content.BroadcastReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"onReceive: fromBroadcastReceiver");
        Toast.makeText(context, "BroadcastReceived", Toast.LENGTH_LONG);
    }
}
