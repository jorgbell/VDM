package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzim implements zzij {
    private final zziy[] zza;
    private final zzoz zzb;
    private final zzox zzc;
    private final Handler zzd;
    private final zzir zze;
    private final CopyOnWriteArraySet<zzig> zzf = new CopyOnWriteArraySet<>();
    private final zzjd zzg;
    private final zzjc zzh;
    private boolean zzi;
    private boolean zzj = false;
    private int zzk = 1;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private zzje zzo;
    private Object zzp;
    private zzol zzq;
    private zzox zzr;
    private zzix zzs;
    private zzio zzt;
    private long zzu;

    @SuppressLint({"HandlerLeak"})
    public zzim(zziy[] zziyArr, zzoz zzoz, zzbel zzbel, byte[] bArr) {
        String str = zzqj.zze;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        this.zza = zziyArr;
        Objects.requireNonNull(zzoz);
        this.zzb = zzoz;
        zzox zzox = new zzox(new zzop[2], (byte[]) null);
        this.zzc = zzox;
        this.zzo = zzje.zza;
        this.zzg = new zzjd();
        this.zzh = new zzjc();
        this.zzq = zzol.zza;
        this.zzr = zzox;
        this.zzs = zzix.zza;
        zzil zzil = new zzil(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.zzd = zzil;
        zzio zzio = new zzio(0, 0);
        this.zzt = zzio;
        this.zze = new zzir(zziyArr, zzoz, zzbel, this.zzj, 0, zzil, zzio, this, (byte[]) null);
    }

    public final void zza(zzig zzig) {
        this.zzf.add(zzig);
    }

    public final void zzb(zzig zzig) {
        this.zzf.remove(zzig);
    }

    public final int zzc() {
        return this.zzk;
    }

    public final void zzd(zznw zznw) {
        if (!this.zzo.zzf() || this.zzp != null) {
            this.zzo = zzje.zza;
            this.zzp = null;
            Iterator<zzig> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzo, this.zzp);
            }
        }
        if (this.zzi) {
            this.zzi = false;
            this.zzq = zzol.zza;
            this.zzr = this.zzc;
            this.zzb.zze((Object) null);
            Iterator<zzig> it2 = this.zzf.iterator();
            while (it2.hasNext()) {
                it2.next().zzb(this.zzq, this.zzr);
            }
        }
        this.zzm++;
        this.zze.zzb(zznw, true);
    }

    public final void zze(boolean z) {
        if (this.zzj != z) {
            this.zzj = z;
            this.zze.zzc(z);
            Iterator<zzig> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zzd(z, this.zzk);
            }
        }
    }

    public final boolean zzf() {
        return this.zzj;
    }

    public final void zzg(long j) {
        zzr();
        if (this.zzo.zzf() || this.zzo.zza() > 0) {
            this.zzl++;
            if (!this.zzo.zzf()) {
                this.zzo.zzg(0, this.zzg, false);
                long zzb2 = zzie.zzb(j);
                long j2 = this.zzo.zzd(0, this.zzh, false).zzc;
                if (j2 != -9223372036854775807L) {
                    int i = (zzb2 > j2 ? 1 : (zzb2 == j2 ? 0 : -1));
                }
            }
            this.zzu = j;
            this.zze.zzd(this.zzo, 0, zzie.zzb(j));
            Iterator<zzig> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zzf();
            }
            return;
        }
        throw new zziv(this.zzo, 0, j);
    }

    public final void zzh() {
        this.zze.zze();
    }

    public final void zzi() {
        this.zze.zzh();
        this.zzd.removeCallbacksAndMessages((Object) null);
    }

    public final void zzj(zzii... zziiArr) {
        this.zze.zzf(zziiArr);
    }

    public final void zzk(zzii... zziiArr) {
        this.zze.zzg(zziiArr);
    }

    public final long zzl() {
        if (this.zzo.zzf()) {
            return -9223372036854775807L;
        }
        zzje zzje = this.zzo;
        zzr();
        return zzie.zza(zzje.zzg(0, this.zzg, false).zza);
    }

    public final long zzm() {
        if (this.zzo.zzf() || this.zzl > 0) {
            return this.zzu;
        }
        this.zzo.zzd(this.zzt.zza, this.zzh, false);
        return zzie.zza(0) + zzie.zza(this.zzt.zzc);
    }

    public final long zzn() {
        if (this.zzo.zzf() || this.zzl > 0) {
            return this.zzu;
        }
        this.zzo.zzd(this.zzt.zza, this.zzh, false);
        return zzie.zza(0) + zzie.zza(this.zzt.zzd);
    }

    public final void zzo() {
        this.zze.zza();
    }

    public final void zzp(int i) {
        this.zze.zzl(i);
    }

    public final void zzq(int i) {
        this.zze.zzm(i);
    }

    public final int zzr() {
        if (!this.zzo.zzf() && this.zzl <= 0) {
            this.zzo.zzd(this.zzt.zza, this.zzh, false);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzs(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.zzm--;
                return;
            case 1:
                this.zzk = message.arg1;
                Iterator<zzig> it = this.zzf.iterator();
                while (it.hasNext()) {
                    it.next().zzd(this.zzj, this.zzk);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.zzn = z;
                Iterator<zzig> it2 = this.zzf.iterator();
                while (it2.hasNext()) {
                    it2.next().zzc(this.zzn);
                }
                return;
            case 3:
                if (this.zzm == 0) {
                    zzpa zzpa = (zzpa) message.obj;
                    this.zzi = true;
                    this.zzq = zzpa.zza;
                    this.zzr = zzpa.zzb;
                    this.zzb.zze(zzpa.zzc);
                    Iterator<zzig> it3 = this.zzf.iterator();
                    while (it3.hasNext()) {
                        it3.next().zzb(this.zzq, this.zzr);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.zzl - 1;
                this.zzl = i;
                if (i == 0) {
                    this.zzt = (zzio) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzig> it4 = this.zzf.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzf();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzl == 0) {
                    this.zzt = (zzio) message.obj;
                    Iterator<zzig> it5 = this.zzf.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzf();
                    }
                    return;
                }
                return;
            case 6:
                zziq zziq = (zziq) message.obj;
                this.zzl -= zziq.zzd;
                if (this.zzm == 0) {
                    this.zzo = zziq.zza;
                    this.zzp = zziq.zzb;
                    this.zzt = zziq.zzc;
                    Iterator<zzig> it6 = this.zzf.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.zzo, this.zzp);
                    }
                    return;
                }
                return;
            case 7:
                zzix zzix = (zzix) message.obj;
                if (!this.zzs.equals(zzix)) {
                    this.zzs = zzix;
                    Iterator<zzig> it7 = this.zzf.iterator();
                    while (it7.hasNext()) {
                        it7.next().zzg(zzix);
                    }
                    return;
                }
                return;
            case 8:
                zzif zzif = (zzif) message.obj;
                Iterator<zzig> it8 = this.zzf.iterator();
                while (it8.hasNext()) {
                    it8.next().zze(zzif);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
