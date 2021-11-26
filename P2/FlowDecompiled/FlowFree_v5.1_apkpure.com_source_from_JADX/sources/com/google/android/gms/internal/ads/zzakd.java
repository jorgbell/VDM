package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzakd implements zzakp<zzbgf> {
    zzakd() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbgf zzbgf = (zzbgf) obj;
        zzs.zzc();
        DisplayMetrics zzy = zzr.zzy((WindowManager) zzbgf.getContext().getSystemService("window"));
        int i = zzy.widthPixels;
        int i2 = zzy.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzbgf).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        zzbgf.zze("locationReady", hashMap);
        zzbbk.zzi("GET LOCATION COMPILED");
    }
}
