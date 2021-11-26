package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdzt extends zzeth<zzdzt, zzdzs> implements zzeup {
    private static final zzetn<Integer, zzdzr> zzf = new zzdzo();
    /* access modifiers changed from: private */
    public static final zzdzt zzj;
    private int zzb;
    private zzetm zze = zzeth.zzaB();
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzdzt zzdzt = new zzdzt();
        zzj = zzdzt;
        zzeth.zzay(zzdzt.class, zzdzt);
    }

    private zzdzt() {
    }

    public static zzdzs zza() {
        return (zzdzs) zzj.zzas();
    }

    static /* synthetic */ void zzd(zzdzt zzdzt, zzdzr zzdzr) {
        zzdzr.getClass();
        zzetm zzetm = zzdzt.zze;
        if (!zzetm.zza()) {
            zzdzt.zze = zzeth.zzaC(zzetm);
        }
        zzdzt.zze.zzh(zzdzr.zza());
    }

    static /* synthetic */ void zze(zzdzt zzdzt, String str) {
        str.getClass();
        zzdzt.zzb |= 1;
        zzdzt.zzg = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzb", "zze", zzdzr.zzc(), "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzdzt();
        } else {
            if (i2 == 4) {
                return new zzdzs((zzdzo) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }
}
