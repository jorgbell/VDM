package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzcq extends zzhr<zzcq, zzcp> implements zzix {
    /* access modifiers changed from: private */
    public static final zzcq zzn;
    private int zza;
    private long zze;
    private String zzf = "";
    private int zzg;
    private zzhy<zzcs> zzh = zzhr.zzbE();
    private zzhy<zzco> zzi = zzhr.zzbE();
    /* access modifiers changed from: private */
    public zzhy<zzbv> zzj = zzhr.zzbE();
    private String zzk = "";
    private boolean zzl;
    private zzhy<zzec> zzm = zzhr.zzbE();

    static {
        zzcq zzcq = new zzcq();
        zzn = zzcq;
        zzhr.zzby(zzcq.class, zzcq);
    }

    private zzcq() {
    }

    public static zzcp zzj() {
        return (zzcp) zzn.zzbt();
    }

    public static zzcq zzk() {
        return zzn;
    }

    static /* synthetic */ void zzn(zzcq zzcq, int i, zzco zzco) {
        zzco.getClass();
        zzhy<zzco> zzhy = zzcq.zzi;
        if (!zzhy.zza()) {
            zzcq.zzi = zzhr.zzbF(zzhy);
        }
        zzcq.zzi.set(i, zzco);
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final long zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final List<zzcs> zze() {
        return this.zzh;
    }

    public final int zzf() {
        return this.zzi.size();
    }

    public final zzco zzg(int i) {
        return this.zzi.get(i);
    }

    public final List<zzbv> zzh() {
        return this.zzj;
    }

    public final boolean zzi() {
        return this.zzl;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", zzcs.class, "zzi", zzco.class, "zzj", zzbv.class, "zzk", "zzl", "zzm", zzec.class});
        } else if (i2 == 3) {
            return new zzcq();
        } else {
            if (i2 == 4) {
                return new zzcp((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzn;
        }
    }
}
