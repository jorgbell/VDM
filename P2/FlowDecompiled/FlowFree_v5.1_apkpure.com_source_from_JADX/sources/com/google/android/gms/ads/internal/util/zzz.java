package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzvy;

@TargetApi(26)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzz extends zzy {
    public final zzvy zzq(Context context, TelephonyManager telephonyManager) {
        zzs.zzc();
        if (zzr.zzD(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzvy.ENUM_TRUE : zzvy.ENUM_FALSE;
        }
        return zzvy.ENUM_FALSE;
    }
}
