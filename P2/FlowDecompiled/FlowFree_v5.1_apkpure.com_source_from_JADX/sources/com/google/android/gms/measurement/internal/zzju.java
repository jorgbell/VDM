package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzju extends zzf {
    protected final zzjt zza = new zzjt(this);
    protected final zzjs zzb = new zzjs(this);
    protected final zzjq zzc = new zzjq(this);
    /* access modifiers changed from: private */
    public Handler zzd;

    zzju(zzfp zzfp) {
        super(zzfp);
    }

    static /* synthetic */ void zzh(zzju zzju, long j) {
        zzju.zzg();
        zzju.zzl();
        zzju.zzs.zzau().zzk().zzb("Activity resumed, time", Long.valueOf(j));
        zzae zzc2 = zzju.zzs.zzc();
        zzdz<Boolean> zzdz = zzea.zzar;
        if (zzc2.zzn((String) null, zzdz)) {
            if (zzju.zzs.zzc().zzt() || zzju.zzs.zzd().zzl.zza()) {
                zzju.zzb.zza(j);
            }
            zzju.zzc.zza();
        } else {
            zzju.zzc.zza();
            if (zzju.zzs.zzc().zzt()) {
                zzju.zzb.zza(j);
            }
        }
        zzjt zzjt = zzju.zza;
        zzjt.zza.zzg();
        if (zzjt.zza.zzs.zzF()) {
            if (!zzjt.zza.zzs.zzc().zzn((String) null, zzdz)) {
                zzjt.zza.zzs.zzd().zzl.zzb(false);
            }
            zzjt.zzb(zzjt.zza.zzs.zzay().currentTimeMillis(), false);
        }
    }

    static /* synthetic */ void zzi(zzju zzju, long j) {
        zzju.zzg();
        zzju.zzl();
        zzju.zzs.zzau().zzk().zzb("Activity paused, time", Long.valueOf(j));
        zzju.zzc.zzb(j);
        if (zzju.zzs.zzc().zzt()) {
            zzju.zzb.zzb(j);
        }
        zzjt zzjt = zzju.zza;
        if (!zzjt.zza.zzs.zzc().zzn((String) null, zzea.zzar)) {
            zzjt.zza.zzs.zzd().zzl.zzb(true);
        }
    }

    /* access modifiers changed from: private */
    public final void zzl() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzm(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }
}
