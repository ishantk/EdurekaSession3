package co.edureka.session3;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationDemoActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);

        btn = (Button)findViewById(R.id.buttonNotify);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonNotify){
            sendNotification();
        }
    }

    void sendNotification(){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setSmallIcon(R.drawable.folder);
        builder.setContentTitle("This is Title");
        builder.setContentText("This is Text..!!");

        // Requires Permission for Vibration
        builder.setDefaults(Notification.DEFAULT_ALL); // Sound LED and Vibration

        // Big Style Notification
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("This is Big Text..."));

        builder.addAction(android.R.drawable.ic_menu_add,"Add",null);
        builder.addAction(android.R.drawable.ic_menu_delete,"Delete",null);

        Notification notification = builder.build();

        NotificationManager manager  = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(101,notification);

    }
}
