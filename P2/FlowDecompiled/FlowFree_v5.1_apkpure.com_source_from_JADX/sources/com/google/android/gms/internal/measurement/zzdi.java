package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzdi extends zzhr<zzdi, zzdh> implements zzix {
    /* access modifiers changed from: private */
    public static final zzdi zze;
    private zzhy<zzdk> zza = zzhr.zzbE();

    static {
        zzdi zzdi = new zzdi();
        zze = zzdi;
        zzhr.zzby(zzdi.class, zzdi);
    }

    private zzdi() {
    }

    public static zzdh zzc() {
        return (zzdh) zze.zzbt();
    }

    static /* synthetic */ void zze(zzdi zzdi, zzdk zzdk) {
        zzdk.getClass();
        zzhy<zzdk> zzhy = zzdi.zza;
        if (!zzhy.zza()) {
            zzdi.zza = zzhr.zzbF(zzhy);
        }
        zzdi.zza.add(zzdk);
    }

    public final List<zzdk> zza() {
        return this.zza;
    }

    public final zzdk zzb(int i) {
        return this.zza.get(0);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzdk.class});
        } else if (i2 == 3) {
            return new zzdi();
        } else {
            if (i2 == 4) {
                return new zzdh((zzct) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
