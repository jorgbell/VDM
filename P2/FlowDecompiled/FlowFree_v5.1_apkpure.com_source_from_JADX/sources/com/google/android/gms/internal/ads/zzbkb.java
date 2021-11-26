package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbkb implements zzcoq {
    final /* synthetic */ zzbko zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    private final zzalk zzc;
    private final zzeyw<zzcoq> zzd;
    private final zzeyw<zzalk> zze;
    private final zzeyw<zzcol> zzf;
    private final zzeyw<zzcon> zzg;

    /* synthetic */ zzbkb(zzbko zzbko, Context context, zzalk zzalk, zzbjd zzbjd) {
        this.zza = zzbko;
        this.zzb = context;
        this.zzc = zzalk;
        zzeyl zza2 = zzeym.zza(this);
        this.zzd = zza2;
        zzeyl zza3 = zzeym.zza(zzalk);
        this.zze = zza3;
        zzcom zzcom = new zzcom(zza3);
        this.zzf = zzcom;
        this.zzg = zzeyk.zza(new zzcoo(zza2, zzcom));
    }

    public final zzcon zza() {
        return this.zzg.zzb();
    }

    public final zzcoh zzb() {
        return new zzbjz(this, (zzbjd) null);
    }
}
