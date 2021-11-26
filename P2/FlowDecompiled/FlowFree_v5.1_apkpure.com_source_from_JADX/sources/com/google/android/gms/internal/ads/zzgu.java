package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgu implements Callable {
    private final zzge zza;
    private final zzcn zzb;

    public zzgu(zzge zzge, zzcn zzcn) {
        this.zza = zzge;
        this.zzb = zzcn;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzn() != null) {
            this.zza.zzn().get();
        }
        zzdc zzm = this.zza.zzm();
        if (zzm == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                zzcn zzcn = this.zzb;
                byte[] zzao = zzm.zzao();
                zzcn.zzaj(zzao, 0, zzao.length, zzest.zza());
            }
            return null;
        } catch (zzett | NullPointerException unused) {
            return null;
        }
    }
}
