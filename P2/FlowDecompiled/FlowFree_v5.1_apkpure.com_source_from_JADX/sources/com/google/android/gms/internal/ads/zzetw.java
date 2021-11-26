package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzetw {
    protected volatile zzeuo zza;
    private volatile zzesf zzc;

    static {
        zzest.zza();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzetw)) {
            return false;
        }
        zzetw zzetw = (zzetw) obj;
        zzeuo zzeuo = this.zza;
        zzeuo zzeuo2 = zzetw.zza;
        if (zzeuo == null && zzeuo2 == null) {
            return zzb().equals(zzetw.zzb());
        }
        if (zzeuo != null && zzeuo2 != null) {
            return zzeuo.equals(zzeuo2);
        }
        if (zzeuo != null) {
            zzetw.zzc(zzeuo.zzbe());
            return zzeuo.equals(zzetw.zza);
        }
        zzc(zzeuo2.zzbe());
        return this.zza.equals(zzeuo2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzesc) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzaw();
        }
        return 0;
    }

    public final zzesf zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzesf zzesf = this.zzc;
                return zzesf;
            }
            if (this.zza == null) {
                this.zzc = zzesf.zzb;
            } else {
                this.zzc = this.zza.zzan();
            }
            zzesf zzesf2 = this.zzc;
            return zzesf2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.ads.zzeuo r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzeuo r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzeuo r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzett -> 0x0011 }
            com.google.android.gms.internal.ads.zzesf r0 = com.google.android.gms.internal.ads.zzesf.zzb     // Catch:{ zzett -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzett -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzesf r2 = com.google.android.gms.internal.ads.zzesf.zzb     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzetw.zzc(com.google.android.gms.internal.ads.zzeuo):void");
    }
}
