package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzbcy extends TextureView implements zzbds {
    protected final zzbdj zza = new zzbdj();
    protected final zzbdt zzb;

    public zzbcy(Context context) {
        super(context);
        this.zzb = new zzbdt(context, this);
    }

    public abstract String zza();

    public abstract void zzb(zzbcx zzbcx);

    public abstract void zzc(String str);

    public abstract void zzd();

    public abstract void zze();

    public abstract void zzf();

    public abstract int zzg();

    public abstract int zzh();

    public abstract void zzi(int i);

    public abstract void zzj(float f, float f2);

    public abstract int zzk();

    public abstract int zzl();

    public abstract long zzm();

    public abstract long zzn();

    public abstract long zzo();

    public abstract int zzp();

    public abstract void zzq();

    public void zzu(String str, String[] strArr) {
        zzc(str);
    }

    public void zzv(int i) {
    }

    public void zzw(int i) {
    }

    public void zzx(int i) {
    }

    public void zzy(int i) {
    }

    public void zzz(int i) {
    }
}
