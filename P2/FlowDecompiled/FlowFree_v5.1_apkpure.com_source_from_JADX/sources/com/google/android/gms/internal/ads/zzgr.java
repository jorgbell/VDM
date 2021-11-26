package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgr extends zzhm {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzgr(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzge, "a8WVEEgQUuRlHEL8p7VCnMYz1L5wp12p5V6BuvGYOX9cH77Etpv1p/6pnJhm6Sng", "KN0/uDtqy2OEMEK3fD3bi0yvaWvEIDu4SPEHxOLonhI=", zzcn, i, 44);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (Long) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzB(zzi.longValue());
        }
    }
}
