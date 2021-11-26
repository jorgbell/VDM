package com.bigduckgames.flow;

import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.noodlecake.flow.utils.FirebaseHelper;

public class FlowFirebaseMessagingService extends FirebaseMessagingService {
    public void onNewToken(String str) {
        Log.d("FlowFCMService", "Refreshed token: " + str);
        FirebaseHelper.onNewToken(str);
    }
}
