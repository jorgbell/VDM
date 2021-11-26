package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdym extends zzdyh {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: long} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.HashSet] */
    /* JADX WARNING: type inference failed for: r3v0, types: [org.json.JSONObject] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzdym(com.google.android.gms.internal.ads.zzdya r8, com.google.android.gms.internal.ads.zzdya r9, java.util.HashSet<java.lang.String> r10, org.json.JSONObject r11, long r12) {
        /*
            r7 = this;
            r6 = 0
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdym.<init>(com.google.android.gms.internal.ads.zzdya, java.util.HashSet, org.json.JSONObject, long, byte[]):void");
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzdxu.zzi(this.zzb, this.zzd.zzd())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        zzdxd zza;
        if (!TextUtils.isEmpty(str) && (zza = zzdxd.zza()) != null) {
            for (zzdws next : zza.zze()) {
                if (this.zza.contains(next.zzi())) {
                    next.zzh().zzf(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
