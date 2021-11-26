package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdbu {
    private final ConcurrentHashMap<String, zzasi> zza = new ConcurrentHashMap<>();
    private final zzclg zzb;

    public zzdbu(zzclg zzclg) {
        this.zzb = zzclg;
    }

    public final void zza(String str) {
        try {
            this.zza.put(str, this.zzb.zzc(str));
        } catch (RemoteException e) {
            zzbbk.zzg("Couldn't create RTB adapter : ", e);
        }
    }

    @CheckForNull
    public final zzasi zzb(String str) {
        if (this.zza.containsKey(str)) {
            return this.zza.get(str);
        }
        return null;
    }
}
