package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zza;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzan;
import com.google.android.gms.ads.internal.util.zzbl;
import com.google.android.gms.ads.internal.util.zzbm;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzaew;
import com.google.android.gms.internal.ads.zzaov;
import com.google.android.gms.internal.ads.zzapx;
import com.google.android.gms.internal.ads.zzaue;
import com.google.android.gms.internal.ads.zzauf;
import com.google.android.gms.internal.ads.zzawk;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzbav;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcj;
import com.google.android.gms.internal.ads.zzbfg;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzcvu;
import com.google.android.gms.internal.ads.zzcvv;
import com.google.android.gms.internal.ads.zzsc;
import com.google.android.gms.internal.ads.zzto;
import com.google.android.gms.internal.ads.zzud;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzs {
    private static final zzs zza = new zzs();
    private final zzbw zzA;
    private final zzbfg zzB;
    private final zzbcj zzC;
    private final zza zzb;
    private final zzn zzc;
    private final zzr zzd;
    private final zzbgr zze;
    private final zzac zzf;
    private final zzsc zzg;
    private final zzbav zzh;
    private final zzad zzi;
    private final zzto zzj;
    private final Clock zzk;
    private final zze zzl;
    private final zzaew zzm;
    private final zzan zzn;
    private final zzawk zzo;
    private final zzbcc zzq;
    private final zzaov zzr;
    private final zzbl zzs;
    private final zzx zzt;
    private final zzy zzu;
    private final zzapx zzv;
    private final zzbm zzw;
    private final zzauf zzx;
    private final zzud zzy;
    private final zzazt zzz;

    protected zzs() {
        zza zza2 = new zza();
        zzn zzn2 = new zzn();
        zzr zzr2 = new zzr();
        zzbgr zzbgr = new zzbgr();
        zzac zzt2 = zzac.zzt(Build.VERSION.SDK_INT);
        zzsc zzsc = new zzsc();
        zzbav zzbav = new zzbav();
        zzad zzad = new zzad();
        zzto zzto = new zzto();
        Clock instance = DefaultClock.getInstance();
        zze zze2 = new zze();
        zzaew zzaew = new zzaew();
        zzan zzan = new zzan();
        zzawk zzawk = new zzawk();
        zzbcc zzbcc = new zzbcc();
        zzaov zzaov = new zzaov();
        zzbl zzbl = new zzbl();
        zzx zzx2 = new zzx();
        zzy zzy2 = new zzy();
        zzapx zzapx = new zzapx();
        zzbm zzbm = new zzbm();
        zzawk zzawk2 = zzawk;
        zzan zzan2 = zzan;
        zzcvv zzcvv = new zzcvv(new zzcvu(), new zzaue());
        zzud zzud = new zzud();
        zzazt zzazt = new zzazt();
        zzbw zzbw = new zzbw();
        zzbfg zzbfg = new zzbfg();
        zzbcj zzbcj = new zzbcj();
        this.zzb = zza2;
        this.zzc = zzn2;
        this.zzd = zzr2;
        this.zze = zzbgr;
        this.zzf = zzt2;
        this.zzg = zzsc;
        this.zzh = zzbav;
        this.zzi = zzad;
        this.zzj = zzto;
        this.zzk = instance;
        this.zzl = zze2;
        this.zzm = zzaew;
        this.zzn = zzan2;
        this.zzo = zzawk2;
        this.zzq = zzbcc;
        this.zzr = zzaov;
        this.zzs = zzbl;
        this.zzt = zzx2;
        this.zzu = zzy2;
        this.zzv = zzapx;
        this.zzw = zzbm;
        this.zzx = zzcvv;
        this.zzy = zzud;
        this.zzz = zzazt;
        this.zzA = zzbw;
        this.zzB = zzbfg;
        this.zzC = zzbcj;
    }

    public static zzazt zzA() {
        return zza.zzz;
    }

    public static zza zza() {
        return zza.zzb;
    }

    public static zzn zzb() {
        return zza.zzc;
    }

    public static zzr zzc() {
        return zza.zzd;
    }

    public static zzbgr zzd() {
        return zza.zze;
    }

    public static zzac zze() {
        return zza.zzf;
    }

    public static zzsc zzf() {
        return zza.zzg;
    }

    public static zzbav zzg() {
        return zza.zzh;
    }

    public static zzad zzh() {
        return zza.zzi;
    }

    public static zzto zzi() {
        return zza.zzj;
    }

    public static Clock zzj() {
        return zza.zzk;
    }

    public static zze zzk() {
        return zza.zzl;
    }

    public static zzaew zzl() {
        return zza.zzm;
    }

    public static zzan zzm() {
        return zza.zzn;
    }

    public static zzawk zzn() {
        return zza.zzo;
    }

    public static zzbcc zzo() {
        return zza.zzq;
    }

    public static zzaov zzp() {
        return zza.zzr;
    }

    public static zzbl zzq() {
        return zza.zzs;
    }

    public static zzauf zzr() {
        return zza.zzx;
    }

    public static zzx zzs() {
        return zza.zzt;
    }

    public static zzy zzt() {
        return zza.zzu;
    }

    public static zzapx zzu() {
        return zza.zzv;
    }

    public static zzbm zzv() {
        return zza.zzw;
    }

    public static zzud zzw() {
        return zza.zzy;
    }

    public static zzbw zzx() {
        return zza.zzA;
    }

    public static zzbfg zzy() {
        return zza.zzB;
    }

    public static zzbcj zzz() {
        return zza.zzC;
    }
}
