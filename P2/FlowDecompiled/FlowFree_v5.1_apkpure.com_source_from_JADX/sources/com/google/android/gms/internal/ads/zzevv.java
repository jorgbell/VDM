package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzevv extends zzevt<zzevu, zzevu> {
    zzevv() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzeuz zzeuz) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzevu) obj).zzh(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzevu) obj).zzh((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, long j) {
        ((zzevu) obj).zzh((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zze(Object obj, int i, zzesf zzesf) {
        ((zzevu) obj).zzh((i << 3) | 2, zzesf);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzevu) obj).zzh((i << 3) | 3, obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzg() {
        return zzevu.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzh(Object obj) {
        zzevu zzevu = (zzevu) obj;
        zzevu.zzd();
        return zzevu;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzi(Object obj, Object obj2) {
        ((zzeth) obj).zzc = (zzevu) obj2;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzj(Object obj) {
        return ((zzeth) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzk(Object obj) {
        zzeth zzeth = (zzeth) obj;
        zzevu zzevu = zzeth.zzc;
        if (zzevu != zzevu.zza()) {
            return zzevu;
        }
        zzevu zzb = zzevu.zzb();
        zzeth.zzc = zzb;
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzl(Object obj, Object obj2) {
        ((zzeth) obj).zzc = (zzevu) obj2;
    }

    /* access modifiers changed from: package-private */
    public final void zzm(Object obj) {
        ((zzeth) obj).zzc.zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzo(Object obj, Object obj2) {
        zzevu zzevu = (zzevu) obj2;
        if (zzevu.equals(zzevu.zza())) {
            return obj;
        }
        return zzevu.zzc((zzevu) obj, zzevu);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ int zzp(Object obj) {
        return ((zzevu) obj).zze();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ int zzq(Object obj) {
        return ((zzevu) obj).zzf();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzr(Object obj, zzesp zzesp) throws IOException {
        ((zzevu) obj).zzi(zzesp);
    }
}
