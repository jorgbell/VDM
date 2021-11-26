package com.chartboost.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1236h;
import com.chartboost.sdk.impl.C1406x;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.c */
public final class C1274c {
    /* renamed from: a */
    static void m3269a(String str) {
        if (C1418k.f3535e == null) {
            CBLogging.m2905b("CBConfig", "Set a valid CBFramework first");
        } else if (TextUtils.isEmpty(str)) {
            CBLogging.m2905b("CBConfig", "Invalid Version String");
        } else {
            C1418k.f3533c = str;
        }
    }

    /* renamed from: b */
    private static boolean m3273b() {
        return C1414j.m3867b() != null;
    }

    /* renamed from: c */
    public static boolean m3275c() {
        return m3270a() && m3273b();
    }

    /* renamed from: b */
    public static boolean m3274b(Context context) {
        int i;
        int i2;
        if (context != null) {
            try {
                if (C1406x.m3823b().mo10695a(23)) {
                    i2 = context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE");
                    i = context.checkSelfPermission("android.permission.INTERNET");
                } else {
                    i2 = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
                    i = context.checkCallingOrSelfPermission("android.permission.INTERNET");
                }
                C1418k.f3542l = i != 0;
                C1418k.f3543m = i2 != 0;
                if (C1418k.f3542l) {
                    throw new RuntimeException("Please add the permission : android.permission.INTERNET in your android manifest.xml");
                } else if (!C1418k.f3543m) {
                    return true;
                } else {
                    throw new RuntimeException("Please add the permission : android.permission.ACCESS_NETWORK_STATE in your android manifest.xml");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            throw new RuntimeException("Invalid activity context passed during intitalization");
        }
    }

    /* renamed from: a */
    public static boolean m3272a(AtomicReference<C1236h> atomicReference, JSONObject jSONObject) {
        try {
            atomicReference.set(new C1236h(jSONObject));
            return true;
        } catch (Exception e) {
            CBLogging.m2905b("CBConfig", "updateConfig: " + e.toString());
            return false;
        }
    }

    /* renamed from: a */
    static boolean m3270a() {
        try {
            if (C1414j.m3867b() == null) {
                throw new Exception("SDK Initialization error. SDK seems to be not initialized properly, check for any integration issues");
            } else if (TextUtils.isEmpty(C1418k.f3540j)) {
                throw new Exception("SDK Initialization error. AppId is missing");
            } else if (!TextUtils.isEmpty(C1418k.f3541k)) {
                return true;
            } else {
                throw new Exception("SDK Initialization error. AppSignature is missing");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m3271a(Context context) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent(context, CBImpressionActivity.class), 0);
        if (queryIntentActivities.isEmpty()) {
            return false;
        }
        ActivityInfo activityInfo = queryIntentActivities.get(0).activityInfo;
        int i = activityInfo.flags;
        if ((i & 512) == 0 || (i & 32) == 0) {
            return false;
        }
        int i2 = activityInfo.configChanges;
        if ((i2 & 128) == 0 || (i2 & 32) == 0 || (i2 & 1024) == 0) {
            return false;
        }
        return true;
    }
}
