package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcef implements zzeyl<zzcax> {
    private final zzeyw<Context> zza;
    private final zzeyw<zzdqo> zzb;

    public zzcef(zzeyw<Context> zzeyw, zzeyw<zzdqo> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcax(this.zza.zzb(), new HashSet(), ((zzbrb) this.zzb).zza());
    }
}
