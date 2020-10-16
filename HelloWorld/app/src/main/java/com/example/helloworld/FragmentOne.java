package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {
    private static final String TAG = FragmentOne.class.getSimpleName();
    Button buttonNotifTrigger;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: Fragment One");
        View view = inflater.inflate(R.layout.fragment_tabone, container, false);
        buttonNotifTrigger = view.findViewById(R.id.button_login);
        buttonNotifTrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onNotificationBtnClicked();
            }
        });

        return view;
    }
//    private void onNotificationBtnClicked(){
//        String CHANNEL_ID = "MY_NOTIF_CHANNEL";
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "CHANNEL_ID")
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("My Notification")
//                .setContentText("My Notification Content")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(requireContext());
//        int notificationID = 1;
//        notificationManagerCompat.notify(notificationID, builder.build());
//    }
}
