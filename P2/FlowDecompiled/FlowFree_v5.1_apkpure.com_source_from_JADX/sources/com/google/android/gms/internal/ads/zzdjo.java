package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdjo implements zzdiz<zzdjp> {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final zzbao zze;

    public zzdjo(zzbao zzbao, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, byte[] bArr) {
        this.zze = zzbao;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
    }

    public final zzefw<zzdjp> zza() {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzaF)).booleanValue()) {
            return zzefo.zzb(new Exception("Did not ad Ad ID into query param."));
        }
        return zzefo.zze((zzeff) zzefo.zzg(zzefo.zzi(zzeff.zzw(this.zze.zza(this.zza, this.zzd)), zzdjm.zza, this.zzc), ((Long) zzaaa.zzc().zzb(zzaeq.zzaG)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzdjn(this), this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdjp zzb(Throwable th) {
        String str;
        zzzy.zza();
        ContentResolver contentResolver = this.zza.getContentResolver();
        if (contentResolver == null) {
            str = null;
        } else {
            str = Settings.Secure.getString(contentResolver, "android_id");
        }
        return new zzdjp((AdvertisingIdClient.Info) null, str);
    }
}
