package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdfh implements zzdiz {
    private static final Object zzf = new Object();
    private final String zza;
    private final String zzb;
    private final zzbrx zzc;
    private final zzdsg zzd;
    private final zzdrg zze;
    private final zzg zzg = zzs.zzg().zzl();

    public zzdfh(String str, String str2, zzbrx zzbrx, zzdsg zzdsg, zzdrg zzdrg) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzbrx;
        this.zzd = zzdsg;
        this.zze = zzdrg;
    }

    public final zzefw zza() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdK)).booleanValue()) {
            this.zzc.zzi(this.zze.zzd);
            bundle.putAll(this.zzd.zzc());
        }
        return zzefo.zza(new zzdfg(this, bundle));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Bundle bundle, Bundle bundle2) {
        String str;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdK)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdJ)).booleanValue()) {
                synchronized (zzf) {
                    this.zzc.zzi(this.zze.zzd);
                    bundle2.putBundle("quality_signals", this.zzd.zzc());
                }
            } else {
                this.zzc.zzi(this.zze.zzd);
                bundle2.putBundle("quality_signals", this.zzd.zzc());
            }
        }
        bundle2.putString("seq_num", this.zza);
        if (this.zzg.zzB()) {
            str = "";
        } else {
            str = this.zzb;
        }
        bundle2.putString("session_id", str);
    }
}
