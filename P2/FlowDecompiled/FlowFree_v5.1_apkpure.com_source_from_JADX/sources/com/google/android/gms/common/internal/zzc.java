package com.google.android.gms.common.internal;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class zzc<TListener> {
    private TListener zza;
    private boolean zzb = false;
    final /* synthetic */ BaseGmsClient zzd;

    public zzc(BaseGmsClient baseGmsClient, TListener tlistener) {
        this.zzd = baseGmsClient;
        this.zza = tlistener;
    }

    /* access modifiers changed from: protected */
    public abstract void zzc();

    /* access modifiers changed from: protected */
    public abstract void zzd(TListener tlistener);

    public final void zze() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.zza;
            if (this.zzb) {
                String valueOf = String.valueOf(this);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                sb.append("Callback proxy ");
                sb.append(valueOf);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (tlistener != null) {
            try {
                zzd(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.zzb = true;
        }
        zzf();
    }

    public final void zzf() {
        zzg();
        synchronized (this.zzd.zzt) {
            this.zzd.zzt.remove(this);
        }
    }

    public final void zzg() {
        synchronized (this) {
            this.zza = null;
        }
    }
}
