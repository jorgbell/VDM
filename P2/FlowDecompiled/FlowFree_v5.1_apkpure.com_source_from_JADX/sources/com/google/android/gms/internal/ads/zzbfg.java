package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbfg implements Iterable<zzbff> {
    private final List<zzbff> zza = new ArrayList();

    static final zzbff zzc(zzbdp zzbdp) {
        Iterator<zzbff> it = zzs.zzy().iterator();
        while (it.hasNext()) {
            zzbff next = it.next();
            if (next.zza == zzbdp) {
                return next;
            }
        }
        return null;
    }

    public static final boolean zzd(zzbdp zzbdp) {
        zzbff zzc = zzc(zzbdp);
        if (zzc == null) {
            return false;
        }
        zzc.zzb.zzg();
        return true;
    }

    public final Iterator<zzbff> iterator() {
        return this.zza.iterator();
    }

    public final void zza(zzbff zzbff) {
        this.zza.add(zzbff);
    }

    public final void zzb(zzbff zzbff) {
        this.zza.remove(zzbff);
    }
}
