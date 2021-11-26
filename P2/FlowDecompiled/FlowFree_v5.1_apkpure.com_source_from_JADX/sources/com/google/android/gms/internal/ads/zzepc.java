package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzepc extends zzeth<zzepc, zzepb> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzepc zzf;
    private String zzb = "";
    private zzeod zze;

    static {
        zzepc zzepc = new zzepc();
        zzf = zzepc;
        zzeth.zzay(zzepc.class, zzepc);
    }

    private zzepc() {
    }

    public static zzepc zzd(zzesf zzesf, zzest zzest) throws zzett {
        return (zzepc) zzeth.zzaI(zzf, zzesf, zzest);
    }

    public static zzepc zze() {
        return zzf;
    }

    public final String zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzepc();
        } else {
            if (i2 == 4) {
                return new zzepb((zzepa) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzeod zzc() {
        zzeod zzeod = this.zze;
        return zzeod == null ? zzeod.zzd() : zzeod;
    }
}
