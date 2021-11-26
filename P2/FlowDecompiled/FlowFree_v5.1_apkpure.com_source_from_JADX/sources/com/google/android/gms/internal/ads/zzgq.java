package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgq extends zzhm {
    public zzgq(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzge, "QyhSh63pUWyl0E0z6uCQKr++pUXCMXwPXQltRjm6En7YCAlkO5UKsLUcZkA+3Vx8", "eX0g6VwvDvhHx1e1HjsTwSMT1pEPU1lt723kkpn0xZw=", zzcn, i, 5);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzd(-1);
        this.zze.zze(-1);
        int[] iArr = (int[]) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()});
        synchronized (this.zze) {
            this.zze.zzd((long) iArr[0]);
            this.zze.zze((long) iArr[1]);
            int i = iArr[2];
            if (i != Integer.MIN_VALUE) {
                this.zze.zzP((long) i);
            }
        }
    }
}
