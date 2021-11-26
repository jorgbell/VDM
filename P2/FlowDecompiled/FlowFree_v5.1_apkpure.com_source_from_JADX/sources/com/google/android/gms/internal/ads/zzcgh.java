package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcgh {
    private final zzckt zza;
    private final zzcjo zzb;
    private final zzbnf zzc;
    private final zzcff zzd;

    public zzcgh(zzckt zzckt, zzcjo zzcjo, zzbnf zzbnf, zzcff zzcff) {
        this.zza = zzckt;
        this.zzb = zzcjo;
        this.zzc = zzbnf;
        this.zzd = zzcff;
    }

    public final View zza() throws zzbgq {
        zzbgf zza2 = this.zza.zza(zzyx.zzb(), (zzdqo) null, (zzdqr) null);
        View view = (View) zza2;
        view.setVisibility(8);
        zza2.zzab("/sendMessageToSdk", new zzcgb(this));
        zza2.zzab("/adMuted", new zzcgc(this));
        this.zzb.zzh(new WeakReference(zza2), "/loadHtml", new zzcgd(this));
        this.zzb.zzh(new WeakReference(zza2), "/showOverlay", new zzcge(this));
        this.zzb.zzh(new WeakReference(zza2), "/hideOverlay", new zzcgf(this));
        return view;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbgf zzbgf, Map map) {
        zzbbk.zzh("Hiding native ads overlay.");
        zzbgf.zzH().setVisibility(8);
        this.zzc.zze(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbgf zzbgf, Map map) {
        zzbbk.zzh("Showing native ads overlay.");
        zzbgf.zzH().setVisibility(0);
        this.zzc.zze(true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzf("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbgf zzbgf, Map map) {
        this.zzd.zzs();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzbgf zzbgf, Map map) {
        this.zzb.zzf("sendMessageToNativeJs", map);
    }
}
