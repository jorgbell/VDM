package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzhg extends zzhm {
    private final zzgl zzi;
    private long zzj;

    public zzhg(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2, zzgl zzgl) {
        super(zzge, "dsBT0/C86X4nvrUnBzUMEal+ojVYRI4vej5Xuqa9imNJ0J9pVwFR29C2xyAk2Th3", "9lTHSJcuaKoP0vq0QstvDSkZiAsCy7DV03ujHiOCPWw=", zzcn, i, 53);
        this.zzi = zzgl;
        if (zzgl != null) {
            this.zzj = zzgl.zzc();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            this.zze.zzJ(((Long) this.zzf.invoke((Object) null, new Object[]{Long.valueOf(this.zzj)})).longValue());
        }
    }
}
