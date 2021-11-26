package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcwb {
    private final List<zzzb> zza = Collections.synchronizedList(new ArrayList());
    private final Map<String, zzzb> zzb = Collections.synchronizedMap(new HashMap());
    private zzdqo zzc = null;

    public final void zza(zzdqo zzdqo) {
        String str = zzdqo.zzv;
        if (!this.zzb.containsKey(str)) {
            Bundle bundle = new Bundle();
            Iterator<String> keys = zzdqo.zzu.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    bundle.putString(next, zzdqo.zzu.getString(next));
                } catch (JSONException unused) {
                }
            }
            zzzb zzzb = new zzzb(zzdqo.zzD, 0, (zzym) null, bundle);
            this.zza.add(zzzb);
            this.zzb.put(str, zzzb);
        }
    }

    public final void zzb(zzdqo zzdqo, long j, zzym zzym) {
        String str = zzdqo.zzv;
        if (this.zzb.containsKey(str)) {
            if (this.zzc == null) {
                this.zzc = zzdqo;
            }
            zzzb zzzb = this.zzb.get(str);
            zzzb.zzb = j;
            zzzb.zzc = zzym;
        }
    }

    public final zzbty zzc() {
        return new zzbty(this.zzc, "", this);
    }

    public final List<zzzb> zzd() {
        return this.zza;
    }
}
