package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbgr {
    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.internal.ads.zzbgf, java.lang.Object] */
    public static final zzbgf zza(Context context, zzbhv zzbhv, String str, boolean z, boolean z2, zzfh zzfh, zzafp zzafp, zzbbq zzbbq, zzaff zzaff, zzl zzl, zza zza, zzug zzug, zzdqo zzdqo, zzdqr zzdqr) throws zzbgq {
        StrictMode.ThreadPolicy threadPolicy;
        zzaeq.zza(context);
        try {
            zzbgo zzbgo = new zzbgo(context, zzbhv, str, z, z2, zzfh, zzafp, zzbbq, (zzaff) null, zzl, zza, zzug, zzdqo, zzdqr);
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            ? zza2 = zzbgo.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return zza2;
        } catch (Throwable th) {
            throw new zzbgq("Webview initialization failed.", th);
        }
    }

    public static final zzefw<zzbgf> zzb(Context context, zzbbq zzbbq, String str, zzfh zzfh, zza zza) {
        return zzefo.zzh(zzefo.zza(null), new zzbgn(context, zzfh, zzbbq, zza, str), zzbbw.zze);
    }
}
