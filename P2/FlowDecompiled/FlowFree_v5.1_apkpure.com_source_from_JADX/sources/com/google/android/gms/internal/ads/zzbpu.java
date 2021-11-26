package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbpu extends zzbom {
    private final zzaix zzc;
    private final Runnable zzd;
    private final Executor zze;

    public zzbpu(zzbqk zzbqk, zzaix zzaix, Runnable runnable, Executor executor) {
        super(zzbqk);
        this.zzc = zzaix;
        this.zzd = runnable;
        this.zze = executor;
    }

    public final void zzQ() {
        this.zze.execute(new zzbpt(this, new zzbps(new AtomicReference(this.zzd))));
    }

    public final View zza() {
        return null;
    }

    public final void zzb(ViewGroup viewGroup, zzyx zzyx) {
    }

    public final zzacj zzc() {
        return null;
    }

    public final zzdqp zze() {
        return null;
    }

    public final zzdqp zzf() {
        return null;
    }

    public final int zzg() {
        return 0;
    }

    public final void zzh() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(Runnable runnable) {
        try {
            if (!this.zzc.zzb(ObjectWrapper.wrap(runnable))) {
                runnable.run();
            }
        } catch (RemoteException unused) {
            runnable.run();
        }
    }
}
