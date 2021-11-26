package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgz extends zzhm {
    private static volatile String zzi;
    private static final Object zzj = new Object();

    public zzgz(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzge, "v7A3h9QqVCXIbrfyosHIukYh/yZv47yYSEhtQFNg8vHfmWE6VQ1je6L104nqsnjL", "8sE7Kp846pN8ghcm6jpvMxjTA1L8yxDG5/OLZ4fVnxc=", zzcn, i, 1);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zza("E");
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (String) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zza(zzi);
        }
    }
}
