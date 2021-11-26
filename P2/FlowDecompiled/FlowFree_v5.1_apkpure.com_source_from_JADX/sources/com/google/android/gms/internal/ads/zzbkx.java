package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzak;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbkx extends zzabk {
    private final Context zza;
    private final zzbbq zzb;
    private final zzclg zzc;
    private final zzcvy<zzdrx, zzcxt> zzd;
    private final zzdbz zze;
    private final zzcpj zzf;
    private final zzazt zzg;
    private final zzcll zzh;
    private final zzcpz zzi;
    @GuardedBy("this")
    private boolean zzj = false;

    zzbkx(Context context, zzbbq zzbbq, zzclg zzclg, zzcvy<zzdrx, zzcxt> zzcvy, zzdbz zzdbz, zzcpj zzcpj, zzazt zzazt, zzcll zzcll, zzcpz zzcpz) {
        this.zza = context;
        this.zzb = zzbbq;
        this.zzc = zzclg;
        this.zzd = zzcvy;
        this.zze = zzdbz;
        this.zzf = zzcpj;
        this.zzg = zzazt;
        this.zzh = zzcll;
        this.zzi = zzcpz;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzapw> zzf2 = zzs.zzg().zzl().zzn().zzf();
        if (!zzf2.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzbbk.zzj("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzc.zzd()) {
                HashMap hashMap = new HashMap();
                for (zzapw zzapw : zzf2.values()) {
                    for (zzapv next : zzapw.zza) {
                        String str = next.zzk;
                        for (String next2 : next.zzc) {
                            if (!hashMap.containsKey(next2)) {
                                hashMap.put(next2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(next2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    try {
                        zzcvz<zzdrx, zzcxt> zza2 = this.zzd.zza(str2, jSONObject);
                        if (zza2 != null) {
                            zzdrx zzdrx = (zzdrx) zza2.zzb;
                            if (!zzdrx.zzn() && zzdrx.zzq()) {
                                zzdrx.zzr(this.zza, (zzcxt) zza2.zzc, (List) entry.getValue());
                                String valueOf = String.valueOf(str2);
                                zzbbk.zzd(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                            }
                        }
                    } catch (zzdrl e) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                        sb.append("Failed to initialize rewarded video mediation adapter \"");
                        sb.append(str2);
                        sb.append("\"");
                        zzbbk.zzj(sb.toString(), e);
                    }
                }
            }
        }
    }

    public final synchronized void zze() {
        if (this.zzj) {
            zzbbk.zzi("Mobile ads is initialized already.");
            return;
        }
        zzaeq.zza(this.zza);
        zzs.zzg().zze(this.zza, this.zzb);
        zzs.zzi().zza(this.zza);
        this.zzj = true;
        this.zzf.zzc();
        this.zze.zza();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcj)).booleanValue()) {
            this.zzh.zza();
        }
        this.zzi.zza();
    }

    public final synchronized void zzf(float f) {
        zzs.zzh().zza(f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzg(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.Context r0 = r4.zza     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzaeq.zza(r0)     // Catch:{ all -> 0x002e }
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzci     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x002e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002c
            com.google.android.gms.ads.internal.zze r0 = com.google.android.gms.ads.internal.zzs.zzk()     // Catch:{ all -> 0x002e }
            android.content.Context r1 = r4.zza     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzbbq r2 = r4.zzb     // Catch:{ all -> 0x002e }
            r3 = 0
            r0.zza(r1, r2, r5, r3)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)
            return
        L_0x002c:
            monitor-exit(r4)
            return
        L_0x002e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkx.zzg(java.lang.String):void");
    }

    public final synchronized void zzh(boolean z) {
        zzs.zzh().zzc(z);
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzbbk.zzf("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzbbk.zzf("Context is null. Failed to open debug menu.");
            return;
        }
        zzak zzak = new zzak(context);
        zzak.zzc(str);
        zzak.zzd(this.zzb.zza);
        zzak.zzb();
    }

    public final void zzj(String str, IObjectWrapper iObjectWrapper) {
        String str2;
        zzbkv zzbkv;
        zzaeq.zza(this.zza);
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcl)).booleanValue()) {
            zzs.zzc();
            str2 = zzr.zzv(this.zza);
        } else {
            str2 = "";
        }
        boolean z = true;
        if (true != TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            boolean booleanValue = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzci)).booleanValue();
            zzaei zzaei = zzaeq.zzaB;
            boolean booleanValue2 = booleanValue | ((Boolean) zzaaa.zzc().zzb(zzaei)).booleanValue();
            if (((Boolean) zzaaa.zzc().zzb(zzaei)).booleanValue()) {
                zzbkv = new zzbkv(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                z = booleanValue2;
                zzbkv = null;
            }
            if (z) {
                zzs.zzk().zza(this.zza, this.zzb, str, zzbkv);
            }
        }
    }

    public final synchronized float zzk() {
        return zzs.zzh().zzb();
    }

    public final synchronized boolean zzl() {
        return zzs.zzh().zzd();
    }

    public final String zzm() {
        return this.zzb.zza;
    }

    public final void zzn(String str) {
        this.zze.zzc(str);
    }

    public final void zzo(zzaqb zzaqb) throws RemoteException {
        this.zzc.zza(zzaqb);
    }

    public final void zzp(zzamq zzamq) throws RemoteException {
        this.zzf.zzb(zzamq);
    }

    public final List<zzamj> zzq() throws RemoteException {
        return this.zzf.zzd();
    }

    public final void zzr(zzads zzads) throws RemoteException {
        this.zzg.zzc(this.zza, zzads);
    }

    public final void zzs() {
        this.zzf.zza();
    }

    public final void zzt(zzabx zzabx) throws RemoteException {
        this.zzi.zzh(zzabx);
    }
}
