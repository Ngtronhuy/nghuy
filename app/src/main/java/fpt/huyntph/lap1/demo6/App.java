package fpt.huyntph.lap1.demo6;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CHANNEL_ID = "CHANNELL_ID";
    public void onCreate() {

        super.onCreate();
        createNotifucationChannel();
    }
    public  void createNotifucationChannel(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.DONUT){
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "CHANNEL_ID",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("THÔNG BÁO --------");
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager!=null){
    manager.createNotificationChannel(channel);
            }
        }
    }
}
