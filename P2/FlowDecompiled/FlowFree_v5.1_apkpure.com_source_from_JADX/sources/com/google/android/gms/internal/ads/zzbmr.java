package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.zzs;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbmr implements zzaox<zzbmu> {
    private final Context zza;
    private final zzre zzb;
    private final PowerManager zzc;

    public zzbmr(Context context, zzre zzre) {
        this.zza = context;
        this.zzb = zzre;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzb(zzbmu zzbmu) throws JSONException {
        JSONObject jSONObject;
        boolean z;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzrh zzrh = zzbmu.zzf;
        if (zzrh == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzc() != null) {
            boolean z2 = zzrh.zza;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.zzb.zzb()).put("activeViewJSON", this.zzb.zzc()).put("timestamp", zzbmu.zzd).put("adFormat", this.zzb.zza()).put("hashCode", this.zzb.zzd()).put("isMraid", false);
            boolean z3 = zzbmu.zzc;
            JSONObject put2 = put.put("isStopped", false).put("isPaused", zzbmu.zzb).put("isNative", this.zzb.zze());
            if (Build.VERSION.SDK_INT >= 20) {
                z = this.zzc.isInteractive();
            } else {
                z = this.zzc.isScreenOn();
            }
            put2.put("isScreenOn", z).put("appMuted", zzs.zzh().zzd()).put("appVolume", (double) zzs.zzh().zzb()).put("deviceVolume", (double) zzad.zze(this.zza.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzrh.zzb).put("isAttachedToWindow", z2).put("viewBox", new JSONObject().put("top", zzrh.zzc.top).put("bottom", zzrh.zzc.bottom).put("left", zzrh.zzc.left).put("right", zzrh.zzc.right)).put("adBox", new JSONObject().put("top", zzrh.zzd.top).put("bottom", zzrh.zzd.bottom).put("left", zzrh.zzd.left).put("right", zzrh.zzd.right)).put("globalVisibleBox", new JSONObject().put("top", zzrh.zze.top).put("bottom", zzrh.zze.bottom).put("left", zzrh.zze.left).put("right", zzrh.zze.right)).put("globalVisibleBoxVisible", zzrh.zzf).put("localVisibleBox", new JSONObject().put("top", zzrh.zzg.top).put("bottom", zzrh.zzg.bottom).put("left", zzrh.zzg.left).put("right", zzrh.zzg.right)).put("localVisibleBoxVisible", zzrh.zzh).put("hitBox", new JSONObject().put("top", zzrh.zzi.top).put("bottom", zzrh.zzi.bottom).put("left", zzrh.zzi.left).put("right", zzrh.zzi.right)).put("screenDensity", (double) this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzbmu.zza);
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzaT)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzrh.zzk;
                if (list != null) {
                    for (Rect next : list) {
                        jSONArray2.put(new JSONObject().put("top", next.top).put("bottom", next.bottom).put("left", next.left).put("right", next.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbmu.zze)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
