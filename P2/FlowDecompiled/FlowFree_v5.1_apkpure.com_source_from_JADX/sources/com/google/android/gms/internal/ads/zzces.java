package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzces extends zzbql {
    private final Executor zzc;
    private final zzcex zzd;
    private final zzcff zze;
    private final zzcfw zzf;
    private final zzcfc zzg;
    private final zzcfi zzh;
    private final zzeyf<zzciu> zzi;
    private final zzeyf<zzcis> zzj;
    private final zzeyf<zzciz> zzk;
    private final zzeyf<zzciq> zzl;
    private final zzeyf<zzcix> zzm;
    /* access modifiers changed from: private */
    public zzcgr zzn;
    private boolean zzo;
    private boolean zzp = false;
    private final zzazb zzq;
    private final zzfh zzr;
    private final zzbbq zzs;
    private final Context zzt;
    private final zzceu zzu;
    private final zzddd zzv;
    /* access modifiers changed from: private */
    public final Map<String, Boolean> zzw;
    private final List<zzrj> zzx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzces(zzbqk zzbqk, Executor executor, zzcex zzcex, zzcff zzcff, zzcfw zzcfw, zzcfc zzcfc, zzcfi zzcfi, zzeyf<zzciu> zzeyf, zzeyf<zzcis> zzeyf2, zzeyf<zzciz> zzeyf3, zzeyf<zzciq> zzeyf4, zzeyf<zzcix> zzeyf5, zzazb zzazb, zzfh zzfh, zzbbq zzbbq, Context context, zzceu zzceu, zzddd zzddd, zzrk zzrk) {
        super(zzbqk);
        this.zzc = executor;
        this.zzd = zzcex;
        this.zze = zzcff;
        this.zzf = zzcfw;
        this.zzg = zzcfc;
        this.zzh = zzcfi;
        this.zzi = zzeyf;
        this.zzj = zzeyf2;
        this.zzk = zzeyf3;
        this.zzl = zzeyf4;
        this.zzm = zzeyf5;
        this.zzq = zzazb;
        this.zzr = zzfh;
        this.zzs = zzbbq;
        this.zzt = context;
        this.zzu = zzceu;
        this.zzv = zzddd;
        this.zzw = new HashMap();
        this.zzx = new ArrayList();
    }

    /* access modifiers changed from: private */
    /* renamed from: zzO */
    public final void zzJ(zzcgr zzcgr) {
        Iterator<String> keys;
        View view;
        zzex zzb;
        this.zzn = zzcgr;
        this.zzf.zza(zzcgr);
        this.zze.zza(zzcgr.zzby(), zzcgr.zzk(), zzcgr.zzl(), zzcgr, zzcgr);
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbD)).booleanValue() && (zzb = this.zzr.zzb()) != null) {
            zzb.zzj(zzcgr.zzby());
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbf)).booleanValue()) {
            zzdqo zzdqo = this.zzb;
            if (zzdqo.zzaf && (keys = zzdqo.zzae.keys()) != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    WeakReference weakReference = this.zzn.zzj().get(next);
                    this.zzw.put(next, Boolean.FALSE);
                    if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
                        zzrj zzrj = new zzrj(this.zzt, view);
                        this.zzx.add(zzrj);
                        zzrj.zza(new zzcer(this, next));
                    }
                }
            }
        }
        if (zzcgr.zzh() != null) {
            zzcgr.zzh().zza(this.zzq);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzP */
    public final void zzI(zzcgr zzcgr) {
        this.zze.zzb(zzcgr.zzby(), zzcgr.zzj());
        if (zzcgr.zzbu() != null) {
            zzcgr.zzbu().setClickable(false);
            zzcgr.zzbu().removeAllViews();
        }
        if (zzcgr.zzh() != null) {
            zzcgr.zzh().zzb(this.zzq);
        }
        this.zzn = null;
    }

    public static boolean zzz(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null);
    }

    public final boolean zzA() {
        return this.zzg.zzc();
    }

    public final void zzB(String str, boolean z) {
        String str2;
        IObjectWrapper iObjectWrapper;
        zzaug zzaug;
        zzauh zzauh;
        if (this.zzg.zzd()) {
            zzbgf zzP = this.zzd.zzP();
            zzbgf zzO = this.zzd.zzO();
            if (zzP != null || zzO != null) {
                if (zzP != null) {
                    str2 = null;
                } else {
                    str2 = "javascript";
                    zzP = zzO;
                }
                String str3 = str2;
                if (!zzs.zzr().zza(this.zzt)) {
                    zzbbk.zzi("Failed to initialize omid in InternalNativeAd");
                    return;
                }
                zzbbq zzbbq = this.zzs;
                int i = zzbbq.zzb;
                int i2 = zzbbq.zzc;
                StringBuilder sb = new StringBuilder(23);
                sb.append(i);
                sb.append(".");
                sb.append(i2);
                String sb2 = sb.toString();
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdm)).booleanValue()) {
                    if (zzO != null) {
                        zzaug = zzaug.VIDEO;
                        zzauh = zzauh.DEFINED_BY_JAVASCRIPT;
                    } else {
                        zzaug = zzaug.NATIVE_DISPLAY;
                        if (this.zzd.zzt() == 3) {
                            zzauh = zzauh.UNSPECIFIED;
                        } else {
                            zzauh = zzauh.ONE_PIXEL;
                        }
                    }
                    iObjectWrapper = zzs.zzr().zzg(sb2, zzP.zzG(), "", "javascript", str3, str, zzauh, zzaug, this.zzb.zzag);
                } else {
                    iObjectWrapper = zzs.zzr().zze(sb2, zzP.zzG(), "", "javascript", str3, str);
                }
                if (iObjectWrapper == null) {
                    zzbbk.zzi("Failed to create omid session in InternalNativeAd");
                    return;
                }
                this.zzd.zzn(iObjectWrapper);
                zzP.zzak(iObjectWrapper);
                if (zzO != null) {
                    zzs.zzr().zzj(iObjectWrapper, zzO.zzH());
                    this.zzp = true;
                }
                if (z) {
                    zzs.zzr().zzh(iObjectWrapper);
                    if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdo)).booleanValue()) {
                        zzP.zze("onSdkLoaded", new ArrayMap());
                    }
                }
            }
        }
    }

    public final boolean zzC() {
        return this.zzg.zzd();
    }

    public final void zzD(View view) {
        IObjectWrapper zzQ = this.zzd.zzQ();
        zzbgf zzP = this.zzd.zzP();
        if (this.zzg.zzd() && zzQ != null && zzP != null && view != null) {
            zzs.zzr().zzj(zzQ, view);
        }
    }

    public final void zzE(View view) {
        IObjectWrapper zzQ = this.zzd.zzQ();
        if (this.zzg.zzd() && zzQ != null && view != null) {
            zzs.zzr().zzk(zzQ, view);
        }
    }

    public final zzceu zzF() {
        return this.zzu;
    }

    public final synchronized void zzG(zzacd zzacd) {
        this.zzv.zza(zzacd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH(boolean z) {
        this.zze.zzf(this.zzn.zzby(), this.zzn.zzj(), this.zzn.zzk(), z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzK() {
        this.zze.zzw();
        this.zzd.zzV();
    }

    public final void zzQ() {
        this.zzc.execute(new zzcel(this));
        if (this.zzd.zzt() != 7) {
            Executor executor = this.zzc;
            zzcff zzcff = this.zze;
            zzcff.getClass();
            executor.execute(zzcem.zza(zzcff));
        }
        super.zzQ();
    }

    public final synchronized void zzR() {
        this.zzc.execute(new zzcen(this));
        super.zzR();
    }

    public final synchronized void zza(String str) {
        this.zze.zzd(str);
    }

    public final synchronized void zzb() {
        if (!this.zzo) {
            this.zze.zzm();
        }
    }

    public final synchronized void zzc(Bundle bundle) {
        this.zze.zze(bundle);
    }

    public final synchronized boolean zze(Bundle bundle) {
        if (this.zzo) {
            return true;
        }
        boolean zzv2 = this.zze.zzv(bundle);
        this.zzo = zzv2;
        return zzv2;
    }

    public final synchronized void zzf(Bundle bundle) {
        this.zze.zzk(bundle);
    }

    public final synchronized void zzg(zzcgr zzcgr) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbe)).booleanValue()) {
            zzr.zza.post(new zzceo(this, zzcgr));
        } else {
            zzJ(zzcgr);
        }
    }

    public final synchronized void zzh(zzcgr zzcgr) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbe)).booleanValue()) {
            zzr.zza.post(new zzcep(this, zzcgr));
        } else {
            zzI(zzcgr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzj(android.view.View r9, android.view.View r10, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r11, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r12, boolean r13) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.internal.ads.zzcfw r0 = r8.zzf     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzcgr r1 = r8.zzn     // Catch:{ all -> 0x0045 }
            r0.zzb(r1)     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzcff r2 = r8.zze     // Catch:{ all -> 0x0045 }
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r2.zzc(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0045 }
            boolean r9 = r8.zzp     // Catch:{ all -> 0x0045 }
            if (r9 == 0) goto L_0x0043
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzaeq.zzcb     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzaeo r10 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x0045 }
            java.lang.Object r9 = r10.zzb(r9)     // Catch:{ all -> 0x0045 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0045 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0045 }
            if (r9 == 0) goto L_0x0043
            com.google.android.gms.internal.ads.zzcex r9 = r8.zzd     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzbgf r9 = r9.zzO()     // Catch:{ all -> 0x0045 }
            if (r9 != 0) goto L_0x0031
            goto L_0x0043
        L_0x0031:
            com.google.android.gms.internal.ads.zzcex r9 = r8.zzd     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzbgf r9 = r9.zzO()     // Catch:{ all -> 0x0045 }
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0045 }
            r10.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r11 = "onSdkAdUserInteractionClick"
            r9.zze(r11, r10)     // Catch:{ all -> 0x0045 }
            monitor-exit(r8)
            return
        L_0x0043:
            monitor-exit(r8)
            return
        L_0x0045:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzces.zzj(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzk(View view, MotionEvent motionEvent, View view2) {
        this.zze.zzj(view, motionEvent, view2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzp(android.view.View r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzo     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzbf     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x00a6 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a6 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzdqo r0 = r3.zzb     // Catch:{ all -> 0x00a6 }
            boolean r0 = r0.zzaf     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0045
            java.util.Map<java.lang.String, java.lang.Boolean> r0 = r3.zzw     // Catch:{ all -> 0x00a6 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x00a6 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a6 }
        L_0x0029:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00a6 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00a6 }
            java.util.Map<java.lang.String, java.lang.Boolean> r2 = r3.zzw     // Catch:{ all -> 0x00a6 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x00a6 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00a6 }
            if (r1 != 0) goto L_0x0029
            monitor-exit(r3)
            return
        L_0x0045:
            r0 = 1
            if (r7 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzcfw r7 = r3.zzf     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzcgr r1 = r3.zzn     // Catch:{ all -> 0x00a6 }
            r7.zzc(r1)     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzcff r7 = r3.zze     // Catch:{ all -> 0x00a6 }
            r7.zzt(r4, r5, r6)     // Catch:{ all -> 0x00a6 }
            r3.zzo = r0     // Catch:{ all -> 0x00a6 }
            monitor-exit(r3)
            return
        L_0x0058:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r7 = com.google.android.gms.internal.ads.zzaeq.zzcg     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x00a6 }
            java.lang.Object r7 = r1.zzb(r7)     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x00a6 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x00a6 }
            if (r7 == 0) goto L_0x00a4
            if (r5 == 0) goto L_0x00a4
            java.util.Set r7 = r5.entrySet()     // Catch:{ all -> 0x00a6 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00a6 }
        L_0x0074:
            boolean r1 = r7.hasNext()     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x00a4
            java.lang.Object r1 = r7.next()     // Catch:{ all -> 0x00a6 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x00a6 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x00a6 }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x00a6 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x00a6 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0074
            boolean r1 = zzz(r1)     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0074
            com.google.android.gms.internal.ads.zzcfw r7 = r3.zzf     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzcgr r1 = r3.zzn     // Catch:{ all -> 0x00a6 }
            r7.zzc(r1)     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzcff r7 = r3.zze     // Catch:{ all -> 0x00a6 }
            r7.zzt(r4, r5, r6)     // Catch:{ all -> 0x00a6 }
            r3.zzo = r0     // Catch:{ all -> 0x00a6 }
            monitor-exit(r3)
            return
        L_0x00a4:
            monitor-exit(r3)
            return
        L_0x00a6:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x00aa
        L_0x00a9:
            throw r4
        L_0x00aa:
            goto L_0x00a9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzces.zzp(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized JSONObject zzq(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.zze.zzl(view, map, map2);
    }

    public final synchronized void zzr(View view) {
        this.zze.zzn(view);
    }

    public final synchronized void zzs(zzaja zzaja) {
        this.zze.zzo(zzaja);
    }

    public final synchronized void zzt() {
        this.zze.zzp();
    }

    public final synchronized void zzu(zzabt zzabt) {
        this.zze.zzq(zzabt);
    }

    public final synchronized void zzv(zzabp zzabp) {
        this.zze.zzr(zzabp);
    }

    public final synchronized void zzw() {
        this.zze.zzg();
    }

    public final synchronized void zzx() {
        zzcgr zzcgr = this.zzn;
        if (zzcgr == null) {
            zzbbk.zzd("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzc.execute(new zzceq(this, zzcgr instanceof zzcfq));
        }
    }

    public final synchronized boolean zzy() {
        return this.zze.zzh();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzN() {
        try {
            int zzt2 = this.zzd.zzt();
            if (zzt2 != 1) {
                if (zzt2 != 2) {
                    if (zzt2 != 3) {
                        if (zzt2 != 6) {
                            if (zzt2 != 7) {
                                zzbbk.zzf("Wrong native template id!");
                            } else if (this.zzh.zze() != null) {
                                this.zzh.zze().zze(this.zzl.zzb());
                            }
                        } else if (this.zzh.zzc() != null) {
                            zzB("Google", true);
                            this.zzh.zzc().zze(this.zzk.zzb());
                        }
                    } else if (this.zzh.zzf(this.zzd.zzN()) != null) {
                        if (this.zzd.zzO() != null) {
                            zzB("Google", true);
                        }
                        this.zzh.zzf(this.zzd.zzN()).zze(this.zzm.zzb());
                    }
                } else if (this.zzh.zzb() != null) {
                    zzB("Google", true);
                    this.zzh.zzb().zze(this.zzj.zzb());
                }
            } else if (this.zzh.zza() != null) {
                zzB("Google", true);
                this.zzh.zza().zze(this.zzi.zzb());
            }
        } catch (RemoteException e) {
            zzbbk.zzg("RemoteException when notifyAdLoad is called", e);
        }
    }
}
