package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzas;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaop extends zzbci<zzanl> {
    private final Object zza = new Object();
    private boolean zzc = false;
    private int zzd = 0;

    public zzaop(zzas<zzanl> zzas) {
    }

    public final zzaok zza() {
        zzaok zzaok = new zzaok(this);
        synchronized (this.zza) {
            zze(new zzaol(this, zzaok), new zzaom(this, zzaok));
            Preconditions.checkState(this.zzd >= 0);
            this.zzd++;
        }
        return zzaok;
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        synchronized (this.zza) {
            Preconditions.checkState(this.zzd > 0);
            zze.zza("Releasing 1 reference for JS Engine");
            this.zzd--;
            zzd();
        }
    }

    public final void zzc() {
        synchronized (this.zza) {
            Preconditions.checkState(this.zzd >= 0);
            zze.zza("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzc = true;
            zzd();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        synchronized (this.zza) {
            Preconditions.checkState(this.zzd >= 0);
            if (!this.zzc || this.zzd != 0) {
                zze.zza("There are still references to the engine. Not destroying.");
            } else {
                zze.zza("No reference is left (including root). Cleaning up engine.");
                zze(new zzaoo(this), new zzbce());
            }
        }
    }
}
