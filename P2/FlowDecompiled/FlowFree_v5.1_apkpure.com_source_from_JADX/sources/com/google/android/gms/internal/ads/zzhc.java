package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzhc extends zzhm {
    private List<Long> zzi = null;

    public zzhc(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzge, "01WVlVdbgqf6HoqKu0lbNygNbv+PeABTWOhn2U9poUmT5M2s6ThNH6tyerCKZPnK", "Ez0nM00ERfZLMPX0zqZ/JlTWlq6o9myQL/+TGyXV+Nc=", zzcn, i, 31);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzq(-1);
        this.zze.zzr(-1);
        if (this.zzi == null) {
            this.zzi = (List) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()});
        }
        List<Long> list = this.zzi;
        if (list != null && list.size() == 2) {
            synchronized (this.zze) {
                this.zze.zzq(this.zzi.get(0).longValue());
                this.zze.zzr(this.zzi.get(1).longValue());
            }
        }
    }
}
