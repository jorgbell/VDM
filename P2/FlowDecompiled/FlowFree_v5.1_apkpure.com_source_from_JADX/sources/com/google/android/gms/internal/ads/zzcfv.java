package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcfv implements zzagw {
    final /* synthetic */ zzcgr zza;
    final /* synthetic */ ViewGroup zzb;

    zzcfv(zzcfw zzcfw, zzcgr zzcgr, ViewGroup viewGroup) {
        this.zza = zzcgr;
        this.zzb = viewGroup;
    }

    public final void zza() {
        zzcgr zzcgr = this.zza;
        zzede<String> zzede = zzcfs.zza;
        Map<String, WeakReference<View>> zzk = zzcgr.zzk();
        if (zzk != null) {
            int size = zzede.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                if (zzk.get(zzede.get(i)) == null) {
                    i = i2;
                } else {
                    this.zza.onClick(this.zzb);
                    return;
                }
            }
        }
    }

    public final void zzb(MotionEvent motionEvent) {
        this.zza.onTouch((View) null, motionEvent);
    }

    public final JSONObject zzc() {
        return this.zza.zzp();
    }
}
