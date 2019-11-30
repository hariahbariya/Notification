package com.example.admin.notification;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity {

    Button button;
    int NOTIFICATION_ID=1;
    String Channel_id="Simple Notification";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {

                if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O)
                {
                    NotificationChannel notificationChannel=new NotificationChannel(Channel_id, "Mynotification", NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager=getSystemService(NotificationManager.class);

                    manager.createNotificationChannel(notificationChannel);
                }

                Notification.Builder builder=new Notification.Builder(MainActivity.this);
                builder.setSmallIcon(R.drawable.ic_notifications_active_black_24dp);
                builder.setContentTitle("Notification Alert");
                builder.setContentText("Simple Notification Example");
                builder.setAutoCancel(true);
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat compat=NotificationManagerCompat.from(getApplicationContext());
                compat.notify(NOTIFICATION_ID,builder.build());
            }
        });
    }


}
