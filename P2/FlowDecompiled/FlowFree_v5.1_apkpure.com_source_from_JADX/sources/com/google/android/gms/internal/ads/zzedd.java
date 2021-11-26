package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzedd extends zzede {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzede zzc;

    zzedd(zzede zzede, int i, int i2) {
        this.zzc = zzede;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzecl.zzd(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }

    public final zzede zzh(int i, int i2) {
        zzecl.zzf(i, i2, this.zzb);
        zzede zzede = this.zzc;
        int i3 = this.zza;
        return zzede.subList(i + i3, i2 + i3);
    }
}
