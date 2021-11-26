package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzhi extends zzhm {
    public zzhi(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzge, "wxqoL0Ntglf/xfXLeHxTqKHQFZETSKw9Sjjan4AxX5JFG223VwKhlfBIQokmMH5F", "Qt5tltWJjiKcHVLLbGsBdffUrcF61Y4NeRTZLQPykHE=", zzcn, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzF(zzdm.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
        synchronized (this.zze) {
            if (booleanValue) {
                this.zze.zzF(zzdm.ENUM_TRUE);
            } else {
                this.zze.zzF(zzdm.ENUM_FALSE);
            }
        }
    }
}
