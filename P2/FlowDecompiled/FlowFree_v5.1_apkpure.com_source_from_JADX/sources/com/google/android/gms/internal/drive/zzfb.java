package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import java.util.Objects;

public final class zzfb extends zzkk<zzfb, zza> implements zzls {
    private static volatile zzmb<zzfb> zzhk;
    /* access modifiers changed from: private */
    public static final zzfb zzhp;
    private int zzhd;
    private int zzhe = 1;
    private long zzhg = -1;
    private byte zzhi = 2;
    private String zzhm = "";
    private long zzhn = -1;
    private int zzho = -1;

    private zzfb() {
    }

    public static final class zza extends zzkk.zza<zzfb, zza> implements zzls {
        private zza() {
            super(zzfb.zzhp);
        }

        public final zza zzm(int i) {
            zzdb();
            ((zzfb) this.zzru).zzj(1);
            return this;
        }

        public final zza zze(String str) {
            zzdb();
            ((zzfb) this.zzru).zzd(str);
            return this;
        }

        public final zza zzg(long j) {
            zzdb();
            ((zzfb) this.zzru).zzf(j);
            return this;
        }

        public final zza zzh(long j) {
            zzdb();
            ((zzfb) this.zzru).zza(j);
            return this;
        }

        public final zza zzn(int i) {
            zzdb();
            ((zzfb) this.zzru).zzl(i);
            return this;
        }

        /* synthetic */ zza(zzfc zzfc) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzj(int i) {
        this.zzhd |= 1;
        this.zzhe = i;
    }

    /* access modifiers changed from: private */
    public final void zzd(String str) {
        Objects.requireNonNull(str);
        this.zzhd |= 2;
        this.zzhm = str;
    }

    /* access modifiers changed from: private */
    public final void zzf(long j) {
        this.zzhd |= 4;
        this.zzhn = j;
    }

    /* access modifiers changed from: private */
    public final void zza(long j) {
        this.zzhd |= 8;
        this.zzhg = j;
    }

    /* access modifiers changed from: private */
    public final void zzl(int i) {
        this.zzhd |= 16;
        this.zzho = i;
    }

    public static zza zzan() {
        return (zza) zzhp.zzcw();
    }

    /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.drive.zzmb<com.google.android.gms.internal.drive.zzfb>, com.google.android.gms.internal.drive.zzkk$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzmb<zzfb> zzmb;
        int i2 = 1;
        switch (zzfc.zzhl[i - 1]) {
            case 1:
                return new zzfb();
            case 2:
                return new zza((zzfc) null);
            case 3:
                return zzkk.zza((zzlq) zzhp, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0004\u0001Ԅ\u0000\u0002Ԉ\u0001\u0003Ԑ\u0002\u0004Ԑ\u0003\u0005\u0004\u0004", new Object[]{"zzhd", "zzhe", "zzhm", "zzhn", "zzhg", "zzho"});
            case 4:
                return zzhp;
            case 5:
                zzmb<zzfb> zzmb2 = zzhk;
                zzmb<zzfb> zzmb3 = zzmb2;
                if (zzmb2 == null) {
                    synchronized (zzfb.class) {
                        zzmb<zzfb> zzmb4 = zzhk;
                        zzmb = zzmb4;
                        if (zzmb4 == null) {
                            ? zzb = new zzkk.zzb(zzhp);
                            zzhk = zzb;
                            zzmb = zzb;
                        }
                    }
                    zzmb3 = zzmb;
                }
                return zzmb3;
            case 6:
                return Byte.valueOf(this.zzhi);
            case 7:
                if (obj == null) {
                    i2 = 0;
                }
                this.zzhi = (byte) i2;
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzfb zzfb = new zzfb();
        zzhp = zzfb;
        zzkk.zza(zzfb.class, zzfb);
    }
}
