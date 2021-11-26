package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdzn {
    private final Context zza;
    private final Executor zzb;
    private final zzdyu zzc;
    private final zzdyw zzd;
    private final zzdzm zze;
    private final zzdzm zzf;
    private Task<zzdc> zzg;
    private Task<zzdc> zzh;

    zzdzn(Context context, Executor executor, zzdyu zzdyu, zzdyw zzdyw, zzdzk zzdzk, zzdzl zzdzl) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdyu;
        this.zzd = zzdyw;
        this.zze = zzdzk;
        this.zzf = zzdzl;
    }

    public static zzdzn zza(Context context, Executor executor, zzdyu zzdyu, zzdyw zzdyw) {
        zzdzn zzdzn = new zzdzn(context, executor, zzdyu, zzdyw, new zzdzk(), new zzdzl());
        if (zzdzn.zzd.zzb()) {
            zzdzn.zzg = zzdzn.zzg(new zzdzh(zzdzn));
        } else {
            zzdzn.zzg = Tasks.forResult(zzdzn.zze.zza());
        }
        zzdzn.zzh = zzdzn.zzg(new zzdzi(zzdzn));
        return zzdzn;
    }

    private final Task<zzdc> zzg(Callable<zzdc> callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, new zzdzj(this));
    }

    private static zzdc zzh(Task<zzdc> task, zzdc zzdc) {
        if (!task.isSuccessful()) {
            return zzdc;
        }
        return task.getResult();
    }

    public final zzdc zzb() {
        return zzh(this.zzg, this.zze.zza());
    }

    public final zzdc zzc() {
        return zzh(this.zzh, this.zzf.zza());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzd(2025, -1, exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdc zze() throws Exception {
        Context context = this.zza;
        return zzdzc.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdc zzf() throws Exception {
        Context context = this.zza;
        zzcn zzj = zzdc.zzj();
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context);
        advertisingIdClient.start();
        AdvertisingIdClient.Info info = advertisingIdClient.getInfo();
        String id = info.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zzj.zzX(id);
            zzj.zzZ(info.isLimitAdTrackingEnabled());
            zzj.zzY(zzct.DEVICE_IDENTIFIER_ANDROID_AD_ID);
        }
        return (zzdc) zzj.zzah();
    }
}
