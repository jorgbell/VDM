package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzhe extends zzhm {
    private final StackTraceElement[] zzi;

    public zzhe(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzge, "sGTEC3E7f6YjHctdRy2hflBi3Pvsr/R7GPdiuAlLlHS4kSSM9HZZPJI60ut1Fh4f", "QQzVaaiH4oNrSQ4TH/x6dUQomR0+m9ZNGD4A6aa+nps=", zzcn, i, 45);
        this.zzi = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzdm zzdm;
        Object obj = this.zzi;
        if (obj != null) {
            zzfw zzfw = new zzfw((String) this.zzf.invoke((Object) null, new Object[]{obj}));
            synchronized (this.zze) {
                this.zze.zzC(zzfw.zza.longValue());
                if (zzfw.zzb.booleanValue()) {
                    zzcn zzcn = this.zze;
                    if (zzfw.zzc.booleanValue()) {
                        zzdm = zzdm.ENUM_FALSE;
                    } else {
                        zzdm = zzdm.ENUM_TRUE;
                    }
                    zzcn.zzK(zzdm);
                } else {
                    this.zze.zzK(zzdm.ENUM_FAILURE);
                }
            }
        }
    }
}
