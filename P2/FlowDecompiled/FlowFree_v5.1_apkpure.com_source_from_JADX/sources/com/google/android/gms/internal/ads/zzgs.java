package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgs extends zzhm {
    private final long zzi;

    public zzgs(zzge zzge, String str, String str2, zzcn zzcn, long j, int i, int i2) {
        super(zzge, "Fy+0MnOblzKutA61AaguuQzqgSFwAYgIkg1Nv1jjUsad/m9fCPRM59z2VYO0D4ud", "I4PnVaadHpMjKRcaJl2eH2r6C+XiARMRngguwqwgirg=", zzcn, i, 25);
        this.zzi = j;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzf.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zze) {
            this.zze.zzaa(longValue);
            long j = this.zzi;
            if (j != 0) {
                this.zze.zzk(longValue - j);
                this.zze.zzn(this.zzi);
            }
        }
    }
}
