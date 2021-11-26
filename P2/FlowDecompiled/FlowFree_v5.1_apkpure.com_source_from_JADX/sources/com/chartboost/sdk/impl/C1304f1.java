package com.chartboost.sdk.impl;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.chartboost.sdk.Libraries.CBLogging;

/* renamed from: com.chartboost.sdk.impl.f1 */
public class C1304f1 {
    /* renamed from: b */
    private TelephonyManager m3439b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return (TelephonyManager) context.getSystemService("phone");
        } catch (Exception e) {
            CBLogging.m2905b("CarrierBuilder", "Unable to retrieve TELEPHONY_SERVICE " + e.toString());
            return null;
        }
    }

    /* renamed from: c */
    private boolean m3440c(Context context) {
        return context != null && ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == -1;
    }

    /* renamed from: a */
    public C1301e1 mo10411a(Context context) {
        String str;
        String str2;
        if (m3440c(context)) {
            CBLogging.m2903a("CarrierBuilder", "Permission READ_PHONE_STATE not granted");
            return null;
        }
        TelephonyManager b = m3439b(context);
        if (!m3438a(b)) {
            return null;
        }
        String simOperator = b.getSimOperator();
        if (!TextUtils.isEmpty(simOperator)) {
            str2 = simOperator.substring(0, 3);
            str = simOperator.substring(3);
        } else {
            str2 = null;
            str = null;
        }
        return new C1301e1(simOperator, str2, str, b.getNetworkOperatorName(), b.getNetworkCountryIso(), b.getPhoneType());
    }

    /* renamed from: a */
    private boolean m3438a(TelephonyManager telephonyManager) {
        return (telephonyManager == null || telephonyManager.getPhoneType() == 0 || telephonyManager.getSimState() != 5) ? false : true;
    }
}
