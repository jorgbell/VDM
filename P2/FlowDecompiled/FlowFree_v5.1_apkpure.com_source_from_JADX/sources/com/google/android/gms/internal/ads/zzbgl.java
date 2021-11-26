package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbgl implements zzp {
    private final zzbgf zza;
    private final zzp zzb;

    public zzbgl(zzbgf zzbgf, zzp zzp) {
        this.zza = zzbgf;
        this.zzb = zzp;
    }

    public final void zzbJ() {
    }

    public final void zzbo() {
        zzp zzp = this.zzb;
        if (zzp != null) {
            zzp.zzbo();
        }
        this.zza.zzK();
    }

    public final void zzbr() {
        zzp zzp = this.zzb;
        if (zzp != null) {
            zzp.zzbr();
        }
    }

    public final void zzbs() {
    }

    public final void zzbt(int i) {
        zzp zzp = this.zzb;
        if (zzp != null) {
            zzp.zzbt(i);
        }
        this.zza.zzI();
    }
}
