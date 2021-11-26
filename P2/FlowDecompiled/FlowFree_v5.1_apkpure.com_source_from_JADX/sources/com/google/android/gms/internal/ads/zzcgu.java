package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcgu implements zzcff {
    private final zzaqq zza;
    private final zzbuv zzb;
    private final zzbud zzc;
    private final Context zzd;
    private final zzdqo zze;
    private final zzbbq zzf;
    private final zzdrg zzg;
    private boolean zzh = false;
    private boolean zzi = false;
    private boolean zzj = true;
    private final zzaqm zzk;
    private final zzaqn zzl;

    public zzcgu(zzaqm zzaqm, zzaqn zzaqn, zzaqq zzaqq, zzbuv zzbuv, zzbud zzbud, Context context, zzdqo zzdqo, zzbbq zzbbq, zzdrg zzdrg, byte[] bArr) {
        this.zzk = zzaqm;
        this.zzl = zzaqn;
        this.zza = zzaqq;
        this.zzb = zzbuv;
        this.zzc = zzbud;
        this.zzd = context;
        this.zze = zzdqo;
        this.zzf = zzbbq;
        this.zzg = zzdrg;
    }

    private final void zzi(View view) {
        try {
            zzaqq zzaqq = this.zza;
            if (zzaqq == null || zzaqq.zzu()) {
                zzaqm zzaqm = this.zzk;
                if (zzaqm == null || zzaqm.zzq()) {
                    zzaqn zzaqn = this.zzl;
                    if (zzaqn != null && !zzaqn.zzo()) {
                        this.zzl.zzl(ObjectWrapper.wrap(view));
                        this.zzc.onAdClicked();
                        return;
                    }
                    return;
                }
                this.zzk.zzn(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                return;
            }
            this.zza.zzw(ObjectWrapper.wrap(view));
            this.zzc.onAdClicked();
        } catch (RemoteException e) {
            zzbbk.zzj("Failed to call handleClick", e);
        }
    }

    private static final HashMap<String, View> zzx(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry next : map.entrySet()) {
                View view = (View) ((WeakReference) next.getValue()).get();
                if (view != null) {
                    hashMap.put((String) next.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.view.View r9, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r10, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r11, android.view.View.OnTouchListener r12, android.view.View.OnClickListener r13) {
        /*
            r8 = this;
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzdqo r12 = r8.zze     // Catch:{ RemoteException -> 0x0124 }
            org.json.JSONObject r12 = r12.zzae     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r13 = com.google.android.gms.internal.ads.zzaeq.zzbb     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzaeo r0 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Object r13 = r0.zzb(r13)     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ RemoteException -> 0x0124 }
            boolean r13 = r13.booleanValue()     // Catch:{ RemoteException -> 0x0124 }
            r0 = 1
            r1 = 0
            if (r13 == 0) goto L_0x00e0
            int r13 = r12.length()     // Catch:{ RemoteException -> 0x0124 }
            if (r13 != 0) goto L_0x0024
            goto L_0x00e0
        L_0x0024:
            if (r10 != 0) goto L_0x002c
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0124 }
            r13.<init>()     // Catch:{ RemoteException -> 0x0124 }
            goto L_0x002d
        L_0x002c:
            r13 = r10
        L_0x002d:
            if (r11 != 0) goto L_0x0035
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0124 }
            r2.<init>()     // Catch:{ RemoteException -> 0x0124 }
            goto L_0x0036
        L_0x0035:
            r2 = r11
        L_0x0036:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0124 }
            r3.<init>()     // Catch:{ RemoteException -> 0x0124 }
            r3.putAll(r13)     // Catch:{ RemoteException -> 0x0124 }
            r3.putAll(r2)     // Catch:{ RemoteException -> 0x0124 }
            java.util.Iterator r13 = r12.keys()     // Catch:{ RemoteException -> 0x0124 }
        L_0x0045:
            boolean r2 = r13.hasNext()     // Catch:{ RemoteException -> 0x0124 }
            if (r2 == 0) goto L_0x00e0
            java.lang.Object r2 = r13.next()     // Catch:{ RemoteException -> 0x0124 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ RemoteException -> 0x0124 }
            org.json.JSONArray r4 = r12.optJSONArray(r2)     // Catch:{ RemoteException -> 0x0124 }
            if (r4 == 0) goto L_0x0045
            java.lang.Object r5 = r3.get(r2)     // Catch:{ RemoteException -> 0x0124 }
            java.lang.ref.WeakReference r5 = (java.lang.ref.WeakReference) r5     // Catch:{ RemoteException -> 0x0124 }
            if (r5 != 0) goto L_0x0062
        L_0x005f:
            r0 = 0
            goto L_0x00e0
        L_0x0062:
            java.lang.Object r5 = r5.get()     // Catch:{ RemoteException -> 0x0124 }
            if (r5 != 0) goto L_0x0069
            goto L_0x005f
        L_0x0069:
            java.lang.Class r5 = r5.getClass()     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzaeq.zzbc     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzaeo r7 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ RemoteException -> 0x0124 }
            boolean r6 = r6.booleanValue()     // Catch:{ RemoteException -> 0x0124 }
            if (r6 == 0) goto L_0x00b3
            java.lang.String r6 = "3010"
            boolean r2 = r2.equals(r6)     // Catch:{ RemoteException -> 0x0124 }
            if (r2 == 0) goto L_0x00b3
            com.google.android.gms.internal.ads.zzaqq r2 = r8.zza     // Catch:{ RemoteException -> 0x0124 }
            r5 = 0
            if (r2 == 0) goto L_0x0093
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzq()     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x00a6
        L_0x0091:
            goto L_0x00ac
        L_0x0093:
            com.google.android.gms.internal.ads.zzaqm r2 = r8.zzk     // Catch:{ RemoteException -> 0x0124 }
            if (r2 == 0) goto L_0x009c
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzw()     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x00a6
        L_0x009c:
            com.google.android.gms.internal.ads.zzaqn r2 = r8.zzl     // Catch:{ RemoteException -> 0x0124 }
            if (r2 == 0) goto L_0x00a5
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzu()     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x00a6
        L_0x00a5:
            r2 = r5
        L_0x00a6:
            if (r2 == 0) goto L_0x00ac
            java.lang.Object r5 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{  }
        L_0x00ac:
            if (r5 != 0) goto L_0x00af
            goto L_0x005f
        L_0x00af:
            java.lang.Class r5 = r5.getClass()     // Catch:{ RemoteException -> 0x0124 }
        L_0x00b3:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0045 }
            r2.<init>()     // Catch:{ JSONException -> 0x0045 }
            com.google.android.gms.ads.internal.util.zzbk.zza(r4, r2)     // Catch:{ JSONException -> 0x0045 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ JSONException -> 0x0045 }
            android.content.Context r4 = r8.zzd     // Catch:{ JSONException -> 0x0045 }
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ JSONException -> 0x0045 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ JSONException -> 0x0045 }
        L_0x00c8:
            boolean r6 = r2.hasNext()     // Catch:{ JSONException -> 0x0045 }
            if (r6 == 0) goto L_0x005f
            java.lang.Object r6 = r2.next()     // Catch:{ JSONException -> 0x0045 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x0045 }
            java.lang.Class r6 = java.lang.Class.forName(r6, r1, r4)     // Catch:{ all -> 0x00c8 }
            boolean r6 = r6.isAssignableFrom(r5)     // Catch:{ all -> 0x00c8 }
            if (r6 == 0) goto L_0x00c8
            goto L_0x0045
        L_0x00e0:
            r8.zzj = r0     // Catch:{ RemoteException -> 0x0124 }
            java.util.HashMap r10 = zzx(r10)     // Catch:{ RemoteException -> 0x0124 }
            java.util.HashMap r11 = zzx(r11)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzaqq r12 = r8.zza     // Catch:{ RemoteException -> 0x0124 }
            if (r12 == 0) goto L_0x00fa
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0124 }
            r12.zzx(r9, r10, r11)     // Catch:{ RemoteException -> 0x0124 }
            return
        L_0x00fa:
            com.google.android.gms.internal.ads.zzaqm r12 = r8.zzk     // Catch:{ RemoteException -> 0x0124 }
            if (r12 == 0) goto L_0x010f
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0124 }
            r12.zzy(r9, r10, r11)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzaqm r10 = r8.zzk     // Catch:{ RemoteException -> 0x0124 }
            r10.zzo(r9)     // Catch:{ RemoteException -> 0x0124 }
            return
        L_0x010f:
            com.google.android.gms.internal.ads.zzaqn r12 = r8.zzl     // Catch:{ RemoteException -> 0x0124 }
            if (r12 == 0) goto L_0x0123
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0124 }
            r12.zzw(r9, r10, r11)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzaqn r10 = r8.zzl     // Catch:{ RemoteException -> 0x0124 }
            r10.zzm(r9)     // Catch:{ RemoteException -> 0x0124 }
        L_0x0123:
            return
        L_0x0124:
            r9 = move-exception
            java.lang.String r10 = "Failed to call trackView"
            com.google.android.gms.internal.ads.zzbbk.zzj(r10, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgu.zza(android.view.View, java.util.Map, java.util.Map, android.view.View$OnTouchListener, android.view.View$OnClickListener):void");
    }

    public final void zzb(View view, Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            zzaqq zzaqq = this.zza;
            if (zzaqq != null) {
                zzaqq.zzy(wrap);
                return;
            }
            zzaqm zzaqm = this.zzk;
            if (zzaqm != null) {
                zzaqm.zzs(wrap);
                return;
            }
            zzaqn zzaqn = this.zzl;
            if (zzaqn != null) {
                zzaqn.zzq(wrap);
            }
        } catch (RemoteException e) {
            zzbbk.zzj("Failed to call untrackView", e);
        }
    }

    public final void zzc(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzi || !this.zze.zzG) {
            zzi(view);
        }
    }

    public final void zzd(String str) {
    }

    public final void zze(Bundle bundle) {
    }

    public final void zzf(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzi) {
            zzbbk.zzi("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zze.zzG) {
            zzbbk.zzi("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        } else {
            zzi(view);
        }
    }

    public final void zzg() {
        this.zzi = true;
    }

    public final boolean zzh() {
        return this.zze.zzG;
    }

    public final void zzj(View view, MotionEvent motionEvent, View view2) {
    }

    public final void zzk(Bundle bundle) {
    }

    public final JSONObject zzl(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    public final void zzm() {
    }

    public final void zzn(View view) {
    }

    public final void zzo(zzaja zzaja) {
    }

    public final void zzp() {
    }

    public final void zzq(zzabt zzabt) {
        zzbbk.zzi("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzr(zzabp zzabp) {
        zzbbk.zzi("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzs() {
        throw null;
    }

    public final void zzt(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            if (!this.zzh) {
                this.zzh = zzs.zzm().zzc(this.zzd, this.zzf.zza, this.zze.zzB.toString(), this.zzg.zzf);
            }
            if (this.zzj) {
                zzaqq zzaqq = this.zza;
                if (zzaqq != null) {
                    if (!zzaqq.zzt()) {
                        this.zza.zzv();
                        this.zzb.zza();
                        return;
                    }
                }
                zzaqm zzaqm = this.zzk;
                if (zzaqm != null) {
                    if (!zzaqm.zzp()) {
                        this.zzk.zzm();
                        this.zzb.zza();
                        return;
                    }
                }
                zzaqn zzaqn = this.zzl;
                if (zzaqn != null && !zzaqn.zzn()) {
                    this.zzl.zzk();
                    this.zzb.zza();
                }
            }
        } catch (RemoteException e) {
            zzbbk.zzj("Failed to call recordImpression", e);
        }
    }

    public final void zzu() {
    }

    public final boolean zzv(Bundle bundle) {
        return false;
    }

    public final void zzw() {
    }
}
