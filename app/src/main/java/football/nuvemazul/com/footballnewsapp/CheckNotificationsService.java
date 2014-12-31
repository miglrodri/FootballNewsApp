package football.nuvemazul.com.footballnewsapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class CheckNotificationsService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Toast(this).makeText(this, "cenas", Toast.LENGTH_SHORT).show();
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
}
