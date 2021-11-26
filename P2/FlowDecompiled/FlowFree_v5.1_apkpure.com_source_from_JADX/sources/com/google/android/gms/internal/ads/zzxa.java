package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzxa extends zzeth<zzxa, zzwz> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzxa zzp;
    private int zzb;
    private int zze = 1000;
    private int zzf = 1000;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private zzxc zzo;

    static {
        zzxa zzxa = new zzxa();
        zzp = zzxa;
        zzeth.zzay(zzxa.class, zzxa);
    }

    private zzxa() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzp, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bဉ\n", new Object[]{"zzb", "zze", zzvy.zzc(), "zzf", zzvy.zzc(), "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo"});
        } else if (i2 == 3) {
            return new zzxa();
        } else {
            if (i2 == 4) {
                return new zzwz((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzp;
        }
    }
}
