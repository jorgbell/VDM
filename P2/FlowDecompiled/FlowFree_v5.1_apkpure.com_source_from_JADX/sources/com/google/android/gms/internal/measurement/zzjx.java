package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzjx extends zzjv<zzjw, zzjw> {
    zzjx() {
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzjw) obj).zzh(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzjw.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzc(Object obj, Object obj2) {
        ((zzhr) obj).zzc = (zzjw) obj2;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzd(Object obj) {
        return ((zzhr) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zze(Object obj) {
        ((zzhr) obj).zzc.zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzf(Object obj, Object obj2) {
        zzjw zzjw = (zzjw) obj2;
        if (zzjw.equals(zzjw.zza())) {
            return obj;
        }
        return zzjw.zzc((zzjw) obj, zzjw);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ int zzg(Object obj) {
        return ((zzjw) obj).zze();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ int zzh(Object obj) {
        return ((zzjw) obj).zzf();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzi(Object obj, zzgz zzgz) throws IOException {
        ((zzjw) obj).zzi(zzgz);
    }
}
