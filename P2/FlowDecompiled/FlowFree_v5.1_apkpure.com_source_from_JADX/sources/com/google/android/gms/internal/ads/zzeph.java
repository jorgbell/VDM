package com.google.android.gms.internal.ads;

import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeph extends zzeth<zzeph, zzepg> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeph zzf;
    private String zzb = "";
    private zzetq<zzeog> zze = zzeth.zzaE();

    static {
        zzeph zzeph = new zzeph();
        zzf = zzeph;
        zzeth.zzay(zzeph.class, zzeph);
    }

    private zzeph() {
    }

    public static zzeph zzc() {
        return zzf;
    }

    public final List<zzeog> zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzb", "zze", zzeog.class});
        } else if (i2 == 3) {
            return new zzeph();
        } else {
            if (i2 == 4) {
                return new zzepg((zzepf) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
