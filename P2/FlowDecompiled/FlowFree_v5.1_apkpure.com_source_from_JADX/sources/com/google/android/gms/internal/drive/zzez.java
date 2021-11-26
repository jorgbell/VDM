package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

public final class zzez extends zzkk<zzez, zza> implements zzls {
    /* access modifiers changed from: private */
    public static final zzez zzhj;
    private static volatile zzmb<zzez> zzhk;
    private int zzhd;
    private int zzhe = 1;
    private long zzhf = -1;
    private long zzhg = -1;
    private long zzhh = -1;
    private byte zzhi = 2;

    private zzez() {
    }

    public static final class zza extends zzkk.zza<zzez, zza> implements zzls {
        private zza() {
            super(zzez.zzhj);
        }

        public final zza zzk(int i) {
            zzdb();
            ((zzez) this.zzru).zzj(1);
            return this;
        }

        public final zza zzc(long j) {
            zzdb();
            ((zzez) this.zzru).setSequenceNumber(j);
            return this;
        }

        public final zza zzd(long j) {
            zzdb();
            ((zzez) this.zzru).zza(j);
            return this;
        }

        public final zza zze(long j) {
            zzdb();
            ((zzez) this.zzru).zzb(j);
            return this;
        }

        /* synthetic */ zza(zzfa zzfa) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzj(int i) {
        this.zzhd |= 1;
        this.zzhe = i;
    }

    /* access modifiers changed from: private */
    public final void setSequenceNumber(long j) {
        this.zzhd |= 2;
        this.zzhf = j;
    }

    /* access modifiers changed from: private */
    public final void zza(long j) {
        this.zzhd |= 4;
        this.zzhg = j;
    }

    /* access modifiers changed from: private */
    public final void zzb(long j) {
        this.zzhd |= 8;
        this.zzhh = j;
    }

    public static zza zzaj() {
        return (zza) zzhj.zzcw();
    }

    /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.drive.zzmb<com.google.android.gms.internal.drive.zzez>, com.google.android.gms.internal.drive.zzkk$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzmb<zzez> zzmb;
        int i2 = 1;
        switch (zzfa.zzhl[i - 1]) {
            case 1:
                return new zzez();
            case 2:
                return new zza((zzfa) null);
            case 3:
                return zzkk.zza((zzlq) zzhj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0004\u0001Ԅ\u0000\u0002Ԑ\u0001\u0003Ԑ\u0002\u0004Ԑ\u0003", new Object[]{"zzhd", "zzhe", "zzhf", "zzhg", "zzhh"});
            case 4:
                return zzhj;
            case 5:
                zzmb<zzez> zzmb2 = zzhk;
                zzmb<zzez> zzmb3 = zzmb2;
                if (zzmb2 == null) {
                    synchronized (zzez.class) {
                        zzmb<zzez> zzmb4 = zzhk;
                        zzmb = zzmb4;
                        if (zzmb4 == null) {
                            ? zzb = new zzkk.zzb(zzhj);
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
        zzez zzez = new zzez();
        zzhj = zzez;
        zzkk.zza(zzez.class, zzez);
    }
}
