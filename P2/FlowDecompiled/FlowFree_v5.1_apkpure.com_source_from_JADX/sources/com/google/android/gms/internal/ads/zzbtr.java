package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbtr {
    private final Context zza;
    private final zzdrg zzb;
    private final Bundle zzc;
    private final zzdrb zzd;

    /* synthetic */ zzbtr(zzbtq zzbtq, zzbtp zzbtp) {
        this.zza = zzbtq.zza;
        this.zzb = zzbtq.zzb;
        this.zzc = zzbtq.zzc;
        this.zzd = zzbtq.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzbtq zza() {
        zzbtq zzbtq = new zzbtq();
        zzbtq.zza(this.zza);
        zzbtq.zzb(this.zzb);
        zzbtq.zzc(this.zzc);
        return zzbtq;
    }

    /* access modifiers changed from: package-private */
    public final zzdrg zzb() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzdrb zzc() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzd() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final Context zze(Context context) {
        return this.zza;
    }
}
