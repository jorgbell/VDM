package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zznp implements zzog {
    final /* synthetic */ zznq zza;
    /* access modifiers changed from: private */
    public final int zzb;

    public zznp(zznq zznq, int i) {
        this.zza = zznq;
        this.zzb = i;
    }

    public final boolean zza() {
        return this.zza.zzl(this.zzb);
    }

    public final void zzb() throws IOException {
        this.zza.zzm();
    }

    public final int zzc(zziu zziu, zzkm zzkm, boolean z) {
        return this.zza.zzn(this.zzb, zziu, zzkm, z);
    }

    public final void zzd(long j) {
        this.zza.zzo(this.zzb, j);
    }
}
