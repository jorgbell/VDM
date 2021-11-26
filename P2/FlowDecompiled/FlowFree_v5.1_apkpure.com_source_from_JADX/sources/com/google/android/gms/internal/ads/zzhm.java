package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzhm implements Callable {
    protected final zzge zzb;
    protected final String zzc;
    protected final String zzd;
    protected final zzcn zze;
    protected Method zzf;
    protected final int zzg;
    protected final int zzh;

    public zzhm(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        getClass().getSimpleName();
        this.zzb = zzge;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzcn;
        this.zzg = i;
        this.zzh = i2;
    }

    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzb();
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzb() throws Exception {
        int i;
        try {
            long nanoTime = System.nanoTime();
            Method zzp = this.zzb.zzp(this.zzc, this.zzd);
            this.zzf = zzp;
            if (zzp == null) {
                return null;
            }
            zza();
            zzew zzi = this.zzb.zzi();
            if (!(zzi == null || (i = this.zzg) == Integer.MIN_VALUE)) {
                zzi.zza(this.zzh, i, (System.nanoTime() - nanoTime) / 1000, (String) null, (Exception) null);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
