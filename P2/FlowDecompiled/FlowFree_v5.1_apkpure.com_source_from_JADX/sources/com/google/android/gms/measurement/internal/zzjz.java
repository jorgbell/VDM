package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
abstract class zzjz extends zzjy {
    private boolean zza;

    zzjz(zzki zzki) {
        super(zzki);
        this.zzf.zzM();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzY() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzZ() {
        if (!zzY()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzaA();

    public final void zzaa() {
        if (!this.zza) {
            zzaA();
            this.zzf.zzN();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
