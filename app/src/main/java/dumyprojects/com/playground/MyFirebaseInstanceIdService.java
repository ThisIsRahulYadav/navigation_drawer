package dumyprojects.com.playground;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by lenovo on 10/22/2018.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService{
private static final String REG_TOCKEN="REG_TOCKEN";

    @Override
    public void onTokenRefresh() {
        String recent_Tocken= FirebaseInstanceId.getInstance().getToken();

        Log.e(REG_TOCKEN,recent_Tocken);
    }
}
