package me.smartwatches.simplenotification;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;


public class HandHeldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_held);
        Button mButton = (Button) findViewById(R.id.button);
       // String  restw =  R.id.editText12;
        final EditText restw = (EditText) findViewById(R.id.editText12);
      //  final String rame = restw.getText().toString();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rame = restw.getText().toString();
                TimePicker tictoc = (TimePicker) findViewById(R.id.timePicker2) ;
                int hourtime = tictoc.getCurrentHour();
               int mintime = tictoc.getCurrentMinute();

                Notification notification = new NotificationCompat.Builder(getApplication())
                        .setSmallIcon(R.drawable.ic_stat_name)
                        .setContentTitle("Reminder : " +rame )
                        .setContentText(" Time : " + hourtime +":" + mintime )
                        .extend(
                                new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                        .build();
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
                int notificationId = 1;
                notificationManager.notify(notificationId, notification);
            }
        });

    }

}
