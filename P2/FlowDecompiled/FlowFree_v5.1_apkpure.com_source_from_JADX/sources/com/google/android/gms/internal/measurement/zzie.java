package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
public class zzie {
    protected volatile zziw zza;
    private volatile zzgr zzc;

    static {
        zzhd.zza();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzie)) {
            return false;
        }
        zzie zzie = (zzie) obj;
        zziw zziw = this.zza;
        zziw zziw2 = zzie.zza;
        if (zziw == null && zziw2 == null) {
            return zzb().equals(zzie.zzb());
        }
        if (zziw != null && zziw2 != null) {
            return zziw.equals(zziw2);
        }
        if (zziw != null) {
            zzie.zzc(zziw.zzbK());
            return zziw.equals(zzie.zza);
        }
        zzc(zziw2.zzbK());
        return this.zza.equals(zziw2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzgp) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzbw();
        }
        return 0;
    }

    public final zzgr zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzgr zzgr = this.zzc;
                return zzgr;
            }
            if (this.zza == null) {
                this.zzc = zzgr.zzb;
            } else {
                this.zzc = this.zza.zzbo();
            }
            zzgr zzgr2 = this.zzc;
            return zzgr2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.measurement.zziw r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zziw r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zziw r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzib -> 0x0011 }
            com.google.android.gms.internal.measurement.zzgr r0 = com.google.android.gms.internal.measurement.zzgr.zzb     // Catch:{ zzib -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzib -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.measurement.zzgr r2 = com.google.android.gms.internal.measurement.zzgr.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzie.zzc(com.google.android.gms.internal.measurement.zziw):void");
    }
}
