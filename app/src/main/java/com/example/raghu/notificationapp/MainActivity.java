package com.example.raghu.notificationapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addNotification();
            }
        });
    }
    public void addNotification()
    {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(R.drawable.icon);
        builder.setContentTitle("SAMPLE ");
        builder.setContentText("Notification Generated");

        Intent n=new Intent(this,MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(this,0,n,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());

    }
}
