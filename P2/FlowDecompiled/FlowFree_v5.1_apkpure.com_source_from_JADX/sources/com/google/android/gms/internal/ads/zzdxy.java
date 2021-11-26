package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdxy {
    private final zzdxg zza;
    private final ArrayList<String> zzb;

    public zzdxy(zzdxg zzdxg, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.zzb = arrayList;
        this.zza = zzdxg;
        arrayList.add(str);
    }

    public final void zza(String str) {
        this.zzb.add(str);
    }

    public final zzdxg zzb() {
        return this.zza;
    }

    public final ArrayList<String> zzc() {
        return this.zzb;
    }
}
