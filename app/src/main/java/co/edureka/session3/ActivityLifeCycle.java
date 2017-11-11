package co.edureka.session3;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.PersistableBundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityLifeCycle extends AppCompatActivity {

    static int code = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        showNotification("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showNotification("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showNotification("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showNotification("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showNotification("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showNotification("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showNotification("onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        showNotification("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showNotification("onRestoreInstanceState");
    }


    void showNotification(String message){

        // Code to create and show notification

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setSmallIcon(R.drawable.folder);
        builder.setContentTitle("LifeCycle: "+message);
        builder.setContentText(message+" is executed !!");

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        code++;
        notificationManager.notify(code,notification);

    }
}
