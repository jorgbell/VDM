package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus$State;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzacy {
    @GuardedBy("InternalMobileAds.class")
    private static zzacy zzc;
    /* access modifiers changed from: private */
    public final ArrayList<OnInitializationCompleteListener> zza = new ArrayList<>();
    private final Object zzb = new Object();
    @GuardedBy("lock")
    private zzabl zzd;
    /* access modifiers changed from: private */
    public boolean zze = false;
    /* access modifiers changed from: private */
    public boolean zzf = false;
    private RequestConfiguration zzh = new RequestConfiguration.Builder().build();
    private InitializationStatus zzi;

    private zzacy() {
    }

    public static zzacy zza() {
        zzacy zzacy;
        synchronized (zzacy.class) {
            if (zzc == null) {
                zzc = new zzacy();
            }
            zzacy = zzc;
        }
        return zzacy;
    }

    @GuardedBy("lock")
    private final void zzv(RequestConfiguration requestConfiguration) {
        try {
            this.zzd.zzr(new zzads(requestConfiguration));
        } catch (RemoteException e) {
            zzbbk.zzg("Unable to set request configuration parcel.", e);
        }
    }

    @GuardedBy("lock")
    private final void zzw(Context context) {
        if (this.zzd == null) {
            this.zzd = (zzabl) new zzzs(zzzy.zzb(), context).zzd(context, false);
        }
    }

    /* access modifiers changed from: private */
    public static final InitializationStatus zzx(List<zzamj> list) {
        HashMap hashMap = new HashMap();
        for (zzamj next : list) {
            hashMap.put(next.zza, new zzamr(next.zzb ? AdapterStatus$State.READY : AdapterStatus$State.NOT_READY, next.zzd, next.zzc));
        }
        return new zzams(hashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(android.content.Context r4, @javax.annotation.Nullable java.lang.String r5, @javax.annotation.Nullable com.google.android.gms.ads.initialization.OnInitializationCompleteListener r6) {
        /*
            r3 = this;
            java.lang.Object r5 = r3.zzb
            monitor-enter(r5)
            boolean r0 = r3.zze     // Catch:{ all -> 0x00c2 }
            if (r0 == 0) goto L_0x0014
            if (r6 == 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzacy r4 = zza()     // Catch:{ all -> 0x00c2 }
            java.util.ArrayList<com.google.android.gms.ads.initialization.OnInitializationCompleteListener> r4 = r4.zza     // Catch:{ all -> 0x00c2 }
            r4.add(r6)     // Catch:{ all -> 0x00c2 }
        L_0x0012:
            monitor-exit(r5)     // Catch:{ all -> 0x00c2 }
            return
        L_0x0014:
            boolean r0 = r3.zzf     // Catch:{ all -> 0x00c2 }
            if (r0 == 0) goto L_0x0023
            if (r6 == 0) goto L_0x0021
            com.google.android.gms.ads.initialization.InitializationStatus r4 = r3.zzj()     // Catch:{ all -> 0x00c2 }
            r6.onInitializationComplete(r4)     // Catch:{ all -> 0x00c2 }
        L_0x0021:
            monitor-exit(r5)     // Catch:{ all -> 0x00c2 }
            return
        L_0x0023:
            r0 = 1
            r3.zze = r0     // Catch:{ all -> 0x00c2 }
            if (r6 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzacy r0 = zza()     // Catch:{ all -> 0x00c2 }
            java.util.ArrayList<com.google.android.gms.ads.initialization.OnInitializationCompleteListener> r0 = r0.zza     // Catch:{ all -> 0x00c2 }
            r0.add(r6)     // Catch:{ all -> 0x00c2 }
        L_0x0031:
            if (r4 == 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzapu r0 = com.google.android.gms.internal.ads.zzapu.zza()     // Catch:{ RemoteException -> 0x00b2 }
            r1 = 0
            r0.zzb(r4, r1)     // Catch:{ RemoteException -> 0x00b2 }
            r3.zzw(r4)     // Catch:{ RemoteException -> 0x00b2 }
            if (r6 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzabl r0 = r3.zzd     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzacx r2 = new com.google.android.gms.internal.ads.zzacx     // Catch:{ RemoteException -> 0x00b2 }
            r2.<init>(r3, r1)     // Catch:{ RemoteException -> 0x00b2 }
            r0.zzp(r2)     // Catch:{ RemoteException -> 0x00b2 }
        L_0x004a:
            com.google.android.gms.internal.ads.zzabl r0 = r3.zzd     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzapy r2 = new com.google.android.gms.internal.ads.zzapy     // Catch:{ RemoteException -> 0x00b2 }
            r2.<init>()     // Catch:{ RemoteException -> 0x00b2 }
            r0.zzo(r2)     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzabl r0 = r3.zzd     // Catch:{ RemoteException -> 0x00b2 }
            r0.zze()     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzabl r0 = r3.zzd     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r1)     // Catch:{ RemoteException -> 0x00b2 }
            r0.zzj(r1, r2)     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.ads.RequestConfiguration r0 = r3.zzh     // Catch:{ RemoteException -> 0x00b2 }
            int r0 = r0.getTagForChildDirectedTreatment()     // Catch:{ RemoteException -> 0x00b2 }
            r1 = -1
            if (r0 != r1) goto L_0x0073
            com.google.android.gms.ads.RequestConfiguration r0 = r3.zzh     // Catch:{ RemoteException -> 0x00b2 }
            int r0 = r0.getTagForUnderAgeOfConsent()     // Catch:{ RemoteException -> 0x00b2 }
            if (r0 == r1) goto L_0x0078
        L_0x0073:
            com.google.android.gms.ads.RequestConfiguration r0 = r3.zzh     // Catch:{ RemoteException -> 0x00b2 }
            r3.zzv(r0)     // Catch:{ RemoteException -> 0x00b2 }
        L_0x0078:
            com.google.android.gms.internal.ads.zzaeq.zza(r4)     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzaeq.zzdA     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzaeo r0 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ RemoteException -> 0x00b2 }
            java.lang.Object r4 = r0.zzb(r4)     // Catch:{ RemoteException -> 0x00b2 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ RemoteException -> 0x00b2 }
            boolean r4 = r4.booleanValue()     // Catch:{ RemoteException -> 0x00b2 }
            if (r4 != 0) goto L_0x00b8
            java.lang.String r4 = r3.zzh()     // Catch:{ RemoteException -> 0x00b2 }
            java.lang.String r0 = "0"
            boolean r4 = r4.endsWith(r0)     // Catch:{ RemoteException -> 0x00b2 }
            if (r4 != 0) goto L_0x00b8
            java.lang.String r4 = "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time."
            com.google.android.gms.internal.ads.zzbbk.zzf(r4)     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzacu r4 = new com.google.android.gms.internal.ads.zzacu     // Catch:{ RemoteException -> 0x00b2 }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x00b2 }
            r3.zzi = r4     // Catch:{ RemoteException -> 0x00b2 }
            if (r6 == 0) goto L_0x00b8
            android.os.Handler r4 = com.google.android.gms.internal.ads.zzbbd.zza     // Catch:{ RemoteException -> 0x00b2 }
            com.google.android.gms.internal.ads.zzact r0 = new com.google.android.gms.internal.ads.zzact     // Catch:{ RemoteException -> 0x00b2 }
            r0.<init>(r3, r6)     // Catch:{ RemoteException -> 0x00b2 }
            r4.post(r0)     // Catch:{ RemoteException -> 0x00b2 }
            goto L_0x00b8
        L_0x00b2:
            r4 = move-exception
            java.lang.String r6 = "MobileAdsSettingManager initialization failed"
            com.google.android.gms.internal.ads.zzbbk.zzj(r6, r4)     // Catch:{ all -> 0x00c2 }
        L_0x00b8:
            monitor-exit(r5)     // Catch:{ all -> 0x00c2 }
            return
        L_0x00ba:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c2 }
            java.lang.String r6 = "Context cannot be null."
            r4.<init>(r6)     // Catch:{ all -> 0x00c2 }
            throw r4     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r4 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00c2 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacy.zzb(android.content.Context, java.lang.String, com.google.android.gms.ads.initialization.OnInitializationCompleteListener):void");
    }

    public final void zzc(float f) {
        boolean z = true;
        Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.zzb) {
            if (this.zzd == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzd.zzf(f);
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to set app volume.", e);
            }
        }
    }

    public final void zze(boolean z) {
        synchronized (this.zzb) {
            Preconditions.checkState(this.zzd != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzd.zzh(z);
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to set app mute state.", e);
            }
        }
    }

    public final String zzh() {
        String zza2;
        synchronized (this.zzb) {
            Preconditions.checkState(this.zzd != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zza2 = zzecs.zza(this.zzd.zzm());
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to get version string.", e);
                return "";
            }
        }
        return zza2;
    }

    public final InitializationStatus zzj() {
        synchronized (this.zzb) {
            Preconditions.checkState(this.zzd != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                InitializationStatus initializationStatus = this.zzi;
                if (initializationStatus != null) {
                    return initializationStatus;
                }
                InitializationStatus zzx = zzx(this.zzd.zzq());
                return zzx;
            } catch (RemoteException unused) {
                zzbbk.zzf("Unable to get Initialization status.");
                return new zzacu(this);
            }
        }
    }

    public final RequestConfiguration zzm() {
        return this.zzh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzn(com.google.android.gms.ads.RequestConfiguration r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0004
            r0 = 1
            goto L_0x0005
        L_0x0004:
            r0 = 0
        L_0x0005:
            java.lang.String r1 = "Null passed to setRequestConfiguration."
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r1)
            java.lang.Object r0 = r4.zzb
            monitor-enter(r0)
            com.google.android.gms.ads.RequestConfiguration r1 = r4.zzh     // Catch:{ all -> 0x0030 }
            r4.zzh = r5     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzabl r2 = r4.zzd     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0017:
            int r2 = r1.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            int r3 = r5.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            if (r2 != r3) goto L_0x002b
            int r1 = r1.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            int r2 = r5.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            if (r1 == r2) goto L_0x002e
        L_0x002b:
            r4.zzv(r5)     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacy.zzn(com.google.android.gms.ads.RequestConfiguration):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzi);
    }
}
