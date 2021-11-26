package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzhh extends zzhm {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzhh(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzge, "w88K96a81QAqecEx1Be7xBZ71wBzgDzB2ncLUmmSbS5j5T72Nq0PXydpfnGU7CdX", "D/80jmR/TcKhAUNfNeJDLyFk2By/w+5wEIxKJGOZawI=", zzcn, i, 33);
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
            this.zze.zzs(zzi.longValue());
        }
    }
}
