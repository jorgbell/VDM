package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzhb extends zzhm {
    public zzhb(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzge, "sT47VR68C8cERi/0itZP+BsmCv/YYJ9p1AyAQJ4PMt7kQEnzEdHbEJ7D0Q038xaP", "VdkstFhaRmxqYWVlF/gLTzv1f2odqs7Iuhyqw8uXCUM=", zzcn, i, 73);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        try {
            this.zze.zzV(((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue() ? zzdm.ENUM_TRUE : zzdm.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.zze.zzV(zzdm.ENUM_FAILURE);
        }
    }
}
