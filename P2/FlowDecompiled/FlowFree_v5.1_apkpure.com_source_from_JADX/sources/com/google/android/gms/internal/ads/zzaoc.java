package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbq;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzaoc implements zzakp<zzaor> {
    final /* synthetic */ zzanl zza;
    final /* synthetic */ zzbq zzb;
    final /* synthetic */ zzaoq zzc;

    zzaoc(zzaoq zzaoq, zzfh zzfh, zzanl zzanl, zzbq zzbq) {
        this.zzc = zzaoq;
        this.zza = zzanl;
        this.zzb = zzbq;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzakp, java.lang.Object] */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzaor zzaor = (zzaor) obj;
        synchronized (this.zzc.zza) {
            zzbbk.zzh("JS Engine is requesting an update");
            if (this.zzc.zzh == 0) {
                zzbbk.zzh("Starting reload.");
                int unused = this.zzc.zzh = 2;
                this.zzc.zza((zzfh) null);
            }
            this.zza.zzm("/requestReload", this.zzb.zza());
        }
    }
}
