package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbwi extends zzbzc<zzp> implements zzp {
    public zzbwi(Set<zzcav<zzp>> set) {
        super(set);
    }

    public final synchronized void zzbJ() {
        zzr(zzbwg.zza);
    }

    public final synchronized void zzbo() {
        zzr(zzbwh.zza);
    }

    public final synchronized void zzbr() {
        zzr(zzbwe.zza);
    }

    public final synchronized void zzbs() {
        zzr(zzbwf.zza);
    }

    public final synchronized void zzbt(int i) {
        zzr(new zzbwd(i));
    }
}
