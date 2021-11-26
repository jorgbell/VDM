package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzdxq {
    private zzdyo zza = new zzdyo((WebView) null);
    private long zzb;
    private int zzc;

    public zzdxq() {
        zzk();
    }

    public void zza() {
    }

    public void zzb() {
        this.zza.clear();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(WebView webView) {
        this.zza = new zzdyo(webView);
    }

    public final WebView zzd() {
        return (WebView) this.zza.get();
    }

    public final boolean zze() {
        return this.zza.get() != null;
    }

    public final void zzf(String str, long j) {
        if (j >= this.zzb) {
            this.zzc = 2;
            zzdxj.zza().zze(zzd(), str);
        }
    }

    public final void zzg(String str, long j) {
        if (j >= this.zzb && this.zzc != 3) {
            this.zzc = 3;
            zzdxj.zza().zze(zzd(), str);
        }
    }

    public void zzh(zzdws zzdws, zzdwq zzdwq) {
        zzi(zzdws, zzdwq, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public final void zzi(zzdws zzdws, zzdwq zzdwq, JSONObject jSONObject) {
        String zzi = zzdws.zzi();
        JSONObject jSONObject2 = new JSONObject();
        zzdxu.zzc(jSONObject2, "environment", "app");
        zzdxu.zzc(jSONObject2, "adSessionType", zzdwq.zzj());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("; ");
        sb.append(str2);
        zzdxu.zzc(jSONObject3, "deviceType", sb.toString());
        zzdxu.zzc(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzdxu.zzc(jSONObject3, "os", "Android");
        zzdxu.zzc(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzdxu.zzc(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzdxu.zzc(jSONObject4, "partnerName", zzdwq.zzd().zzb());
        zzdxu.zzc(jSONObject4, "partnerVersion", zzdwq.zzd().zzc());
        zzdxu.zzc(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzdxu.zzc(jSONObject5, "libraryVersion", "1.3.3-google_20200416");
        zzdxu.zzc(jSONObject5, "appId", zzdxh.zza().zzb().getApplicationContext().getPackageName());
        zzdxu.zzc(jSONObject2, "app", jSONObject5);
        if (zzdwq.zzh() != null) {
            zzdxu.zzc(jSONObject2, "contentUrl", zzdwq.zzh());
        }
        zzdxu.zzc(jSONObject2, "customReferenceData", zzdwq.zzi());
        JSONObject jSONObject6 = new JSONObject();
        Iterator<zzdwy> it = zzdwq.zze().iterator();
        if (!it.hasNext()) {
            zzdxj.zza().zzc(zzd(), zzi, jSONObject2, jSONObject6, jSONObject);
        } else {
            zzdwy next = it.next();
            throw null;
        }
    }

    public final void zzj(float f) {
        zzdxj.zza().zzf(zzd(), f);
    }

    public final void zzk() {
        this.zzb = System.nanoTime();
        this.zzc = 1;
    }
}
