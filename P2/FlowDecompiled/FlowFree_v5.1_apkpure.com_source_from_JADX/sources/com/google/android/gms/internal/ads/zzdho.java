package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;
import com.mopub.common.AdType;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdho implements zzdiz<zzdhp> {
    private final zzefx zza;
    private final Context zzb;
    private final Set<String> zzc;

    public zzdho(zzefx zzefx, Context context, Set<String> set) {
        this.zza = zzefx;
        this.zzb = context;
        this.zzc = set;
    }

    public final zzefw<zzdhp> zza() {
        return this.zza.zzb(new zzdhn(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdhp zzb() throws Exception {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdi)).booleanValue()) {
            Set<String> set = this.zzc;
            if (set.contains("rewarded") || set.contains(AdType.INTERSTITIAL) || set.contains("native") || set.contains("banner")) {
                return new zzdhp(zzs.zzr().zzc(this.zzb));
            }
        }
        return new zzdhp((String) null);
    }
}
