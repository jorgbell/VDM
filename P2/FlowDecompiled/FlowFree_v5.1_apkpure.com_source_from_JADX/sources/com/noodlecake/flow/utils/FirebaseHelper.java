package com.noodlecake.flow.utils;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.util.HashMap;
import java.util.Map;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.json.JSONObject;

public class FirebaseHelper {
    private static FirebaseAnalytics analytics;
    private static FirebaseRemoteConfig remoteConfig;
    /* access modifiers changed from: private */
    public static String token;

    private static native void handleUpdateRemoteConfigData(String str);

    public static void init(FirebaseAnalytics firebaseAnalytics) {
        analytics = firebaseAnalytics;
        remoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings.Builder builder = new FirebaseRemoteConfigSettings.Builder();
        builder.setMinimumFetchIntervalInSeconds(60);
        remoteConfig.setConfigSettingsAsync(builder.build());
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            public void onComplete(Task<InstanceIdResult> task) {
                if (task.isSuccessful()) {
                    String unused = FirebaseHelper.token = task.getResult().getToken();
                    "InstanceID Token: " + FirebaseHelper.token;
                }
            }
        });
    }

    public static void logEvent(String str, String[] strArr, String[] strArr2) {
        if (strArr.length == strArr2.length) {
            Bundle bundle = new Bundle();
            for (int i = 0; i < strArr.length; i++) {
                bundle.putString(strArr[i], strArr2[i]);
            }
            analytics.logEvent(str, bundle);
        }
    }

    public static void setUserProperty(String str, String str2) {
        analytics.setUserProperty(str, str2);
    }

    public static void fetchRemoteConfigData() {
        remoteConfig.fetchAndActivate().addOnCompleteListener(new RemoteConfigListener());
    }

    public static void shareToken() {
        Cocos2dxActivity.shareDialog("Firebase Token", token, "FIR Token");
    }

    private static class RemoteConfigListener implements OnCompleteListener<Boolean> {
        private RemoteConfigListener() {
        }

        public void onComplete(Task<Boolean> task) {
            FirebaseHelper.updateRemoteConfigData();
        }
    }

    protected static void updateRemoteConfigData() {
        Map<String, FirebaseRemoteConfigValue> all = remoteConfig.getAll();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : all.entrySet()) {
            hashMap.put(next.getKey(), ((FirebaseRemoteConfigValue) next.getValue()).asString());
        }
        JSONObject jSONObject = new JSONObject(hashMap);
        Log.d("FirebaseHelper", String.format("Remote Config JSON: %s", new Object[]{jSONObject.toString()}));
        handleUpdateRemoteConfigData(jSONObject.toString());
    }

    public static void onNewToken(String str) {
        token = str;
    }
}
