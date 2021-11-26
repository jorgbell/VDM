package com.noodlecake.lib;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import com.noodlecake.lib.font.NoodleBitmap;
import com.noodlecake.lib.uikit.DialogMessage;
import com.noodlecake.lib.uikit.UIAccelerometer;
import com.noodlecake.lib.uikit.UIApplication;
import com.noodlecake.lib.uikit.UIDevice;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UIKit {
    private static final int HANDLER_SHOW_DIALOG = 1;
    private static final int HANDLER_SHOW_EXIT_DIALOG = 2;
    private static String TAG = "UIKit";
    private static boolean accelerometerEnabled = false;
    private static UIAccelerometer appAccelerometer;
    public static Activity appActivity;
    public static Context appContext;
    private static UIDevice appDevice;
    public static Handler appHandler;
    /* access modifiers changed from: private */
    public static AppState currentAppState = AppState.STATE_NOT_LAUNCHED;
    /* access modifiers changed from: private */
    public static Runnable lockChecker = null;
    /* access modifiers changed from: private */
    public static final Handler lockHandler = new Handler();
    private static boolean nativeCodeRunning = false;
    private static List<Map<String, String>> pendingUrlOptions = new ArrayList();
    private static List<String> pendingUrls = new ArrayList();

    public enum AppState {
        STATE_NOT_LAUNCHED,
        STATE_BACKGROUND_NOT_FOCUSED,
        STATE_BACKGROUND_FOCUSED,
        STATE_FOREGROUND_NOT_FOCUSED,
        STATE_FOREGROUND_FOCUSED,
        STATE_FOREGROUND_FOCUSED_UNLOCKED
    }

    public static void init(Activity activity) {
        appActivity = activity;
        appContext = activity;
        appAccelerometer = new UIAccelerometer(activity);
        appDevice = new UIDevice(activity);
        NoodleBitmap.setContext(activity);
        appHandler = new Handler() {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Object obj = message.obj;
                    DialogMessage.showDialog(((DialogMessage) obj).title, ((DialogMessage) obj).message);
                } else if (i == 2) {
                    Object obj2 = message.obj;
                    DialogMessage.showExitDialog(((DialogMessage) obj2).title, ((DialogMessage) obj2).message);
                }
            }
        };
        lockChecker = new Runnable() {
            public void run() {
                AppState access$000 = UIKit.currentAppState;
                AppState appState = AppState.STATE_FOREGROUND_FOCUSED;
                if (access$000 == appState && !UIKit.isDeviceLocked()) {
                    UIKit.switchToState(AppState.STATE_FOREGROUND_FOCUSED_UNLOCKED);
                } else if (UIKit.currentAppState == appState) {
                    UIKit.lockHandler.postDelayed(UIKit.lockChecker, 250);
                }
            }
        };
        String str = TAG;
        Log.d(str, "init - currentAppState = " + currentAppState.name());
    }

    public static boolean isDeviceLocked() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("Amazon") || !Build.MODEL.equalsIgnoreCase("Kindle Fire")) {
            return ((KeyguardManager) appActivity.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        }
        Log.d(TAG, "isDeviceLocked - AMAZON DEVICE -- RETURNING FALSE");
        return false;
    }

    /* renamed from: com.noodlecake.lib.UIKit$3 */
    static /* synthetic */ class C27153 {
        static final /* synthetic */ int[] $SwitchMap$com$noodlecake$lib$UIKit$AppState;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.noodlecake.lib.UIKit$AppState[] r0 = com.noodlecake.lib.UIKit.AppState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$noodlecake$lib$UIKit$AppState = r0
                com.noodlecake.lib.UIKit$AppState r1 = com.noodlecake.lib.UIKit.AppState.STATE_FOREGROUND_FOCUSED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$noodlecake$lib$UIKit$AppState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.noodlecake.lib.UIKit$AppState r1 = com.noodlecake.lib.UIKit.AppState.STATE_FOREGROUND_FOCUSED_UNLOCKED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$noodlecake$lib$UIKit$AppState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.noodlecake.lib.UIKit$AppState r1 = com.noodlecake.lib.UIKit.AppState.STATE_BACKGROUND_NOT_FOCUSED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$noodlecake$lib$UIKit$AppState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.noodlecake.lib.UIKit$AppState r1 = com.noodlecake.lib.UIKit.AppState.STATE_BACKGROUND_FOCUSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$noodlecake$lib$UIKit$AppState     // Catch:{ NoSuchFieldError -> 0x003e }
                com.noodlecake.lib.UIKit$AppState r1 = com.noodlecake.lib.UIKit.AppState.STATE_NOT_LAUNCHED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$noodlecake$lib$UIKit$AppState     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.noodlecake.lib.UIKit$AppState r1 = com.noodlecake.lib.UIKit.AppState.STATE_FOREGROUND_NOT_FOCUSED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.noodlecake.lib.UIKit.C27153.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static void switchToState(AppState appState) {
        int i = C27153.$SwitchMap$com$noodlecake$lib$UIKit$AppState[appState.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if ((i == 3 || i == 4) && nativeCodeRunning) {
                    onPauseReally();
                }
            } else if (!nativeCodeRunning) {
                onResumeReally();
            }
        } else if (AppState.STATE_FOREGROUND_FOCUSED != currentAppState) {
            Handler handler = lockHandler;
            handler.removeCallbacks(lockChecker);
            handler.postDelayed(lockChecker, 250);
        }
        currentAppState = appState;
    }

    public static void onWindowFocusChanged(boolean z) {
        String str = z ? "HAS FOCUS" : "LOST FOCUS";
        String str2 = TAG;
        Log.d(str2, "Focus change: " + str);
        if (!z) {
            switch (C27153.$SwitchMap$com$noodlecake$lib$UIKit$AppState[currentAppState.ordinal()]) {
                case 1:
                case 2:
                    switchToState(AppState.STATE_FOREGROUND_NOT_FOCUSED);
                    break;
                case 3:
                case 5:
                case 6:
                    switchToState(currentAppState);
                    break;
                case 4:
                    switchToState(AppState.STATE_BACKGROUND_NOT_FOCUSED);
                    break;
            }
        } else {
            switch (C27153.$SwitchMap$com$noodlecake$lib$UIKit$AppState[currentAppState.ordinal()]) {
                case 1:
                case 2:
                case 4:
                    switchToState(currentAppState);
                    break;
                case 3:
                case 5:
                    switchToState(AppState.STATE_BACKGROUND_FOCUSED);
                    break;
                case 6:
                    switchToState(AppState.STATE_FOREGROUND_FOCUSED);
                    break;
            }
        }
        String str3 = TAG;
        Log.d(str3, "onWindowFocusChanged - currentAppState = " + currentAppState.name());
    }

    public static void onResume() {
        Log.d(TAG, "UIKit Resume");
        switch (C27153.$SwitchMap$com$noodlecake$lib$UIKit$AppState[currentAppState.ordinal()]) {
            case 1:
            case 2:
            case 6:
                switchToState(currentAppState);
                break;
            case 3:
            case 5:
                switchToState(AppState.STATE_FOREGROUND_NOT_FOCUSED);
                break;
            case 4:
                switchToState(AppState.STATE_FOREGROUND_FOCUSED);
                break;
        }
        String str = TAG;
        Log.d(str, "onResume - currentAppState = " + currentAppState.name());
    }

    public static void onPause() {
        Log.d(TAG, "UIKit Pause");
        switch (C27153.$SwitchMap$com$noodlecake$lib$UIKit$AppState[currentAppState.ordinal()]) {
            case 1:
            case 2:
                switchToState(AppState.STATE_BACKGROUND_FOCUSED);
                break;
            case 3:
            case 4:
            case 5:
                switchToState(currentAppState);
                break;
            case 6:
                switchToState(AppState.STATE_BACKGROUND_NOT_FOCUSED);
                break;
        }
        String str = TAG;
        Log.d(str, "onPause - currentAppState = " + currentAppState.name());
    }

    private static void onPauseReally() {
        Log.d(TAG, "onPauseReally -- NOTIFYING APP WILL RESIGN ACTIVE/DID ENTER BACKGROUND");
        UIApplication.notifyAppWillResignActive();
        UIApplication.notifyAppDidEnterBackground();
        if (accelerometerEnabled) {
            appAccelerometer.disable();
        }
        nativeCodeRunning = false;
        pendingUrls.clear();
        pendingUrlOptions.clear();
    }

    private static void onResumeReally() {
        Log.d(TAG, "onResumeReally -- NOTIFYING APP WILL ENTER FOREGROUND/DID BECOME ACTIVE");
        if (accelerometerEnabled) {
            appAccelerometer.enable();
        }
        UIApplication.notifyAppWillEnterForeground();
        UIApplication.notifyAppDidBecomeActive();
        nativeCodeRunning = true;
    }

    public static void handlePendingUrls() {
        if (!pendingUrls.isEmpty()) {
            for (int i = 0; i < pendingUrls.size(); i++) {
                Log.d(TAG, "passing URL to running application");
                UIApplication.notifyHandleOpenUrl(pendingUrls.get(i), pendingUrlOptions.get(i));
            }
            pendingUrls.clear();
            pendingUrlOptions.clear();
        }
    }

    public static void onLowMemory() {
        int i = C27153.$SwitchMap$com$noodlecake$lib$UIKit$AppState[currentAppState.ordinal()];
        if (i != 3 && i != 4 && i != 5) {
            UIApplication.notifyAppDidReceiveMemoryWarning();
        }
    }

    public static void onConfigurationChanged(Configuration configuration) {
        appDevice.onConfigurationChanged(configuration);
    }

    public static void onStart() {
        dealWithIntent(appActivity.getIntent());
    }

    public static void onNewIntent() {
        dealWithIntent(appActivity.getIntent());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void dealWithIntent(android.content.Intent r5) {
        /*
            java.lang.String r0 = r5.getDataString()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.os.Bundle r2 = r5.getExtras()
            if (r2 == 0) goto L_0x0047
            android.os.Bundle r2 = r5.getExtras()
            java.lang.String r3 = "id"
            boolean r2 = r2.containsKey(r3)
            java.lang.String r4 = "notifId"
            if (r2 == 0) goto L_0x002b
            android.os.Bundle r2 = r5.getExtras()
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            r1.put(r4, r2)
            goto L_0x0030
        L_0x002b:
            java.lang.String r2 = "0"
            r1.put(r4, r2)
        L_0x0030:
            android.os.Bundle r2 = r5.getExtras()
            java.lang.String r3 = "link"
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x0047
            android.os.Bundle r5 = r5.getExtras()
            java.lang.Object r5 = r5.get(r3)
            r0 = r5
            java.lang.String r0 = (java.lang.String) r0
        L_0x0047:
            if (r0 == 0) goto L_0x0063
            java.lang.String r5 = ""
            int r5 = r5.compareTo(r0)
            if (r5 == 0) goto L_0x0063
            boolean r5 = nativeCodeRunning
            if (r5 != 0) goto L_0x0060
            java.util.List<java.lang.String> r5 = pendingUrls
            r5.add(r0)
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r5 = pendingUrlOptions
            r5.add(r1)
            goto L_0x0063
        L_0x0060:
            com.noodlecake.lib.uikit.UIApplication.notifyHandleOpenUrl(r0, r1)
        L_0x0063:
            android.app.Activity r5 = appActivity
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)
            r5.setIntent(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.noodlecake.lib.UIKit.dealWithIntent(android.content.Intent):void");
    }

    public static void enableAccelerometer() {
        accelerometerEnabled = true;
        appAccelerometer.enable();
    }

    public static void disableAccelerometer() {
        accelerometerEnabled = false;
        appAccelerometer.disable();
    }

    public static boolean isTablet() {
        try {
            DisplayMetrics displayMetrics = appContext.getResources().getDisplayMetrics();
            if (Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 7.0d) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int convertDpToPx(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, appContext.getResources().getDisplayMetrics());
    }

    public static int convertPxToDp(int i) {
        if (i == 0) {
            return 0;
        }
        return Math.round(((float) i) / (((float) appContext.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }
}
