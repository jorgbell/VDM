package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzzy;
import com.mopub.common.Constants;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzy extends zzx {
    static final boolean zzp(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    public final boolean zzo(Activity activity, Configuration configuration) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzcY)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzda)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzzy.zza();
        int zzs = zzbbd.zzs(activity, configuration.screenHeightDp);
        int zzs2 = zzbbd.zzs(activity, configuration.screenWidthDp);
        zzs.zzc();
        DisplayMetrics zzy = zzr.zzy((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zzy.heightPixels;
        int i2 = zzy.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", Constants.ANDROID_PLATFORM);
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d = (double) activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        int round = ((int) Math.round(d + 0.5d)) * ((Integer) zzaaa.zzc().zzb(zzaeq.zzcW)).intValue();
        if (!zzp(i, zzs + dimensionPixelSize, round) || !zzp(i2, zzs2, round)) {
            return true;
        }
        return false;
    }
}
