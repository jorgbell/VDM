package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzvm extends zzeth<zzvm, zzvl> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzvm zzj;
    private int zzb;
    private String zze = "";
    private zzetq<zzvi> zzf = zzeth.zzaE();
    private int zzg = 1000;
    private int zzh = 1000;
    private int zzi = 1000;

    static {
        zzvm zzvm = new zzvm();
        zzj = zzvm;
        zzeth.zzay(zzvm.class, zzvm);
    }

    private zzvm() {
    }

    public static zzvm zza() {
        return zzj;
    }

    static /* synthetic */ void zzd(zzvm zzvm, String str) {
        str.getClass();
        zzvm.zzb |= 1;
        zzvm.zze = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဌ\u0001\u0004ဌ\u0002\u0005ဌ\u0003", new Object[]{"zzb", "zze", "zzf", zzvi.class, "zzg", zzvy.zzc(), "zzh", zzvy.zzc(), "zzi", zzvy.zzc()});
        } else if (i2 == 3) {
            return new zzvm();
        } else {
            if (i2 == 4) {
                return new zzvl((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }
}
