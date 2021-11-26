package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdbs {
    private final zzccp zzb;

    public zzdbs(Context context, zzccp zzccp) {
        this.zzb = zzccp;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzdra zzdra, zzdqo zzdqo, View view, zzdbo zzdbo) {
        zzcbt zzc = this.zzb.zzc(new zzbra(zzdra, zzdqo, (String) null), new zzdbq(this, zzdbp.zza));
        zzdbo.zzd(new zzdbr(this, zzc));
        return zzc.zzh();
    }
}
