package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzs;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbig {
    private final zzbbq zza;
    private final Context zzb;
    private final WeakReference<Context> zzc;

    /* synthetic */ zzbig(zzbif zzbif, zzbie zzbie) {
        this.zza = zzbif.zza;
        this.zzb = zzbif.zzb;
        this.zzc = zzbif.zzc;
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final WeakReference<Context> zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzbbq zzc() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzd() {
        return zzs.zzc().zze(this.zzb, this.zza.zza);
    }

    public final zzfh zze() {
        return new zzfh(new zzi(this.zzb, this.zza));
    }
}
