package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzij extends zzik {
    /* synthetic */ zzij(zzih zzih) {
        super((zzih) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        ((zzhy) zzkf.zzn(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zzb(Object obj, Object obj2, long j) {
        zzhy zzhy = (zzhy) zzkf.zzn(obj, j);
        zzhy zzhy2 = (zzhy) zzkf.zzn(obj2, j);
        int size = zzhy.size();
        int size2 = zzhy2.size();
        if (size > 0 && size2 > 0) {
            if (!zzhy.zza()) {
                zzhy = zzhy.zze(size2 + size);
            }
            zzhy.addAll(zzhy2);
        }
        if (size > 0) {
            zzhy2 = zzhy;
        }
        zzkf.zzo(obj, j, zzhy2);
    }
}
