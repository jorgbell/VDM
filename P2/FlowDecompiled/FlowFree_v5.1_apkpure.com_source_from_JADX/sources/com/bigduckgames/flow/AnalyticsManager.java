package com.bigduckgames.flow;

import android.content.Context;
import android.os.Bundle;
import com.flurry.android.FlurryAgent;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsManager {
    private static Map<String, Map<String, String>> eventParameters = new HashMap();

    public static void onStartSession(Context context) {
        FlurryAgent.onStartSession(context);
    }

    public static void onEndSession(Context context) {
        FlurryAgent.onEndSession(context);
    }

    public static void logEvent(Context context, String str) {
        FlurryAgent.logEvent(str);
        logFirebaseEvent(context, str, (Map<String, String>) null);
    }

    public static void logEvent(Context context, String str, Map<String, String> map) {
        FlurryAgent.logEvent(str, map);
        logFirebaseEvent(context, str, map);
    }

    public static void logEventStart(Context context, String str, Map<String, String> map) {
        FlurryAgent.logEvent(str, map, true);
        setEventParams(str, map);
        logFirebaseEvent(context, str + "_begin", map);
    }

    public static void logEventEnd(Context context, String str, Map<String, String> map) {
        FlurryAgent.endTimedEvent(str, map);
        logFirebaseEvent(context, str + "_end", updateEventParams(str, map));
        removeEventParams(str);
    }

    private static Bundle getFirebaseParams(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
            bundle.putString((String) next.getKey(), (String) next.getValue());
        }
        return bundle;
    }

    private static void logFirebaseEvent(Context context, String str, Map<String, String> map) {
        FirebaseAnalytics.getInstance(context).logEvent(str, getFirebaseParams(map));
    }

    private static Map<String, String> getEventParams(String str) {
        if (eventParameters.containsKey(str)) {
            return eventParameters.get(str);
        }
        return null;
    }

    private static Map<String, String> setEventParams(String str, Map<String, String> map) {
        if (eventParameters.containsKey(str)) {
            removeEventParams(str);
        }
        eventParameters.put(str, map);
        return map;
    }

    private static Map<String, String> updateEventParams(String str, Map<String, String> map) {
        if (eventParameters.containsKey(str)) {
            Map<String, String> eventParams = getEventParams(str);
            if (map != null) {
                eventParams.putAll(map);
            }
            eventParameters.put(str, eventParams);
            return eventParams;
        }
        if (map != null) {
            eventParameters.put(str, map);
        }
        return map;
    }

    private static void removeEventParams(String str) {
        if (eventParameters.containsKey(str)) {
            eventParameters.remove(str);
        }
    }
}
