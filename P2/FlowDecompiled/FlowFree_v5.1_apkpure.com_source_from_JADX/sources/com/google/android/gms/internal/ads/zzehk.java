package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzehk<P> {
    private final ConcurrentMap<zzehj, List<zzehi<P>>> zza = new ConcurrentHashMap();
    private zzehi<P> zzb;
    private final Class<P> zzc;

    private zzehk(Class<P> cls) {
        this.zzc = cls;
    }

    public static <P> zzehk<P> zzb(Class<P> cls) {
        return new zzehk<>(cls);
    }

    public final zzehi<P> zza() {
        return this.zzb;
    }

    public final void zzc(zzehi<P> zzehi) {
        if (zzehi.zzb() == zzeoa.ENABLED) {
            List list = (List) this.zza.get(new zzehj(zzehi.zzd(), (zzehh) null));
            if (list == null) {
                list = Collections.emptyList();
            }
            if (!list.isEmpty()) {
                this.zzb = zzehi;
                return;
            }
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
        throw new IllegalArgumentException("the primary entry has to be ENABLED");
    }

    public final zzehi<P> zzd(P p, zzeok zzeok) throws GeneralSecurityException {
        byte[] bArr;
        if (zzeok.zzd() == zzeoa.ENABLED) {
            zzepe zzepe = zzepe.UNKNOWN_PREFIX;
            int ordinal = zzeok.zzf().ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        bArr = zzegs.zza;
                    } else if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown output prefix type");
                    }
                }
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzeok.zze()).array();
            } else {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzeok.zze()).array();
            }
            zzehi zzehi = new zzehi(p, bArr, zzeok.zzd(), zzeok.zzf(), zzeok.zze());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzehi);
            zzehj zzehj = new zzehj(zzehi.zzd(), (zzehh) null);
            List list = (List) this.zza.put(zzehj, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(zzehi);
                this.zza.put(zzehj, Collections.unmodifiableList(arrayList2));
            }
            return zzehi;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public final Class<P> zze() {
        return this.zzc;
    }
}
