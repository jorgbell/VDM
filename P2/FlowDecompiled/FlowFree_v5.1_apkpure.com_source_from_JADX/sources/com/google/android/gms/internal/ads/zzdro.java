package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdro implements zzefk<String> {
    final /* synthetic */ zzbgf zza;
    final /* synthetic */ zzdwg zzb;
    final /* synthetic */ zzcvk zzc;

    zzdro(zzbgf zzbgf, zzdwg zzdwg, zzcvk zzcvk) {
        this.zza = zzbgf;
        this.zzb = zzdwg;
        this.zzc = zzcvk;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzF().zzad) {
            this.zzb.zzb(str);
            return;
        }
        long currentTimeMillis = zzs.zzj().currentTimeMillis();
        String str2 = this.zza.zzaB().zzb;
        zzs.zzc();
        int i = 1;
        if (true == zzr.zzH(this.zza.getContext())) {
            i = 2;
        }
        this.zzc.zze(new zzcvm(currentTimeMillis, str2, str, i));
    }
}
