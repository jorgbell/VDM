package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzczk {
    /* access modifiers changed from: private */
    public final Clock zza;
    /* access modifiers changed from: private */
    public final zzczl zzb;
    private final List<String> zzc = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final boolean zzd;
    /* access modifiers changed from: private */
    public final zzcwb zze;

    public zzczk(Clock clock, zzczl zzczl, zzcwb zzcwb) {
        this.zza = clock;
        this.zzb = zzczl;
        this.zzd = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzeR)).booleanValue();
        this.zze = zzcwb;
    }

    static /* synthetic */ void zzd(zzczk zzczk, String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 1 + String.valueOf(str2).length());
            sb3.append(sb2);
            sb3.append(".");
            sb3.append(str2);
            sb2 = sb3.toString();
        }
        zzczk.zzc.add(sb2);
    }

    /* access modifiers changed from: package-private */
    public final <T> zzefw<T> zza(zzdqr zzdqr, zzdqo zzdqo, zzefw<T> zzefw) {
        long elapsedRealtime = this.zza.elapsedRealtime();
        String str = zzdqo.zzv;
        if (str != null) {
            zzefo.zzo(zzefw, new zzczj(this, elapsedRealtime, str, zzdqo, zzdqr), zzbbw.zzf);
        }
        return zzefw;
    }

    public final String zzb() {
        return TextUtils.join("_", this.zzc);
    }
}
