package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzeyd {
    public static zzeyd zzb(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzexy(cls.getSimpleName());
        }
        return new zzeya(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
