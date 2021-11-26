package com.noodlecake.flow;

import android.os.Bundle;
import android.util.Log;
import com.bigduckgames.flow.AnalyticsManager;
import com.bigduckgames.flow.CrashReportManager;
import com.bigduckgames.flow.FlowNotificationManager;
import com.bigduckgames.flow.R;
import com.flurry.android.FlurryAgent;
import com.noodlecake.ads.InterstitialController;
import com.noodlecake.flow.config.FlowConfig;
import com.noodlecake.noodlenews.NoodleGameServices;
import com.noodlecake.noodlenews.NoodlecakeGameActivity;
import gnustep.foundation.Common;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.noodlecake.flow.flow */
public class C2702flow extends NoodlecakeGameActivity {
    private static NewAdsSurface adsSurface;
    private static C2702flow air;
    private static final byte[] google_bytes_bridges_value;
    private static final byte[] google_bytes_flow_value;
    private static final byte[] google_bytes_hexes_value = {43, 35, 34, 38, 58, 12, 9, 10, 40, 12, 15, 54, 63, 35, 46, 52, 85, 68, 4, 113, 117, 53, 54, 32, 37, 114, 123, 112, 115, 104, 74, 117, 5, 3, 14, 4, 5, 85, 120, 113, 119, 102, 15, 9, 36, 34, 87, 50, 2, 60, 0, 19, 60, 29, 12, 58, 87, 12, 15, 50, 40, 90, 104, 126, 2, 124, 0, 68, 11, 6, 6, 80, 19, 62, 92, 4, 48, 80, 105, 4, 79, 78, Byte.MAX_VALUE, 91, 28, 87, 36, 115, 18, 47, 8, 14, 86, 48, 92, 50, 98, 64, 63, 94, 13, 44, 11, 37, Byte.MAX_VALUE, 23, 0, 49, 37, 19, 31, 10, 22, 65, 21, 95, 99, 70, 66, 46, 18, 47, 75, 3, 5, 98, 104, 8, 75, 124, 39, 25, 41, 42, 42, 95, 75, 68, 6, 64, 61, 49, 33, 8, 47, 15, 65, 45, 70, 118, 99, 43, 2, 25, 48, 63, 20, 32, 63, 33, 118, 92, 81, 68, 6, 23, 17, 3, 90, 82, 18, 85, 88, 25, 17, 33, 73, 94, 0, 12, 76, 65, 48, 36, Byte.MAX_VALUE, 33, 14, 32, 48, 5, 12, 33, 1, 16, 65, 87, 18, 56, 7, 54, 10, 48, 50, 51, 0, 40, 14, 116, 21, 56, Byte.MAX_VALUE, 29, 71, 6, 86, 64, 120, 18, 43, 46, 20, 4, 5, 123, 120, 119, 49, 3, 6, 15, 12, 2, 36, 90, 28, 97, 79, 98, 56, 56, 15, 82, 20, 54, 28, 19, 66, 12, 62, 106, 77, 49, 47, 31, 37, 76, 48, 26, 93, 70, 115, 99, 38, 58, 16, 62, 13, 55, 4, 48, 3, 88, 28, 39, 107, 92, 67, 9, 116, 94, 20, 14, 5, 33, 37, 116, 15, 88, 13, 81, 9, 61, 71, 119, 62, 62, 26, 82, 21, 80, 47, 43, 1, 17, 5, 46, 51, 30, 32, 17, 59, 120, 68, 2, 100, 55, 36, 95, 75, 64, 2, 120, 6, 81, 74, 1, 28, 7, 48, 37, 49, 65, 94, 96, 78, 24, 3, 0, 33, 54, 7, 44, 33, 36, 97, 107, 41, 98, 37, 60, 47, 83, 19, 51, 48, 88, 118, 86, 1, 116, 8, 92, 53, 10, 51, 5, 37, 51, 17, 67, 9, 49, 6, 83, 4, 81, 83, 98, 84, 62, 5, 17, 31, 19, 34, 38, 47, 35, 41, 57, 114, 122};
    private static final byte[] google_bytes_warps_value = {43, 35, 34, 38, 58, 12, 9, 10, 40, 12, 15, 54, 63, 35, 46, 52, 85, 68, 4, 113, 117, 53, 54, 32, 37, 114, 123, 112, 115, 104, 74, 117, 5, 3, 14, 4, 5, 85, 120, 113, 119, 102, 15, 9, 35, 30, 33, 17, 66, 54, 98, 5, 57, 8, 80, 55, 17, 15, 7, 55, 72, 38, 100, 74, Byte.MAX_VALUE, 71, 7, 34, 19, 14, 43, 49, 88, 62, 44, 38, 31, 35, 119, 100, 4, 1, 87, 15, 45, 18, 11, 118, 55, 21, 112, 30, 45, 40, 67, 15, 74, 66, 94, 44, 7, 87, 63, 80, 14, 116, 83, 33, 82, 4, 103, 62, 19, 56, 88, 69, 117, 71, 120, 16, 63, 0, 48, 1, 89, 81, 1, 88, 63, 126, 56, 97, 45, 3, 118, 96, 92, 4, 70, 85, 43, 125, 6, 12, 46, 83, 5, 18, 69, 51, 1, 101, 15, 69, 12, 11, 31, 17, 85, 90, 101, 93, 124, 84, 39, 21, 33, 37, 12, 21, 31, 17, 51, 39, 89, 1, 94, 71, 64, 0, 85, 122, 60, 32, 46, 63, 117, 28, 2, 6, 87, 62, 89, 41, 105, 64, 5, 91, 90, 12, 0, 17, 24, 17, 24, 18, 50, 119, 100, 13, 36, 75, 67, 0, 121, 91, Byte.MAX_VALUE, 20, 29, 81, 86, 120, 101, 93, 71, 107, 28, 68, 99, 1, 63, 17, 105, 121, 94, 75, 5, 66, 35, 38, 11, 23, 10, 53, 1, 33, 1, 11, 52, 102, 36, 68, 82, 27, 60, 42, 36, 3, 112, 74, 83, 81, 39, 57, 17, 29, 46, 18, 44, 16, 40, 41, 63, 21, 69, 67, 92, 95, 98, 117, 34, 60, 24, 51, 23, 115, 39, 14, 4, 50, 88, 56, 87, 80, 14, 62, 35, 44, 59, 2, 16, 107, 39, 41, 51, 36, 22, 120, 30, 32, 52, 99, 70, 97, 113, 61, 11, 47, 35, 64, 112, Byte.MAX_VALUE, 75, 119, 1, 124, Byte.MAX_VALUE, 24, 30, 115, 36, 102, 67, 104, 0, 0, 32, 36, 41, 47, 86, 17, 41, 21, 7, 14, 104, 59, 37, 7, 9, 14, 73, 51, 80, 49, 116, 100, 125, 103, 32, 54, 39, 37, 94, 14, 18, 46, 46, 52, 4, 3, 86, 86, 71, Byte.MAX_VALUE, 84, 7, 55, 82, 125, 62, 61, 51, 34, 0, 47, 35, 41, 57, 114, 122};
    private static NoodleGameServices noodleGameServices;
    private static String versionName;

    static {
        byte[] bArr = {43, 35, 34, 38, 58, 12, 9, 10, 40, 12, 15, 54, 63, 35, 46, 52, 85, 68, 4, 113, 117, 53, 54, 32, 37, 114, 123, 112, 115, 104, 74, 117, 5, 3, 14, 4, 5, 85, 120, 113, 119, 102, 15, 9, 48, 12, 81, 73, 75, 4, 97, 40, 55, 38, 87, 55, 47, 14, 7, 38, 18, 35, 69, 102, 115, 103, 7, 49, 14, 47, 36, 44, 2, 33, 58, 8, 2, 22, 70, 71, 125, 115, 98, 28, 1, 54, 38, 63, 22, 38, 2, 24, 18, 85, 1, 35, 65, 113, 3, 34, 25, 52, 35, 30, 39, 62, 38, 59, 83, 8, 103, 113, 6, 60, 5, 66, 7, 118, 99, 87, 37, 11, 11, 85, 64, 68, 125, 120, 33, 69, 5, 16, 9, 4, 15, 97, 4, 89, 69, 121, 122, 126, 27, 82, 1, 85, 21, 63, 4, 10, 98, 34, 51, 52, 52, 95, 51, 49, 8, 15, 92, 102, 102, 124, 54, 23, 73, 43, 43, 62, 45, 82, 58, 1, 3, 2, 92, 91, 80, 0, 2, 1, 84, 3, 27, 16, 13, 107, 52, 2, 0, 0, 45, 58, 117, 98, 37, 90, 42, 47, 28, 53, 123, 117, 28, 95, 45, 112, 32, 36, 36, 39, 3, 67, 97, 126, 82, 44, 88, 81, 62, 99, 27, 87, 70, 1, 74, 27, 48, 32, 117, 55, 36, 65, 92, 7, 79, 123, 41, 113, 63, 52, 48, 39, 64, 30, 101, 48, 43, 49, 5, 59, 46, 50, 12, 2, 18, 90, 26, 68, 5, 0, 45, 49, 37, 43, 89, 62, 94, 19, 42, 11, 2, 2, 99, 80, 113, 14, 83, 69, 11, 73, 47, 19, 61, 61, 115, 0, 23, 54, 94, 56, 105, 125, 22, 65, 12, 7, 21, 77, 2, 42, 11, 28, 38, 13, 29, 49, 54, 88, 34, 82, 126, 98, 98, 12, 55, 45, 29, 119, 0, 0, 92, 14, 62, 126, 16, 56, 51, 109, 14, 94, 94, 112, 0, 69, 114, 126, 24, 11, 22, 84, 88, 17, 112, 6, 40, 1, 34, 0, 86, 24, 47, 38, 6, 50, 100, 99, 71, 92, 37, 20, 7, 16, 8, 5, 88, 82, 47, 71, 5, 83, 94, Byte.MAX_VALUE, 101, 106, 114, 99, 60, 42, 27, 9, 35, 13, 18, 0, 47, 35, 41, 57, 114, 122};
        google_bytes_flow_value = bArr;
        google_bytes_bridges_value = bArr;
        Log.v("flow", "static load libs start");
        System.loadLibrary("c++_shared");
        System.loadLibrary("objc");
        System.loadLibrary("foundation");
        System.loadLibrary("dispatch");
        System.loadLibrary("coregraphics");
        System.loadLibrary("quartzcore");
        System.loadLibrary("uikit");
        System.loadLibrary("cocos2d");
        System.loadLibrary("noodle");
        System.loadLibrary("storekit");
        System.loadLibrary("ogg");
        System.loadLibrary("vorbis");
        System.loadLibrary("openal");
        System.loadLibrary("cocosdenshion_al");
        System.loadLibrary("game");
        Log.v("flow", "static load libs finished");
    }

    public C2702flow() {
        super(true, true, true);
        Log.v("flow", "construct");
        if (FlowConfig.isBridges) {
            NoodlecakeGameActivity.google_bytes = google_bytes_bridges_value;
        } else if (FlowConfig.isHexes) {
            NoodlecakeGameActivity.google_bytes = google_bytes_hexes_value;
        } else if (FlowConfig.isWarps) {
            NoodlecakeGameActivity.google_bytes = google_bytes_warps_value;
        } else {
            NoodlecakeGameActivity.google_bytes = google_bytes_flow_value;
        }
        adsSurface = new NewAdsSurface(this);
    }

    private void initFlurry() {
        String str;
        if (FlowConfig.isBridges) {
            str = "N8SMFMB4J72NK7VS5FDJ";
        } else if (FlowConfig.isHexes) {
            str = "VDJ6CTQ5XXF5RB2T4TW9";
        } else {
            str = FlowConfig.isWarps ? "PFMYM34879QH78FJDQSG" : "THHC25KCM852393KJ897";
        }
        Log.v("flow", "Initializing Flurry (" + str + ")");
        FlurryAgent.setReportLocation(false);
        new FlurryAgent.Builder().withContinueSessionMillis(30000).withLogEnabled(false).build(this, str);
    }

    public void onStart() {
        super.onStart();
        Log.v("flow", "onStart");
        Log.v("flow", "Starting Flurry Session");
        AnalyticsManager.onStartSession(this);
        AnalyticsManager.logEvent(this, "session_play");
        InterstitialController.onStart();
        FlowNotificationManager.onStart(this);
    }

    public void onRestart() {
        super.onRestart();
        Log.v("flow", "onRestart");
        InterstitialController.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        Log.v("flow", "onStop");
        InterstitialController.onStop();
        AnalyticsManager.onEndSession(this);
    }

    public void onPause() {
        super.onPause();
        Log.v("flow", "onPause");
        NoodleGameServices noodleGameServices2 = noodleGameServices;
        if (noodleGameServices2 != null) {
            noodleGameServices2.release();
        }
        InterstitialController.onPause();
        adsSurface.onPause();
    }

    public void onResume() {
        super.onResume();
        Log.v("flow", "onResume");
        NoodleGameServices noodleGameServices2 = noodleGameServices;
        if (noodleGameServices2 != null) {
            noodleGameServices2.initialize(this);
        }
        InterstitialController.onResume();
        adsSurface.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
        Log.v("flow", "onDestroy");
        InterstitialController.onDestroy();
        adsSurface.onDestroy();
    }

    public void onBackPressed() {
        if (!InterstitialController.onBackPressed()) {
            super.onBackPressed();
        }
    }

    private static void logBuildInfo() {
        boolean z = true;
        boolean z2 = NoodlecakeGameActivity.getPlatform() != 0;
        if (!z2) {
            z = false;
        }
        Log.i("flow", "Package Name: " + air.getPackageName());
        StringBuilder sb = new StringBuilder();
        sb.append("Build Version: ");
        sb.append(FlowConfig.getProductLogString() + " - " + FlowConfig.getDistroLogString() + " v" + versionName);
        sb.append(" (");
        sb.append(z ? "Debug" : "Release");
        sb.append(")");
        Log.i("flow", sb.toString());
        if (z) {
            Log.i("flow", "Build Version: Debug (config=0, build=0)");
            if (z2) {
                Log.i("flow", "Build Version: Mismatched Java and native config (Java=0, Native=" + NoodlecakeGameActivity.getPlatform() + ")");
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle, R.layout.game_demo, R.id.game_gl_surfaceview, R.id.textField);
        Log.v("flow", "onCreate");
        initFlurry();
        CrashReportManager.setCustomKey("Ads", adsSurface.getIsShowingAds());
        CrashReportManager.setCustomKey("Ads_State", adsSurface.getIsShowingAds() ? "ads_enabled" : "ads_disabled");
        CrashReportManager.setCustomKey("Store", "store_" + FlowConfig.getDistroLogString().toLowerCase(Locale.US));
        air = this;
        versionName = Common.getVersionName();
        logBuildInfo();
        noodleGameServices = new NoodleGameServices(this);
        adsSurface.onCreate(this);
        initInterstitials();
    }

    private static void initInterstitials() {
        boolean willDipsFitScreen = adsSurface.willDipsFitScreen(768, 1024);
        HashMap hashMap = new HashMap();
        NewAdsSurface newAdsSurface = adsSurface;
        hashMap.put("Boot", willDipsFitScreen ? newAdsSurface.getMoPubBootTabletID() : newAdsSurface.getMoPubBootPhoneID());
        NewAdsSurface newAdsSurface2 = adsSurface;
        hashMap.put("Break", willDipsFitScreen ? newAdsSurface2.getMoPubBreakTabletID() : newAdsSurface2.getMoPubBreakPhoneID());
        InterstitialController.init(air, false, hashMap, willDipsFitScreen ? adsSurface.getMoPubRewardedTabletID() : adsSurface.getMoPubRewardedPhoneID(), adsSurface.getMoPubKeywords());
        InterstitialController.onCreate();
    }

    public static String getVersionName() {
        return versionName;
    }
}
