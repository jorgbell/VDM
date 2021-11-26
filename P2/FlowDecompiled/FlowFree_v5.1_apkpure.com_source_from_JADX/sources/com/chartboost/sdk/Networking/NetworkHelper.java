package com.chartboost.sdk.Networking;

import android.util.Log;
import com.chartboost.sdk.Libraries.CBLogging;
import java.net.URL;

public class NetworkHelper {
    private static String debugEndpoint;

    /* renamed from: a */
    public static String m3082a(String str, String str2) {
        String str3 = debugEndpoint;
        if (str3 != null && !str3.isEmpty()) {
            Log.w("Chartboost", "normalizedUrl: " + str + " to: " + debugEndpoint);
            str = debugEndpoint;
        }
        Object[] objArr = new Object[3];
        objArr[0] = str;
        String str4 = "/";
        if (str2 != null && str2.startsWith(str4)) {
            str4 = "";
        }
        objArr[1] = str4;
        if (str2 == null) {
            str2 = "";
        }
        objArr[2] = str2;
        return String.format("%s%s%s", objArr);
    }

    /* renamed from: b */
    public static String m3083b(String str) {
        URL c = m3084c(str);
        if (c == null) {
            return "";
        }
        try {
            return c.getPath();
        } catch (Exception e) {
            CBLogging.m2903a("NetworkHelper", "getPathFromUrl: " + str + " : " + e.toString());
            return "";
        }
    }

    /* renamed from: c */
    public static URL m3084c(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            return new URL(str);
        } catch (Exception e) {
            CBLogging.m2903a("NetworkHelper", "stringToURL: " + str + " : " + e.toString());
            return null;
        }
    }

    private static void setDebugUrl(String str) {
        debugEndpoint = str;
    }

    /* renamed from: a */
    public static String m3081a(String str) {
        URL c = m3084c(str);
        if (c == null) {
            return "";
        }
        try {
            return c.getProtocol() + "://" + c.getHost();
        } catch (Exception e) {
            CBLogging.m2903a("NetworkHelper", "getEndpointFromUrl: " + str + " : " + e.toString());
            return "";
        }
    }
}
