package com.noodlecake.lib.uikit;

import android.os.Handler;
import android.util.Log;
import com.noodlecake.noodlenews.NoodlecakeGameActivity;
import java.util.ArrayList;
import java.util.Map;

public class UIApplication {
    private static ArrayList<UIApplicationEvent> eventList = new ArrayList<>(10);

    private static native void appDidBecomeActive();

    private static native void appDidEnterBackground();

    private static native void appDidReceiveMemoryWarning();

    private static native void appHandleOpenUrl(String str, String[] strArr, String[] strArr2);

    private static native void appWillEnterForeground();

    private static native void appWillResignActive();

    private static native void appWillTerminate();

    public static void processActivationLifecycleEvents() {
        while (eventList.size() > 0) {
            UIApplicationEventType uIApplicationEventType = eventList.remove(0).type;
            if (uIApplicationEventType == UIApplicationEventType.APP_DID_BECOME_ACTIVE) {
                sendAppDidBecomeActive();
            } else if (uIApplicationEventType == UIApplicationEventType.APP_WILL_ENTER_FOREGROUND) {
                sendAppWillEnterForeground();
            }
        }
    }

    public static void notifyAppDidBecomeActive() {
        Log.d("UIApplication", "notifyAppDidBecomeActive");
        int i = 0;
        while (i < eventList.size()) {
            if (eventList.get(i).type != UIApplicationEventType.APP_DID_BECOME_ACTIVE) {
                i++;
            } else {
                return;
            }
        }
        UIApplicationEvent uIApplicationEvent = new UIApplicationEvent();
        uIApplicationEvent.type = UIApplicationEventType.APP_DID_BECOME_ACTIVE;
        uIApplicationEvent.timestamp = System.currentTimeMillis();
        eventList.add(uIApplicationEvent);
    }

    public static void notifyAppWillEnterForeground() {
        Log.d("UIApplication", "notifyAppWillEnterForeground");
        int i = 0;
        while (i < eventList.size()) {
            if (eventList.get(i).type != UIApplicationEventType.APP_WILL_ENTER_FOREGROUND) {
                i++;
            } else {
                return;
            }
        }
        UIApplicationEvent uIApplicationEvent = new UIApplicationEvent();
        uIApplicationEvent.type = UIApplicationEventType.APP_WILL_ENTER_FOREGROUND;
        uIApplicationEvent.timestamp = System.currentTimeMillis();
        eventList.add(uIApplicationEvent);
    }

    public static void notifyAppWillResignActive() {
        Handler handler = NoodlecakeGameActivity.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (NoodlecakeGameActivity.getContext() != null) {
                        UIApplication.sendAppWillResignActive();
                    }
                }
            });
        }
    }

    public static void notifyAppDidEnterBackground() {
        Handler handler = NoodlecakeGameActivity.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (NoodlecakeGameActivity.getContext() != null) {
                        UIApplication.sendAppDidEnterBackground();
                    }
                }
            });
        }
    }

    public static void notifyAppWillTerminate() {
        Handler handler = NoodlecakeGameActivity.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (NoodlecakeGameActivity.getContext() != null) {
                        UIApplication.sendAppWillTerminate();
                    }
                }
            });
        }
    }

    public static void notifyAppDidReceiveMemoryWarning() {
        Handler handler = NoodlecakeGameActivity.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (NoodlecakeGameActivity.getContext() != null) {
                        UIApplication.sendAppDidReceiveMemoryWarning();
                    }
                }
            });
        }
    }

    public static void notifyHandleOpenUrl(String str, Map<String, String> map) {
        if (NoodlecakeGameActivity.getContext() != null) {
            sendHandleOpenUrl(str, map);
        }
    }

    private static void sendAppDidBecomeActive() {
        Log.d("UIApplication", "sendAppDidBecomeActive");
        appDidBecomeActive();
    }

    /* access modifiers changed from: private */
    public static void sendAppWillResignActive() {
        Log.d("UIApplication", "sendAppWillResignActive");
        appWillResignActive();
    }

    /* access modifiers changed from: private */
    public static void sendAppDidEnterBackground() {
        Log.d("UIApplication", "sendAppDidEnterBackground");
        appDidEnterBackground();
    }

    private static void sendAppWillEnterForeground() {
        Log.d("UIApplication", "sendAppWillEnterForeground");
        appWillEnterForeground();
    }

    /* access modifiers changed from: private */
    public static void sendAppWillTerminate() {
        Log.d("UIApplication", "sendAppWillTerminate");
        appWillTerminate();
    }

    /* access modifiers changed from: private */
    public static void sendAppDidReceiveMemoryWarning() {
        Log.d("UIApplication", "sendAppDidReceiveMemoryWarning");
        appDidReceiveMemoryWarning();
    }

    private static void sendHandleOpenUrl(String str, Map<String, String> map) {
        Log.d("UIApplication", "sendHandleOpenUrl");
        String[] strArr = new String[map.size()];
        String[] strArr2 = new String[map.size()];
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            strArr[i] = (String) next.getKey();
            strArr2[i] = (String) next.getValue();
            i++;
        }
        appHandleOpenUrl(str, strArr, strArr2);
    }
}
