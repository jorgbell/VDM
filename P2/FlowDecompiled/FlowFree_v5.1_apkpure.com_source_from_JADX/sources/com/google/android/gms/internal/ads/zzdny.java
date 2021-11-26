package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdny implements zzecb<zzcsk, zzdoa> {
    final /* synthetic */ zzdob zza;

    zzdny(zzdob zzdob) {
        this.zza = zzdob;
    }

    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzbbk.zzg("", (zzcsk) obj);
        zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzdob zzdob = this.zza;
        zzdoa unused = zzdob.zze = new zzdoa((zzawc) null, zzdob.zze(), (zzdny) null);
        return this.zza.zze;
    }
}
