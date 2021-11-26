package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.AdError;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeaw {
    private static final HashMap<String, Class<?>> zza = new HashMap<>();
    private final Context zzb;
    private final zzeax zzc;
    private final zzdyu zzd;
    private final zzdyq zze;
    private zzeal zzf;
    private final Object zzg = new Object();

    public zzeaw(Context context, zzeax zzeax, zzdyu zzdyu, zzdyq zzdyq) {
        this.zzb = context;
        this.zzc = zzeax;
        this.zzd = zzdyu;
        this.zze = zzdyq;
    }

    private final synchronized Class<?> zzd(zzeam zzeam) throws zzeav {
        String zza2 = zzeam.zza().zza();
        HashMap<String, Class<?>> hashMap = zza;
        Class<?> cls = hashMap.get(zza2);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.zze.zza(zzeam.zzb())) {
                File zzc2 = zzeam.zzc();
                if (!zzc2.exists()) {
                    zzc2.mkdirs();
                }
                Class<?> loadClass = new DexClassLoader(zzeam.zzb().getAbsolutePath(), zzc2.getAbsolutePath(), (String) null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                hashMap.put(zza2, loadClass);
                return loadClass;
            }
            throw new zzeav(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e) {
            throw new zzeav(2026, (Throwable) e);
        } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
            throw new zzeav((int) AdError.REMOTE_ADS_SERVICE_ERROR, e2);
        }
    }

    public final boolean zza(zzeam zzeam) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class<?> zzd2 = zzd(zzeam);
            zzeal zzeal = new zzeal(zzd2.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.zzb, "msa-r", zzeam.zzd(), null, new Bundle(), 2}), zzeam, this.zzc, this.zzd);
            if (zzeal.zzf()) {
                int zzh = zzeal.zzh();
                if (zzh == 0) {
                    synchronized (this.zzg) {
                        zzeal zzeal2 = this.zzf;
                        if (zzeal2 != null) {
                            try {
                                zzeal2.zzg();
                            } catch (zzeav e) {
                                this.zzd.zzd(e.zza(), -1, e);
                            }
                        }
                        this.zzf = zzeal;
                    }
                    this.zzd.zzc(3000, System.currentTimeMillis() - currentTimeMillis);
                    return true;
                }
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(zzh);
                throw new zzeav(4001, sb.toString());
            }
            throw new zzeav(4000, "init failed");
        } catch (Exception e2) {
            throw new zzeav((int) AdError.INTERNAL_ERROR_2004, (Throwable) e2);
        } catch (zzeav e3) {
            this.zzd.zzd(e3.zza(), System.currentTimeMillis() - currentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzd(4010, System.currentTimeMillis() - currentTimeMillis, e4);
            return false;
        }
    }

    public final zzdyx zzb() {
        zzeal zzeal;
        synchronized (this.zzg) {
            zzeal = this.zzf;
        }
        return zzeal;
    }

    public final zzeam zzc() {
        synchronized (this.zzg) {
            zzeal zzeal = this.zzf;
            if (zzeal == null) {
                return null;
            }
            zzeam zze2 = zzeal.zze();
            return zze2;
        }
    }
}
