package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcpj {
    private boolean zza = false;
    private boolean zzb = false;
    /* access modifiers changed from: private */
    public boolean zzc = false;
    /* access modifiers changed from: private */
    public final long zzd;
    /* access modifiers changed from: private */
    public final zzbcb<Boolean> zze = new zzbcb<>();
    private final Context zzf;
    private final WeakReference<Context> zzg;
    private final zzclg zzh;
    /* access modifiers changed from: private */
    public final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    /* access modifiers changed from: private */
    public final zzcnr zzl;
    private final zzbbq zzm;
    private final Map<String, zzamj> zzn = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final zzcah zzo;
    private boolean zzp = true;

    public zzcpj(Executor executor, Context context, WeakReference<Context> weakReference, Executor executor2, zzclg zzclg, ScheduledExecutorService scheduledExecutorService, zzcnr zzcnr, zzbbq zzbbq, zzcah zzcah) {
        this.zzh = zzclg;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzcnr;
        this.zzm = zzbbq;
        this.zzo = zzcah;
        this.zzd = zzs.zzj().elapsedRealtime();
        zzu("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    static /* synthetic */ void zzq(zzcpj zzcpj, String str) {
        zzcpj zzcpj2 = zzcpj;
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = new Object();
                zzbcb zzbcb = new zzbcb();
                zzefw zzg2 = zzefo.zzg(zzbcb, ((Long) zzaaa.zzc().zzb(zzaeq.zzbh)).longValue(), TimeUnit.SECONDS, zzcpj2.zzk);
                zzcpj2.zzl.zza(next);
                zzcpj2.zzo.zza(next);
                long elapsedRealtime = zzs.zzj().elapsedRealtime();
                Iterator<String> it = keys;
                zzcpc zzcpc = r1;
                zzcpc zzcpc2 = new zzcpc(zzcpj, obj, zzbcb, next, elapsedRealtime);
                zzg2.zze(zzcpc, zzcpj2.zzi);
                arrayList.add(zzg2);
                zzcpi zzcpi = new zzcpi(zzcpj, obj, next, elapsedRealtime, zzbcb);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzamt(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzcpj2.zzu(next, false, "", 0);
                try {
                    zzcpj2.zzj.execute(new zzcpe(zzcpj, zzcpj2.zzh.zzb(next, new JSONObject()), zzcpi, arrayList2, next));
                } catch (zzdrl unused2) {
                    try {
                        zzcpi.zzf("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzbbk.zzg("", e);
                    }
                }
                keys = it;
            }
            zzefo.zzl(arrayList).zza(new zzcpd(zzcpj2), zzcpj2.zzi);
        } catch (JSONException e2) {
            zze.zzb("Malformed CLD response", e2);
        }
    }

    private final synchronized zzefw<String> zzt() {
        String zzd2 = zzs.zzg().zzl().zzn().zzd();
        if (!TextUtils.isEmpty(zzd2)) {
            return zzefo.zza(zzd2);
        }
        zzbcb zzbcb = new zzbcb();
        zzs.zzg().zzl().zzo(new zzcpa(this, zzbcb));
        return zzbcb;
    }

    /* access modifiers changed from: private */
    public final void zzu(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzamj(str, z, i, str2));
    }

    public final void zza() {
        this.zzp = false;
    }

    public final void zzb(zzamq zzamq) {
        this.zze.zze(new zzcoy(this, zzamq), this.zzj);
    }

    public final void zzc() {
        if (!zzagg.zza.zze().booleanValue()) {
            if (this.zzm.zzc >= ((Integer) zzaaa.zzc().zzb(zzaeq.zzbg)).intValue() && this.zzp) {
                if (!this.zza) {
                    synchronized (this) {
                        if (!this.zza) {
                            this.zzl.zzd();
                            this.zzo.zzd();
                            this.zze.zze(new zzcoz(this), this.zzi);
                            this.zza = true;
                            zzefw<String> zzt = zzt();
                            this.zzk.schedule(new zzcpb(this), ((Long) zzaaa.zzc().zzb(zzaeq.zzbi)).longValue(), TimeUnit.SECONDS);
                            zzefo.zzo(zzt, new zzcph(this), this.zzi);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zza) {
            zzu("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zze.zzc(Boolean.FALSE);
            this.zza = true;
            this.zzb = true;
        }
    }

    public final List<zzamj> zzd() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.zzn.keySet()) {
            zzamj zzamj = this.zzn.get(next);
            arrayList.add(new zzamj(next, zzamj.zzb, zzamj.zzc, zzamj.zzd));
        }
        return arrayList;
    }

    public final boolean zze() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        com.google.android.gms.internal.ads.zzbbk.zzg("", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 74);
        r4.append("Failed to initialize adapter. ");
        r4.append(r5);
        r4.append(" does not implement the initialize() method.");
        r3.zzf(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzf(com.google.android.gms.internal.ads.zzdrx r2, com.google.android.gms.internal.ads.zzamn r3, java.util.List r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.zzg     // Catch:{ zzdrl -> 0x0011 }
            java.lang.Object r0 = r0.get()     // Catch:{ zzdrl -> 0x0011 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ zzdrl -> 0x0011 }
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            android.content.Context r0 = r1.zzf     // Catch:{ zzdrl -> 0x0011 }
        L_0x000d:
            r2.zzy(r0, r3, r4)     // Catch:{ zzdrl -> 0x0011 }
            return
        L_0x0011:
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2.length()     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2 + 74
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0035 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = "Failed to initialize adapter. "
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            r4.append(r5)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = " does not implement the initialize() method."
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = r4.toString()     // Catch:{ RemoteException -> 0x0035 }
            r3.zzf(r2)     // Catch:{ RemoteException -> 0x0035 }
            return
        L_0x0035:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzbbk.zzg(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcpj.zzf(com.google.android.gms.internal.ads.zzdrx, com.google.android.gms.internal.ads.zzamn, java.util.List, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzg() throws Exception {
        this.zze.zzc(Boolean.TRUE);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Object obj, zzbcb zzbcb, String str, long j) {
        synchronized (obj) {
            if (!zzbcb.isDone()) {
                zzu(str, false, "Timeout.", (int) (zzs.zzj().elapsedRealtime() - j));
                this.zzl.zzc(str, "timeout");
                this.zzo.zzc(str, "timeout");
                zzbcb.zzc(Boolean.FALSE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        synchronized (this) {
            if (!this.zzc) {
                zzu("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzs.zzj().elapsedRealtime() - this.zzd));
                this.zze.zzd(new Exception());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzbcb zzbcb) {
        this.zzi.execute(new zzcpf(this, zzbcb));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }
}
