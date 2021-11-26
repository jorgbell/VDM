package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzajz implements zzecb {
    private final String zza;

    zzajz(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        Throwable th = (Throwable) obj;
        zzakp<zzbgf> zzakp = zzako.zza;
        if (zzagc.zzj.zze().booleanValue()) {
            zzs.zzg().zzg(th, "prepareClickUrl.attestation2");
        }
        return str;
    }
}
