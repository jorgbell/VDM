package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgn extends zzhm {
    public zzgn(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzge, "p3Z3ZqZKo17onS4HiiEtpoGwRIBviLad/ZdN5J9oBr9KBduQsBv0bePYyi9xIk1Y", "iFXNP6ElZKxf5HXZJFDnSU66PfDdP3IuIwL5oCTFkB0=", zzcn, i, 49);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzdm zzdm;
        this.zze.zzG(zzdm.ENUM_FAILURE);
        try {
            boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
            zzcn zzcn = this.zze;
            if (booleanValue) {
                zzdm = zzdm.ENUM_TRUE;
            } else {
                zzdm = zzdm.ENUM_FALSE;
            }
            zzcn.zzG(zzdm);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
