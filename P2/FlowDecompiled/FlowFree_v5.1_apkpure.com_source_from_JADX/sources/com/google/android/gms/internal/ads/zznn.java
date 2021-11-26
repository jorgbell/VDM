package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zznn implements zzpq {
    final /* synthetic */ zznq zza;
    private final Uri zzb;
    private final zzpe zzc;
    private final zzno zzd;
    private final zzpw zze;
    private final zzkz zzf = new zzkz();
    private volatile boolean zzg;
    private boolean zzh = true;
    private long zzi;
    /* access modifiers changed from: private */
    public long zzj = -1;

    public final void zza(long j, long j2) {
        this.zzf.zza = j;
        this.zzi = j2;
        this.zzh = true;
    }

    public final void zzb() {
        this.zzg = true;
    }

    public final boolean zzc() {
        return this.zzg;
    }

    public final void zzd() throws IOException, InterruptedException {
        zzkt zzkt;
        long j;
        while (!this.zzg) {
            int i = 0;
            try {
                long j2 = this.zzf.zza;
                zzpe zzpe = this.zzc;
                zzpg zzpg = r4;
                long j3 = j2;
                zzpg zzpg2 = new zzpg(this.zzb, (byte[]) null, j2, j2, -1, (String) null, 0);
                long zza2 = zzpe.zza(zzpg);
                this.zzj = zza2;
                if (zza2 != -1) {
                    j = j3;
                    zza2 += j;
                    this.zzj = zza2;
                } else {
                    j = j3;
                }
                zzpe zzpe2 = this.zzc;
                zzkt = new zzkt(zzpe2, j, zza2);
                try {
                    zzku zzb2 = this.zzd.zzb(zzkt, zzpe2.zzc());
                    if (this.zzh) {
                        zzb2.zze(j, this.zzi);
                        this.zzh = false;
                    }
                    long j4 = j;
                    int i2 = 0;
                    while (true) {
                        if (i2 != 0) {
                            break;
                        }
                        try {
                            if (this.zzg) {
                                i2 = 0;
                                break;
                            }
                            this.zze.zzc();
                            i2 = zzb2.zzg(zzkt, this.zzf);
                            if (zzkt.zzh() > this.zza.zzg + j4) {
                                j4 = zzkt.zzh();
                                this.zze.zzb();
                                this.zza.zzm.post(this.zza.zzl);
                            }
                        } catch (Throwable th) {
                            th = th;
                            i = i2;
                            this.zzf.zza = zzkt.zzh();
                            zzqj.zzc(this.zzc);
                            throw th;
                        }
                    }
                    if (i2 != 1) {
                        this.zzf.zza = zzkt.zzh();
                        i = i2;
                    }
                    zzqj.zzc(this.zzc);
                    if (i != 0) {
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.zzf.zza = zzkt.zzh();
                    zzqj.zzc(this.zzc);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zzkt = null;
                if (!(i == 1 || zzkt == null)) {
                    this.zzf.zza = zzkt.zzh();
                }
                zzqj.zzc(this.zzc);
                throw th;
            }
        }
    }

    public zznn(zznq zznq, Uri uri, zzpe zzpe, zzno zzno, zzpw zzpw) {
        this.zza = zznq;
        Objects.requireNonNull(uri);
        this.zzb = uri;
        Objects.requireNonNull(zzpe);
        this.zzc = zzpe;
        Objects.requireNonNull(zzno);
        this.zzd = zzno;
        this.zze = zzpw;
    }
}
