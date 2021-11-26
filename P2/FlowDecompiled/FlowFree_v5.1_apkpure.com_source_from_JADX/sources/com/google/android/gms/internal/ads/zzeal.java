package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.AdError;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeal implements zzdyx {
    private final Object zza;
    private final zzeam zzb;
    private final zzeax zzc;
    private final zzdyu zzd;

    zzeal(Object obj, zzeam zzeam, zzeax zzeax, zzdyu zzdyu) {
        this.zza = obj;
        this.zzb = zzeam;
        this.zzc = zzeax;
        this.zzd = zzdyu;
    }

    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzdu zza2 = zzdv.zza();
        zza2.zzc(zzdj.DG);
        zza2.zza(zzesf.zzs(bArr));
        return Base64.encodeToString(((zzdv) zza2.zzah()).zzao(), 11);
    }

    private final synchronized byte[] zzj(Map<String, String> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.zzd.zzd(2007, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) this.zza.getClass().getDeclaredMethod("xss", new Class[]{Map.class, Map.class}).invoke(this.zza, new Object[]{null, map2});
    }

    public final synchronized String zza(Context context, String str) {
        Map<String, Object> zzb2;
        zzb2 = this.zzc.zzb();
        zzb2.put("f", "q");
        zzb2.put("ctx", context);
        zzb2.put("aid", (Object) null);
        return zzi(zzj((Map<String, String>) null, zzb2));
    }

    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map<String, Object> zzc2;
        zzc2 = this.zzc.zzc();
        zzc2.put("f", "v");
        zzc2.put("ctx", context);
        zzc2.put("aid", (Object) null);
        zzc2.put("view", view);
        zzc2.put("act", (Object) null);
        return zzi(zzj((Map<String, String>) null, zzc2));
    }

    public final synchronized String zzc(Context context, String str, String str2, View view, Activity activity) {
        Map<String, Object> zzd2;
        zzd2 = this.zzc.zzd();
        zzd2.put("f", "c");
        zzd2.put("ctx", context);
        zzd2.put("cs", str2);
        zzd2.put("aid", (Object) null);
        zzd2.put("view", view);
        zzd2.put("act", activity);
        return zzi(zzj((Map<String, String>) null, zzd2));
    }

    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzeav {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put("aid", (Object) null);
            hashMap.put("evt", motionEvent);
            this.zza.getClass().getDeclaredMethod("he", new Class[]{Map.class}).invoke(this.zza, new Object[]{hashMap});
            this.zzd.zzc(3003, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzeav(2005, (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzeam zze() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzf() throws zzeav {
        try {
        } catch (Exception e) {
            throw new zzeav((int) AdError.INTERNAL_ERROR_CODE, (Throwable) e);
        }
        return ((Boolean) this.zza.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zza, new Object[0])).booleanValue();
    }

    public final synchronized void zzg() throws zzeav {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zza.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zza, new Object[0]);
            this.zzd.zzc(AdError.MEDIATION_ERROR_CODE, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzeav((int) AdError.INTERNAL_ERROR_2003, (Throwable) e);
        }
    }

    public final synchronized int zzh() throws zzeav {
        try {
        } catch (Exception e) {
            throw new zzeav((int) AdError.INTERNAL_ERROR_2006, (Throwable) e);
        }
        return ((Integer) this.zza.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zza, new Object[0])).intValue();
    }
}
