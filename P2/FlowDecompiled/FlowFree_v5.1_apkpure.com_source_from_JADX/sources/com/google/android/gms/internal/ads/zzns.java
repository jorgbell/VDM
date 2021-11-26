package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzns implements zznw, zznv {
    private final Uri zza;
    private final zzpd zzb;
    private final zzkw zzc;
    private final int zzd;
    private final Handler zze;
    private final zznr zzf;
    private final zzjc zzg = new zzjc();
    private final int zzh;
    private zznv zzi;
    private zzje zzj;
    private boolean zzk;

    public zzns(Uri uri, zzpd zzpd, zzkw zzkw, int i, Handler handler, zznr zznr, String str, int i2) {
        this.zza = uri;
        this.zzb = zzpd;
        this.zzc = zzkw;
        this.zzd = i;
        this.zze = handler;
        this.zzf = zznr;
        this.zzh = i2;
    }

    public final void zza(zzij zzij, boolean z, zznv zznv) {
        this.zzi = zznv;
        zzoj zzoj = new zzoj(-9223372036854775807L, false);
        this.zzj = zzoj;
        zznv.zzi(zzoj, (Object) null);
    }

    public final void zzb() throws IOException {
    }

    public final void zzc(zznu zznu) {
        ((zznq) zznu).zzd();
    }

    public final void zzd() {
        this.zzi = null;
    }

    public final zznu zze(int i, zzph zzph) {
        zzpu.zza(i == 0);
        return new zznq(this.zza, this.zzb.zza(), this.zzc.zza(), this.zzd, this.zze, this.zzf, this, zzph, (String) null, this.zzh, (byte[]) null);
    }

    public final void zzi(zzje zzje, Object obj) {
        zzjc zzjc = this.zzg;
        boolean z = false;
        zzje.zzd(0, zzjc, false);
        if (zzjc.zzc != -9223372036854775807L) {
            z = true;
        }
        if (!this.zzk || z) {
            this.zzj = zzje;
            this.zzk = z;
            this.zzi.zzi(zzje, (Object) null);
        }
    }
}
