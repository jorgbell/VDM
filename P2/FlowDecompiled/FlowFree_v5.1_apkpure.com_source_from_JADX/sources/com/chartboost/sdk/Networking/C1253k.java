package com.chartboost.sdk.Networking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.chartboost.sdk.Libraries.CBLogging;

/* renamed from: com.chartboost.sdk.Networking.k */
public class C1253k {
    /* renamed from: a */
    private int m3109a(int i, int i2) {
        if (i == 1) {
            return 2;
        }
        if (i != 0) {
            return 0;
        }
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 5;
            case 13:
                return 6;
            default:
                return 3;
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public NetworkInfo mo10161a(Context context) {
        ConnectivityManager c;
        if (context == null || (c = mo10163c(context)) == null) {
            return null;
        }
        try {
            return c.getActiveNetworkInfo();
        } catch (Exception e) {
            CBLogging.m2903a("Chartboost", "Cannot retrieve active network info: " + e.toString());
            return null;
        }
    }

    /* renamed from: b */
    public int mo10162b(Context context) {
        NetworkInfo a = mo10161a(context);
        if (a == null || !a.isConnected()) {
            return 0;
        }
        return a.getSubtype();
    }

    /* renamed from: c */
    public ConnectivityManager mo10163c(Context context) {
        if (context != null) {
            try {
                return (ConnectivityManager) context.getSystemService("connectivity");
            } catch (Exception e) {
                CBLogging.m2903a("Chartboost", "Cannot retrieve connectivity manager: " + e.toString());
            }
        }
        return null;
    }

    /* renamed from: d */
    public int mo10164d(Context context) {
        NetworkInfo a = mo10161a(context);
        if (a == null || !a.isConnected()) {
            return 0;
        }
        return m3109a(a.getType(), a.getSubtype());
    }

    /* renamed from: e */
    public boolean mo10165e(Context context) {
        NetworkInfo a = mo10161a(context);
        return a != null && a.isConnected();
    }
}
