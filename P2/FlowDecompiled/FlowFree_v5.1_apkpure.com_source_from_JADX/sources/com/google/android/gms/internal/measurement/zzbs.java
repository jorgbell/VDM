package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzfh;
import com.google.android.gms.measurement.internal.zzgq;
import com.google.android.gms.measurement.internal.zzhx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
public final class zzbs {
    private static volatile zzbs zzc;
    protected final Clock zza;
    protected final ExecutorService zzb;
    /* access modifiers changed from: private */
    public final String zzd;
    private final AppMeasurementSdk zze;
    private final List<Pair<zzgq, zzbj>> zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public boolean zzh;
    private final String zzi;
    /* access modifiers changed from: private */
    public volatile zzq zzj;

    protected zzbs(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzV(str2, str3)) {
            this.zzd = "FA";
        } else {
            this.zzd = str;
        }
        this.zza = DefaultClock.getInstance();
        boolean z = true;
        this.zzb = zzl.zza().zzb(new zzaw(this), 1);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if (zzhx.zza(context, "google_app_id", zzfh.zza(context)) != null && !zzR()) {
                this.zzi = null;
                this.zzh = true;
                Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (!zzV(str2, str3)) {
            this.zzi = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 != null ? false : z)) {
                    Log.w(this.zzd, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzd, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        } else {
            this.zzi = str2;
        }
        zzS(new zzal(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzbr(this));
        }
    }

    protected static final boolean zzR() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzS(zzbh zzbh) {
        this.zzb.execute(zzbh);
    }

    /* access modifiers changed from: private */
    public final void zzT(Exception exc, boolean z, boolean z2) {
        this.zzh |= z;
        if (z) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzC(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzd, "Error with data collection. Data lost.", exc);
    }

    private final void zzU(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zzS(new zzbf(this, l, str, str2, bundle, z, z2));
    }

    /* access modifiers changed from: private */
    public static final boolean zzV(String str, String str2) {
        return (str2 == null || str == null || zzR()) ? false : true;
    }

    public static zzbs zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzbs.class) {
                if (zzc == null) {
                    zzc = new zzbs(context, str, str2, str3, bundle);
                }
            }
        }
        return zzc;
    }

    public final String zzA() {
        zzn zzn = new zzn();
        zzS(new zzas(this, zzn));
        return zzn.zzc(500);
    }

    public final Map<String, Object> zzB(String str, String str2, boolean z) {
        zzn zzn = new zzn();
        zzS(new zzat(this, str, str2, z, zzn));
        Bundle zzd2 = zzn.zzd(5000);
        if (zzd2 == null || zzd2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzd2.size());
        for (String str3 : zzd2.keySet()) {
            Object obj = zzd2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zzC(int i, String str, Object obj, Object obj2, Object obj3) {
        zzS(new zzau(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    public final Bundle zzD(Bundle bundle, boolean z) {
        zzn zzn = new zzn();
        zzS(new zzav(this, bundle, zzn));
        if (z) {
            return zzn.zzd(5000);
        }
        return null;
    }

    public final int zzE(String str) {
        zzn zzn = new zzn();
        zzS(new zzax(this, str, zzn));
        Integer num = (Integer) zzn.zze(zzn.zzd(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String zzG() {
        return this.zzi;
    }

    public final void zzI(boolean z) {
        zzS(new zzba(this, z));
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final zzq zzc(Context context, boolean z) {
        try {
            return zzp.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            zzT(e, true, false);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r4.zzj == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4.zzj.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        android.util.Log.w(r4.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        zzS(new com.google.android.gms.internal.measurement.zzbd(r4, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.measurement.internal.zzgq r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgq, com.google.android.gms.internal.measurement.zzbj>> r0 = r4.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgq, com.google.android.gms.internal.measurement.zzbj>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            int r2 = r2.size()     // Catch:{ all -> 0x0055 }
            if (r1 >= r2) goto L_0x002b
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgq, com.google.android.gms.internal.measurement.zzbj>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0055 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0055 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0028
            java.lang.String r5 = r4.zzd     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x0028:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002b:
            com.google.android.gms.internal.measurement.zzbj r1 = new com.google.android.gms.internal.measurement.zzbj     // Catch:{ all -> 0x0055 }
            r1.<init>(r5)     // Catch:{ all -> 0x0055 }
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgq, com.google.android.gms.internal.measurement.zzbj>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x0055 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0055 }
            r2.add(r3)     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            com.google.android.gms.internal.measurement.zzq r5 = r4.zzj
            if (r5 == 0) goto L_0x004c
            com.google.android.gms.internal.measurement.zzq r5 = r4.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            r5.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            return
        L_0x0045:
            java.lang.String r5 = r4.zzd
            java.lang.String r0 = "Failed to register event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r5, r0)
        L_0x004c:
            com.google.android.gms.internal.measurement.zzbd r5 = new com.google.android.gms.internal.measurement.zzbd
            r5.<init>(r4, r1)
            r4.zzS(r5)
            return
        L_0x0055:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            goto L_0x0059
        L_0x0058:
            throw r5
        L_0x0059:
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbs.zze(com.google.android.gms.measurement.internal.zzgq):void");
    }

    public final void zzg(String str, Bundle bundle) {
        zzU((String) null, str, bundle, false, true, (Long) null);
    }

    public final void zzh(String str, String str2, Bundle bundle) {
        zzU(str, str2, bundle, true, true, (Long) null);
    }

    public final void zzj(String str, String str2, Object obj, boolean z) {
        zzS(new zzbg(this, str, str2, obj, z));
    }

    public final void zzk(Bundle bundle) {
        zzS(new zzab(this, bundle));
    }

    public final void zzl(String str, String str2, Bundle bundle) {
        zzS(new zzac(this, str, str2, bundle));
    }

    public final List<Bundle> zzm(String str, String str2) {
        zzn zzn = new zzn();
        zzS(new zzad(this, str, str2, zzn));
        List<Bundle> list = (List) zzn.zze(zzn.zzd(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void zzo(Activity activity, String str, String str2) {
        zzS(new zzaf(this, activity, str, str2));
    }

    public final void zzq(Bundle bundle) {
        zzS(new zzah(this, bundle));
    }

    public final void zzu(String str) {
        zzS(new zzam(this, str));
    }

    public final void zzv(String str) {
        zzS(new zzan(this, str));
    }

    public final String zzw() {
        zzn zzn = new zzn();
        zzS(new zzao(this, zzn));
        return zzn.zzc(500);
    }

    public final String zzx() {
        zzn zzn = new zzn();
        zzS(new zzap(this, zzn));
        return zzn.zzc(50);
    }

    public final long zzy() {
        zzn zzn = new zzn();
        zzS(new zzaq(this, zzn));
        Long l = (Long) zzn.zze(zzn.zzd(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }

    public final String zzz() {
        zzn zzn = new zzn();
        zzS(new zzar(this, zzn));
        return zzn.zzc(500);
    }
}
