package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcph implements zzefk<String> {
    final /* synthetic */ zzcpj zza;

    zzcph(zzcpj zzcpj) {
        this.zza = zzcpj;
    }

    public final void zza(Throwable th) {
        synchronized (this) {
            boolean unused = this.zza.zzc = true;
            this.zza.zzu("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzs.zzj().elapsedRealtime() - this.zza.zzd));
            this.zza.zze.zzd(new Exception());
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        String str = (String) obj;
        synchronized (this) {
            boolean unused = this.zza.zzc = true;
            this.zza.zzu("com.google.android.gms.ads.MobileAds", true, "", (int) (zzs.zzj().elapsedRealtime() - this.zza.zzd));
            this.zza.zzi.execute(new zzcpg(this, str));
        }
    }
}
