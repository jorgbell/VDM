package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzus extends zzeth<zzus, zzur> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzus zzp;
    private int zzb;
    private int zze;
    private int zzf = 1000;
    private zzvk zzg;
    private zzvm zzh;
    private zzetq<zzvi> zzi = zzeth.zzaE();
    private zzvo zzj;
    private zzxa zzk;
    private zzwq zzl;
    private zzwe zzm;
    private zzwg zzn;
    private zzetq<zzxm> zzo = zzeth.zzaE();

    static {
        zzus zzus = new zzus();
        zzp = zzus;
        zzeth.zzay(zzus.class, zzus);
    }

    private zzus() {
    }

    public static zzus zzc() {
        return zzp;
    }

    static /* synthetic */ void zze(zzus zzus, zzuq zzuq) {
        zzus.zze = zzuq.zza();
        zzus.zzb |= 1;
    }

    static /* synthetic */ void zzf(zzus zzus, zzvm zzvm) {
        zzvm.getClass();
        zzus.zzh = zzvm;
        zzus.zzb |= 8;
    }

    public final zzvm zza() {
        zzvm zzvm = this.zzh;
        return zzvm == null ? zzvm.zza() : zzvm;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzp, "\u0001\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007ဌ\u0000\bဌ\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zzb", "zze", zzuq.zzc(), "zzf", zzvy.zzc(), "zzg", "zzh", "zzi", zzvi.class, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzxm.class});
        } else if (i2 == 3) {
            return new zzus();
        } else {
            if (i2 == 4) {
                return new zzur((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzp;
        }
    }
}
