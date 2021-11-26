package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzas;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzape {
    static final zzas<zzanl> zza = new zzapc();
    static final zzas<zzanl> zzb = new zzapd();
    private final zzaoq zzc;

    public zzape(Context context, zzbbq zzbbq, String str) {
        this.zzc = new zzaoq(context, zzbbq, str, zza, zzb);
    }

    public final <I, O> zzaou<I, O> zza(String str, zzaox<I> zzaox, zzaow<O> zzaow) {
        return new zzapi(this.zzc, str, zzaox, zzaow);
    }

    public final zzapn zzb() {
        return new zzapn(this.zzc);
    }
}
