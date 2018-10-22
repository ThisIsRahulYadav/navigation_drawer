package dumyprojects.com.playground;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by lenovo on 10/22/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivities(this,0, new Intent[]{intent},PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificationBuildert=new NotificationCompat.Builder(this);
        notificationBuildert.setContentTitle("FCM NOTTIFICATION");
        notificationBuildert.setContentText(remoteMessage.getNotification().getBody());
         notificationBuildert.setAutoCancel(true);
         notificationBuildert.setSmallIcon(R.mipmap.ic_launcher);
         notificationBuildert.setContentIntent(pendingIntent);
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuildert.build());
    }
}
