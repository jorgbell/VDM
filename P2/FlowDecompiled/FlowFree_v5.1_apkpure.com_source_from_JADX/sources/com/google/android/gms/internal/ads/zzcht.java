package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzs;
import com.mopub.common.AdType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcht {
    private final Context zza;
    private final zzchf zzb;
    private final zzfh zzc;
    private final zzbbq zzd;
    private final zza zze;
    private final zzug zzf;
    private final Executor zzg;
    private final zzagy zzh;
    private final zzcil zzi;
    private final ScheduledExecutorService zzj;

    public zzcht(Context context, zzchf zzchf, zzfh zzfh, zzbbq zzbbq, zza zza2, zzug zzug, Executor executor, zzdrg zzdrg, zzcil zzcil, ScheduledExecutorService scheduledExecutorService) {
        this.zza = context;
        this.zzb = zzchf;
        this.zzc = zzfh;
        this.zzd = zzbbq;
        this.zze = zza2;
        this.zzf = zzug;
        this.zzg = executor;
        this.zzh = zzdrg.zzi;
        this.zzi = zzcil;
        this.zzj = scheduledExecutorService;
    }

    public static final zzada zzg(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzn(optJSONObject);
    }

    public static final List<zzada> zzh(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzede.zzi();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzede.zzi();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzada zzn = zzn(optJSONArray.optJSONObject(i));
            if (zzn != null) {
                arrayList.add(zzn);
            }
        }
        return zzede.zzm(arrayList);
    }

    private final zzefw<List<zzagu>> zzi(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzefo.zza(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zzj(jSONArray.optJSONObject(i), z));
        }
        return zzefo.zzi(zzefo.zzj(arrayList), zzchl.zza, this.zzg);
    }

    private final zzefw<zzagu> zzj(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzefo.zza(null);
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzefo.zza(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzefo.zza(new zzagu((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzefo.zzi(this.zzb.zza(optString, optDouble, optBoolean), new zzchm(optString, optDouble, optInt, optInt2), this.zzg), (Object) null);
    }

    private static Integer zzk(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static <T> zzefw<T> zzl(zzefw<T> zzefw, T t) {
        return zzefo.zzf(zzefw, Exception.class, new zzchq((Object) null), zzbbw.zzf);
    }

    private static <T> zzefw<T> zzm(boolean z, zzefw<T> zzefw, T t) {
        if (z) {
            return zzefo.zzh(zzefw, new zzchr(zzefw), zzbbw.zzf);
        }
        return zzl(zzefw, (Object) null);
    }

    private static final zzada zzn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzada(optString, optString2);
    }

    public final zzefw<zzagu> zza(JSONObject jSONObject, String str) {
        return zzj(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final zzefw<List<zzagu>> zzb(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        zzagy zzagy = this.zzh;
        return zzi(optJSONArray, zzagy.zzb, zzagy.zzd);
    }

    public final zzefw<zzagr> zzc(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzefo.zza(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zzm(optJSONObject.optBoolean("require"), zzefo.zzi(zzi(optJSONArray, false, true), new zzchn(this, optJSONObject), this.zzg), (Object) null);
    }

    public final zzefw<zzbgf> zzd(JSONObject jSONObject) {
        JSONObject zzh2 = zzbk.zzh(jSONObject, "html_containers", "instream");
        if (zzh2 == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzefo.zza(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzbbk.zzi("Required field 'vast_xml' is missing");
                return zzefo.zza(null);
            }
            return zzl(zzefo.zzg(this.zzi.zza(optJSONObject), (long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzca)).intValue(), TimeUnit.SECONDS, this.zzj), (Object) null);
        }
        zzefw<zzbgf> zzb2 = this.zzi.zzb(zzh2.optString("base_url"), zzh2.optString(AdType.HTML));
        return zzefo.zzh(zzb2, new zzchp(zzb2), zzbbw.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zze(String str, Object obj) throws Exception {
        zzs.zzd();
        zzbgf zza2 = zzbgr.zza(this.zza, zzbhv.zzb(), "native-omid", false, false, this.zzc, (zzafp) null, this.zzd, (zzaff) null, (zzl) null, this.zze, this.zzf, (zzdqo) null, (zzdqr) null);
        zzbca zza3 = zzbca.zza(zza2);
        zza2.zzR().zzw(new zzchs(zza3));
        zza2.loadData(str, "text/html", "UTF-8");
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzagr zzf(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzk = zzk(jSONObject, "bg_color");
        Integer zzk2 = zzk(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzagr(optString, list, zzk, zzk2, num, optInt3 + optInt2, this.zzh.zze, optBoolean);
    }
}
