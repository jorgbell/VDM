package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbwl extends zzbzc<zzbwn> implements zzbux, zzbwc {
    private final zzdqo zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzbwl(Set<zzcav<zzbwn>> set, zzdqo zzdqo) {
        super(set);
        this.zzb = zzdqo;
    }

    private final void zzc() {
        zzyz zzyz;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfa)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzyz = this.zzb.zzZ) != null && zzyz.zza == 3) {
            zzr(new zzbwk(this));
        }
    }

    public final void zzK() {
        if (this.zzb.zzb == 1) {
            zzc();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbwn zzbwn) throws Exception {
        zzbwn.zzk(this.zzb.zzZ);
    }

    public final void zzbp() {
        int i = this.zzb.zzb;
        if (i == 2 || i == 5 || i == 4 || i == 6) {
            zzc();
        }
    }
}
