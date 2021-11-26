package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzfw extends zzdw<Integer, Object> {
    public Long zza;
    public Boolean zzb;
    public Boolean zzc;

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zza() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        hashMap.put(2, this.zzc);
        return hashMap;
    }

    public zzfw(String str) {
        HashMap zzb2 = zzdw.zzb(str);
        if (zzb2 != null) {
            this.zza = (Long) zzb2.get(0);
            this.zzb = (Boolean) zzb2.get(1);
            this.zzc = (Boolean) zzb2.get(2);
        }
    }
}
