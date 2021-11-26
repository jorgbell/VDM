package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdql extends zzawu {
    private final zzdqb zza;
    private final zzdps zzb;
    private final zzdrb zzc;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzcjw zzd;
    @GuardedBy("this")
    private boolean zze = false;

    public zzdql(zzdqb zzdqb, zzdps zzdps, zzdrb zzdrb) {
        this.zza = zzdqb;
        this.zzb = zzdps;
        this.zzc = zzdrb;
    }

    private final synchronized boolean zzx() {
        zzcjw zzcjw;
        zzcjw = this.zzd;
        return zzcjw != null && !zzcjw.zze();
    }

    public final synchronized void zzb(zzawz zzawz) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        String str = zzawz.zzb;
        String str2 = (String) zzaaa.zzc().zzb(zzaeq.zzdB);
        if (!(str2 == null || str == null)) {
            try {
                if (Pattern.matches(str2, str)) {
                    return;
                }
            } catch (RuntimeException e) {
                zzs.zzg().zzg(e, "NonagonUtil.isPatternMatched");
            }
        }
        if (zzx()) {
            if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzdD)).booleanValue()) {
                return;
            }
        }
        zzdpu zzdpu = new zzdpu((String) null);
        this.zzd = null;
        this.zza.zzi(1);
        this.zza.zza(zzawz.zza, zzawz.zzb, zzdpu, new zzdqj(this));
    }

    public final synchronized void zzc() throws RemoteException {
        zzp((IObjectWrapper) null);
    }

    public final void zzd(zzawy zzawy) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzb.zzp(zzawy);
    }

    public final boolean zze() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzx();
    }

    public final void zzf() {
        zzi((IObjectWrapper) null);
    }

    public final void zzg() {
        zzj((IObjectWrapper) null);
    }

    public final void zzh() throws RemoteException {
        zzk((IObjectWrapper) null);
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzd != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzd.zzl().zza(context);
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzd != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzd.zzl().zzb(context);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzk(com.google.android.gms.dynamic.IObjectWrapper r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzdps r0 = r2.zzb     // Catch:{ all -> 0x0027 }
            r1 = 0
            r0.zzm(r1)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzcjw r0 = r2.zzd     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0025
            if (r3 != 0) goto L_0x0013
            goto L_0x001a
        L_0x0013:
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch:{ all -> 0x0027 }
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x0027 }
        L_0x001a:
            com.google.android.gms.internal.ads.zzcjw r3 = r2.zzd     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzbvc r3 = r3.zzl()     // Catch:{ all -> 0x0027 }
            r3.zzc(r1)     // Catch:{ all -> 0x0027 }
            monitor-exit(r2)
            return
        L_0x0025:
            monitor-exit(r2)
            return
        L_0x0027:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdql.zzk(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final synchronized String zzl() throws RemoteException {
        zzcjw zzcjw = this.zzd;
        if (zzcjw == null || zzcjw.zzm() == null) {
            return null;
        }
        return this.zzd.zzm().zze();
    }

    public final synchronized void zzm(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzc.zza = str;
    }

    public final void zzn(zzaay zzaay) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzaay == null) {
            this.zzb.zzm((zzdyp) null);
        } else {
            this.zzb.zzm(new zzdqk(this, zzaay));
        }
    }

    public final Bundle zzo() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzcjw zzcjw = this.zzd;
        return zzcjw != null ? zzcjw.zzg() : new Bundle();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.app.Activity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzp(com.google.android.gms.dynamic.IObjectWrapper r3) throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "showAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0024 }
            com.google.android.gms.internal.ads.zzcjw r0 = r2.zzd     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            r0 = 0
            if (r3 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch:{ all -> 0x0024 }
            boolean r1 = r3 instanceof android.app.Activity     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0019
            r0 = r3
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ all -> 0x0024 }
        L_0x0019:
            com.google.android.gms.internal.ads.zzcjw r3 = r2.zzd     // Catch:{ all -> 0x0024 }
            boolean r1 = r2.zze     // Catch:{ all -> 0x0024 }
            r3.zza(r1, r0)     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0022:
            monitor-exit(r2)
            return
        L_0x0024:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdql.zzp(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final synchronized void zzq(String str) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
        this.zzc.zzb = str;
    }

    public final synchronized void zzr(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zze = z;
    }

    public final boolean zzs() {
        zzcjw zzcjw = this.zzd;
        return zzcjw != null && zzcjw.zzf();
    }

    public final synchronized zzacg zzt() throws RemoteException {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzeP)).booleanValue()) {
            return null;
        }
        zzcjw zzcjw = this.zzd;
        if (zzcjw == null) {
            return null;
        }
        return zzcjw.zzm();
    }

    public final void zzu(zzawt zzawt) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzb.zzr(zzawt);
    }
}
