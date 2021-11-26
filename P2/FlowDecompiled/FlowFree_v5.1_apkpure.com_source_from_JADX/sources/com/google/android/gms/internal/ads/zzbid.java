package com.google.android.gms.internal.ads;

import android.app.NotificationManager;
import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.nonagon.signalgeneration.zza;
import com.google.android.gms.ads.nonagon.signalgeneration.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzbid implements zzblo {
    @GuardedBy("AppComponent.class")
    private static zzbid zza;

    public static zzbid zza(Context context, zzaqb zzaqb, int i) {
        zzbid zzb = zzb(context, i);
        zzb.zzi().zza(zzaqb);
        return zzb;
    }

    @Deprecated
    public static zzbid zzb(Context context, int i) {
        synchronized (zzbid.class) {
            zzbid zzbid = zza;
            if (zzbid != null) {
                return zzbid;
            }
            return zzc(new zzbbq(210890000, i, true, false), context, new zzbjc());
        }
    }

    @Deprecated
    public static synchronized zzbid zzc(zzbbq zzbbq, Context context, zzbkp zzbkp) {
        zzbid zzbid;
        synchronized (zzbid.class) {
            if (zza == null) {
                zzbjx zzbjx = new zzbjx((zzbjd) null);
                zzbif zzbif = new zzbif();
                zzbif.zza(zzbbq);
                zzbif.zzb(context);
                zzbjx.zza(new zzbig(zzbif, (zzbie) null));
                zzbjx.zzb(new zzbkq(zzbkp));
                zza = zzbjx.zzc();
                zzaeq.zza(context);
                zzs.zzg().zze(context, zzbbq);
                zzs.zzi().zza(context);
                zzs.zzc().zzc(context);
                zzs.zzc().zzd(context);
                zzs.zzc().zzn(context);
                zzd.zza(context);
                zzs.zzf().zza(context);
                zzs.zzc();
                if (PlatformVersion.isAtLeastO()) {
                    if (!Arrays.asList(context.databaseList()).contains("AdMobOfflineBufferedPings.db")) {
                        ((NotificationManager) context.getSystemService("notification")).deleteNotificationChannel("offline_notification_channel");
                    }
                }
                zzs.zzx().zza(context);
                zzazu.zzd(context);
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeo)).booleanValue()) {
                    if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzap)).booleanValue()) {
                        zzug zzug = new zzug(new zzum(context));
                        zzcuk zzcuk = new zzcuk(new zzcug(context), zza.zzg());
                        zzs.zzc();
                        new zzcvc(context, zzbbq, zzug, zzcuk, UUID.randomUUID().toString(), zza.zzd()).zza(zzs.zzg().zzl().zzB());
                    }
                }
            }
            zzbid = zza;
        }
        return zzbid;
    }

    /* access modifiers changed from: protected */
    public abstract zzdjr zzA(zzdky zzdky);

    public abstract zzcop zzB();

    public abstract zzdvo zzd();

    public abstract Executor zze();

    public abstract ScheduledExecutorService zzf();

    public abstract zzefx zzg();

    public abstract zzbwr zzh();

    public abstract zzclg zzi();

    public abstract zzbkx zzj();

    public abstract zzbpi zzk();

    public abstract zzdnc zzl();

    public abstract zzbno zzm();

    public abstract zzbnz zzn();

    public abstract zzdls zzo();

    public abstract zzcco zzp();

    public abstract zzdov zzq();

    public abstract zzcdk zzr();

    public abstract zzcka zzs();

    public abstract zzdqh zzt();

    public abstract zza zzu();

    public abstract zzp zzv();

    public abstract zzcvs zzw();

    public abstract zzdry<zzcjo> zzx();

    public abstract zzcpz zzy();

    public final zzdjr zzz(zzawc zzawc, int i) {
        return zzA(new zzdky(zzawc, i));
    }
}
