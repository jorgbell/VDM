package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzw;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcjj implements zzyi, zzajq, zzp, zzajs, zzw {
    private zzyi zza;
    private zzajq zzb;
    private zzp zzc;
    private zzajs zzd;
    private zzw zze;

    /* synthetic */ zzcjj(zzcje zzcje) {
    }

    /* access modifiers changed from: private */
    public final synchronized void zzh(zzyi zzyi, zzajq zzajq, zzp zzp, zzajs zzajs, zzw zzw) {
        this.zza = zzyi;
        this.zzb = zzajq;
        this.zzc = zzp;
        this.zzd = zzajs;
        this.zze = zzw;
    }

    public final synchronized void onAdClicked() {
        zzyi zzyi = this.zza;
        if (zzyi != null) {
            zzyi.onAdClicked();
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        zzajq zzajq = this.zzb;
        if (zzajq != null) {
            zzajq.zza(str, bundle);
        }
    }

    public final synchronized void zzbB(String str, String str2) {
        zzajs zzajs = this.zzd;
        if (zzajs != null) {
            zzajs.zzbB(str, str2);
        }
    }

    public final synchronized void zzbJ() {
        zzp zzp = this.zzc;
        if (zzp != null) {
            zzp.zzbJ();
        }
    }

    public final synchronized void zzbo() {
        zzp zzp = this.zzc;
        if (zzp != null) {
            zzp.zzbo();
        }
    }

    public final synchronized void zzbr() {
        zzp zzp = this.zzc;
        if (zzp != null) {
            zzp.zzbr();
        }
    }

    public final synchronized void zzbs() {
        zzp zzp = this.zzc;
        if (zzp != null) {
            zzp.zzbs();
        }
    }

    public final synchronized void zzbt(int i) {
        zzp zzp = this.zzc;
        if (zzp != null) {
            zzp.zzbt(i);
        }
    }

    public final synchronized void zzf() {
        zzw zzw = this.zze;
        if (zzw != null) {
            zzw.zzf();
        }
    }
}
