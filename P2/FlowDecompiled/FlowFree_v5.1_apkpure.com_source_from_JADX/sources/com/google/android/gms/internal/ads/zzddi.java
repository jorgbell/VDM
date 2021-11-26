package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzddi extends zzaat {
    private final zzyx zza;
    private final Context zzb;
    private final zzdot zzc;
    private final String zzd;
    private final zzdda zze;
    private final zzdps zzf;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzcbs zzg;
    @GuardedBy("this")
    private boolean zzh = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzat)).booleanValue();

    public zzddi(Context context, zzyx zzyx, String str, zzdot zzdot, zzdda zzdda, zzdps zzdps) {
        this.zza = zzyx;
        this.zzd = str;
        this.zzb = context;
        this.zzc = zzdot;
        this.zze = zzdda;
        this.zzf = zzdps;
    }

    private final synchronized boolean zzM() {
        zzcbs zzcbs;
        zzcbs = this.zzg;
        return zzcbs != null && !zzcbs.zzb();
    }

    public final synchronized boolean zzA() {
        return this.zzc.zzb();
    }

    public final void zzB(zzawy zzawy) {
        this.zzf.zzp(zzawy);
    }

    public final void zzC(String str) {
    }

    public final void zzD(String str) {
    }

    public final zzacj zzE() {
        return null;
    }

    public final void zzF(zzady zzady) {
    }

    public final void zzG(zzacn zzacn) {
    }

    public final void zzH(zzzd zzzd) {
    }

    public final void zzI(zzte zzte) {
    }

    public final synchronized void zzJ(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzh = z;
    }

    public final void zzO(zzacd zzacd) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zze.zzp(zzacd);
    }

    public final void zzP(zzys zzys, zzaak zzaak) {
        this.zze.zzr(zzaak);
        zze(zzys);
    }

    public final synchronized void zzQ(IObjectWrapper iObjectWrapper) {
        if (this.zzg == null) {
            zzbbk.zzi("Interstitial can not be shown before loaded.");
            this.zze.zzi(zzdsb.zzd(9, (String) null, (zzym) null));
            return;
        }
        this.zzg.zza(this.zzh, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzR(zzabi zzabi) {
        this.zze.zzs(zzabi);
    }

    public final void zzab(zzabf zzabf) {
    }

    public final IObjectWrapper zzb() {
        return null;
    }

    public final synchronized boolean zzbI() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzM();
    }

    public final synchronized void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcbs zzcbs = this.zzg;
        if (zzcbs != null) {
            zzcbs.zzl().zzc((Context) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze(com.google.android.gms.internal.ads.zzys r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0051 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0051 }
            android.content.Context r0 = r4.zzb     // Catch:{ all -> 0x0051 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzr.zzJ(r0)     // Catch:{ all -> 0x0051 }
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzyk r0 = r5.zzs     // Catch:{ all -> 0x0051 }
            if (r0 != 0) goto L_0x002a
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.internal.ads.zzbbk.zzf(r5)     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzdda r5 = r4.zze     // Catch:{ all -> 0x0051 }
            if (r5 == 0) goto L_0x0028
            r0 = 4
            com.google.android.gms.internal.ads.zzym r0 = com.google.android.gms.internal.ads.zzdsb.zzd(r0, r2, r2)     // Catch:{ all -> 0x0051 }
            r5.zzbC(r0)     // Catch:{ all -> 0x0051 }
        L_0x0028:
            monitor-exit(r4)
            return r1
        L_0x002a:
            boolean r0 = r4.zzM()     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0032
            monitor-exit(r4)
            return r1
        L_0x0032:
            android.content.Context r0 = r4.zzb     // Catch:{ all -> 0x0051 }
            boolean r1 = r5.zzf     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzdrw.zzb(r0, r1)     // Catch:{ all -> 0x0051 }
            r4.zzg = r2     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzdot r0 = r4.zzc     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = r4.zzd     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzdom r2 = new com.google.android.gms.internal.ads.zzdom     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzyx r3 = r4.zza     // Catch:{ all -> 0x0051 }
            r2.<init>(r3)     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzddh r3 = new com.google.android.gms.internal.ads.zzddh     // Catch:{ all -> 0x0051 }
            r3.<init>(r4)     // Catch:{ all -> 0x0051 }
            boolean r5 = r0.zza(r5, r1, r2, r3)     // Catch:{ all -> 0x0051 }
            monitor-exit(r4)
            return r5
        L_0x0051:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzddi.zze(com.google.android.gms.internal.ads.zzys):boolean");
    }

    public final synchronized void zzf() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzcbs zzcbs = this.zzg;
        if (zzcbs != null) {
            zzcbs.zzl().zza((Context) null);
        }
    }

    public final synchronized void zzg() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzcbs zzcbs = this.zzg;
        if (zzcbs != null) {
            zzcbs.zzl().zzb((Context) null);
        }
    }

    public final void zzh(zzaah zzaah) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zze.zzn(zzaah);
    }

    public final void zzi(zzabb zzabb) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zze.zzo(zzabb);
    }

    public final void zzj(zzaay zzaay) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle zzk() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final synchronized void zzl() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        zzcbs zzcbs = this.zzg;
        if (zzcbs != null) {
            zzcbs.zza(this.zzh, (Activity) null);
        }
    }

    public final void zzm() {
    }

    public final zzyx zzn() {
        return null;
    }

    public final void zzo(zzyx zzyx) {
    }

    public final void zzp(zzaus zzaus) {
    }

    public final void zzq(zzauv zzauv, String str) {
    }

    public final synchronized String zzr() {
        zzcbs zzcbs = this.zzg;
        if (zzcbs == null || zzcbs.zzm() == null) {
            return null;
        }
        return this.zzg.zzm().zze();
    }

    public final synchronized String zzs() {
        zzcbs zzcbs = this.zzg;
        if (zzcbs == null || zzcbs.zzm() == null) {
            return null;
        }
        return this.zzg.zzm().zze();
    }

    public final synchronized zzacg zzt() {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzeP)).booleanValue()) {
            return null;
        }
        zzcbs zzcbs = this.zzg;
        if (zzcbs == null) {
            return null;
        }
        return zzcbs.zzm();
    }

    public final synchronized String zzu() {
        return this.zzd;
    }

    public final zzabb zzv() {
        return this.zze.zzm();
    }

    public final zzaah zzw() {
        return this.zze.zzl();
    }

    public final synchronized void zzx(zzafl zzafl) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzc.zzc(zzafl);
    }

    public final void zzy(zzaae zzaae) {
    }

    public final void zzz(boolean z) {
    }
}
