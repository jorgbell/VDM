package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeol extends zzeth<zzeol, zzeoi> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeol zzf;
    private int zzb;
    private zzetq<zzeok> zze = zzeth.zzaE();

    static {
        zzeol zzeol = new zzeol();
        zzf = zzeol;
        zzeth.zzay(zzeol.class, zzeol);
    }

    private zzeol() {
    }

    public static zzeol zze(byte[] bArr, zzest zzest) throws zzett {
        return (zzeol) zzeth.zzaK(zzf, bArr, zzest);
    }

    public final int zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzb", "zze", zzeok.class});
        } else if (i2 == 3) {
            return new zzeol();
        } else {
            if (i2 == 4) {
                return new zzeoi((zzeoh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final List<zzeok> zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }
}
