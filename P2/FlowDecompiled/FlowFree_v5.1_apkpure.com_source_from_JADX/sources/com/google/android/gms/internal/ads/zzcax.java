package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcax extends zzbzc<zzri> implements zzri {
    @GuardedBy("this")
    private final Map<View, zzrj> zzb = new WeakHashMap(1);
    private final Context zzc;
    private final zzdqo zzd;

    public zzcax(Context context, Set<zzcav<zzri>> set, zzdqo zzdqo) {
        super(set);
        this.zzc = context;
        this.zzd = zzdqo;
    }

    public final synchronized void zza(View view) {
        zzrj zzrj = this.zzb.get(view);
        if (zzrj == null) {
            zzrj = new zzrj(this.zzc, view);
            zzrj.zza(this);
            this.zzb.put(view, zzrj);
        }
        if (this.zzd.zzR) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzaS)).booleanValue()) {
                zzrj.zzd(((Long) zzaaa.zzc().zzb(zzaeq.zzaR)).longValue());
                return;
            }
        }
        zzrj.zze();
    }

    public final synchronized void zzb(View view) {
        if (this.zzb.containsKey(view)) {
            this.zzb.get(view).zzb(this);
            this.zzb.remove(view);
        }
    }

    public final synchronized void zzc(zzrh zzrh) {
        zzr(new zzcaw(zzrh));
    }
}
