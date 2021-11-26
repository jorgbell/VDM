package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeub extends zzeuc {
    /* synthetic */ zzeub(zzetz zzetz) {
        super((zzetz) null);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        zzetq zzetq = (zzetq) zzewd.zzn(obj, j);
        if (zzetq.zza()) {
            return zzetq;
        }
        int size = zzetq.size();
        zzetq zze = zzetq.zze(size == 0 ? 10 : size + size);
        zzewd.zzo(obj, j, zze);
        return zze;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        ((zzetq) zzewd.zzn(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zzc(Object obj, Object obj2, long j) {
        zzetq zzetq = (zzetq) zzewd.zzn(obj, j);
        zzetq zzetq2 = (zzetq) zzewd.zzn(obj2, j);
        int size = zzetq.size();
        int size2 = zzetq2.size();
        if (size > 0 && size2 > 0) {
            if (!zzetq.zza()) {
                zzetq = zzetq.zze(size2 + size);
            }
            zzetq.addAll(zzetq2);
        }
        if (size > 0) {
            zzetq2 = zzetq;
        }
        zzewd.zzo(obj, j, zzetq2);
    }
}
