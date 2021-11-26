package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzak;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzi extends RelativeLayout {
    final zzak zza;
    boolean zzb;

    public zzi(Context context, String str, String str2, String str3) {
        super(context);
        zzak zzak = new zzak(context, str);
        this.zza = zzak;
        zzak.zzd(str2);
        zzak.zzc(str3);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzb) {
            return false;
        }
        this.zza.zza(motionEvent);
        return false;
    }
}
