package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzha extends zzhm {
    public zzha(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzge, "eijqHhj6HRHTR2kiOBr06o0WXa90aPfb55Jus8IsGuh+gWTtvWAdzIROEcsjSbn8", "zwHuLsgj/SpT7P1yA2TTitRWF3b0MhirZyQt+GevFp0=", zzcn, i, 3);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        boolean booleanValue = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbF)).booleanValue();
        zzfl zzfl = new zzfl((String) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb(), Boolean.valueOf(booleanValue)}));
        synchronized (this.zze) {
            this.zze.zzc(zzfl.zza);
            this.zze.zzQ(zzfl.zzb);
        }
    }
}
