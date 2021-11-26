package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.zza;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcxb implements zzcwe<zzbom, zzdrx, zzcxs> {
    private final Context zza;
    private final zzbpj zzb;
    private final Executor zzc;

    public zzcxb(Context context, zzbpj zzbpj, Executor executor) {
        this.zza = context;
        this.zzb = zzbpj;
        this.zzc = executor;
    }

    public final void zza(zzdra zzdra, zzdqo zzdqo, zzcvz<zzdrx, zzcxs> zzcvz) throws zzdrl {
        zzyx zzb2;
        zzyx zzyx = zzdra.zza.zza.zze;
        if (zzyx.zzn) {
            zzb2 = new zzyx(this.zza, zza.zzb(zzyx.zze, zzyx.zzb));
        } else {
            if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfb)).booleanValue() || !zzdqo.zzab) {
                zzb2 = zzdrk.zzb(this.zza, zzdqo.zzt);
            } else {
                zzb2 = new zzyx(this.zza, zza.zzc(zzyx.zze, zzyx.zzb));
            }
        }
        zzyx zzyx2 = zzb2;
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfb)).booleanValue() || !zzdqo.zzab) {
            ((zzdrx) zzcvz.zzb).zzg(this.zza, zzyx2, zzdra.zza.zza.zzd, zzdqo.zzu.toString(), zzbk.zzk(zzdqo.zzr), (zzaqh) zzcvz.zzc);
        } else {
            ((zzdrx) zzcvz.zzb).zzb(this.zza, zzyx2, zzdra.zza.zza.zzd, zzdqo.zzu.toString(), zzbk.zzk(zzdqo.zzr), (zzaqh) zzcvz.zzc);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object zzb(com.google.android.gms.internal.ads.zzdra r7, com.google.android.gms.internal.ads.zzdqo r8, com.google.android.gms.internal.ads.zzcvz r9) throws com.google.android.gms.internal.ads.zzdrl, com.google.android.gms.internal.ads.zzczn {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzfb
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0077
            boolean r0 = r8.zzab
            if (r0 == 0) goto L_0x0077
            AdapterT r0 = r9.zzb
            com.google.android.gms.internal.ads.zzdrx r0 = (com.google.android.gms.internal.ads.zzdrx) r0
            com.google.android.gms.internal.ads.zzaqk r0 = r0.zzc()
            if (r0 == 0) goto L_0x0067
            com.google.android.gms.dynamic.IObjectWrapper r2 = r0.zze()     // Catch:{ RemoteException -> 0x0060 }
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0060 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ RemoteException -> 0x0060 }
            boolean r0 = r0.zzf()     // Catch:{ RemoteException -> 0x0060 }
            if (r2 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x007f
            com.google.android.gms.internal.ads.zzefw r0 = com.google.android.gms.internal.ads.zzefo.zza(r1)
            com.google.android.gms.internal.ads.zzcxa r3 = new com.google.android.gms.internal.ads.zzcxa
            r3.<init>(r6, r2, r8)
            com.google.android.gms.internal.ads.zzefx r2 = com.google.android.gms.internal.ads.zzbbw.zze
            com.google.android.gms.internal.ads.zzefw r0 = com.google.android.gms.internal.ads.zzefo.zzh(r0, r3, r2)
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            r2 = r0
            android.view.View r2 = (android.view.View) r2     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            goto L_0x007f
        L_0x004a:
            r7 = move-exception
            goto L_0x004d
        L_0x004c:
            r7 = move-exception
        L_0x004d:
            com.google.android.gms.internal.ads.zzdrl r8 = new com.google.android.gms.internal.ads.zzdrl
            r8.<init>(r7)
            throw r8
        L_0x0053:
            com.google.android.gms.internal.ads.zzdrl r7 = new com.google.android.gms.internal.ads.zzdrl
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "BannerAdapterWrapper interscrollerView should not be null"
            r8.<init>(r9)
            r7.<init>(r8)
            throw r7
        L_0x0060:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzdrl r8 = new com.google.android.gms.internal.ads.zzdrl
            r8.<init>(r7)
            throw r8
        L_0x0067:
            java.lang.String r7 = "getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."
            com.google.android.gms.internal.ads.zzbbk.zzf(r7)
            com.google.android.gms.internal.ads.zzdrl r8 = new com.google.android.gms.internal.ads.zzdrl
            java.lang.Exception r9 = new java.lang.Exception
            r9.<init>(r7)
            r8.<init>(r9)
            throw r8
        L_0x0077:
            AdapterT r0 = r9.zzb
            com.google.android.gms.internal.ads.zzdrx r0 = (com.google.android.gms.internal.ads.zzdrx) r0
            android.view.View r2 = r0.zza()
        L_0x007f:
            com.google.android.gms.internal.ads.zzbpj r0 = r6.zzb
            com.google.android.gms.internal.ads.zzbra r3 = new com.google.android.gms.internal.ads.zzbra
            java.lang.String r4 = r9.zza
            r3.<init>(r7, r8, r4)
            com.google.android.gms.internal.ads.zzbot r7 = new com.google.android.gms.internal.ads.zzbot
            AdapterT r4 = r9.zzb
            com.google.android.gms.internal.ads.zzdrx r4 = (com.google.android.gms.internal.ads.zzdrx) r4
            com.google.android.gms.internal.ads.zzbqj r4 = com.google.android.gms.internal.ads.zzcwz.zzb(r4)
            java.util.List<com.google.android.gms.internal.ads.zzdqp> r8 = r8.zzt
            r5 = 0
            java.lang.Object r8 = r8.get(r5)
            com.google.android.gms.internal.ads.zzdqp r8 = (com.google.android.gms.internal.ads.zzdqp) r8
            r7.<init>(r2, r1, r4, r8)
            com.google.android.gms.internal.ads.zzbon r7 = r0.zzd(r3, r7)
            com.google.android.gms.internal.ads.zzcax r8 = r7.zzj()
            r8.zza(r2)
            com.google.android.gms.internal.ads.zzbvc r8 = r7.zza()
            com.google.android.gms.internal.ads.zzbmf r0 = new com.google.android.gms.internal.ads.zzbmf
            AdapterT r1 = r9.zzb
            com.google.android.gms.internal.ads.zzdrx r1 = (com.google.android.gms.internal.ads.zzdrx) r1
            r0.<init>(r1)
            java.util.concurrent.Executor r1 = r6.zzc
            r8.zzh(r0, r1)
            ListenerT r8 = r9.zzc
            com.google.android.gms.internal.ads.zzcxs r8 = (com.google.android.gms.internal.ads.zzcxs) r8
            com.google.android.gms.internal.ads.zzdaz r9 = r7.zzf()
            r8.zzc(r9)
            com.google.android.gms.internal.ads.zzbom r7 = r7.zzh()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcxb.zzb(com.google.android.gms.internal.ads.zzdra, com.google.android.gms.internal.ads.zzdqo, com.google.android.gms.internal.ads.zzcvz):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzc(View view, zzdqo zzdqo, Object obj) throws Exception {
        return zzefo.zza(zzbqa.zza(this.zza, view, zzdqo));
    }
}
