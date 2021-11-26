package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgv extends zzhm {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzgv(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzge, "fkf51aLEFXfiNurGHbx1BSH7msQozHZOJXYpsm8ziDxIsSol9uz7PMVXAs+R19N8", "cKfFcdJiOvmUtUL2Y5P/s8OlQJiCVurBpl7VcHQsb0I=", zzcn, i, 22);
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
            this.zze.zzm(zzi.longValue());
        }
    }
}
