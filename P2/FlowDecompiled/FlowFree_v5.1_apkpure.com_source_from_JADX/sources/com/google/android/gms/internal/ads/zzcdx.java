package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzbn;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import com.mopub.common.Constants;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcdx implements zzcff {
    private final Context zza;
    private final zzcfi zzb;
    private final JSONObject zzc;
    private final zzcjo zzd;
    private final zzcex zze;
    private final zzfh zzf;
    /* access modifiers changed from: private */
    public final zzbuv zzg;
    /* access modifiers changed from: private */
    public final zzbud zzh;
    private final zzdqo zzi;
    private final zzbbq zzj;
    private final zzdrg zzk;
    private final zzbmv zzl;
    private final zzcfz zzm;
    private final Clock zzn;
    private final zzcax zzo;
    private final zzdwg zzp;
    private boolean zzq = false;
    private boolean zzr;
    private boolean zzs = false;
    private boolean zzt = false;
    private Point zzu = new Point();
    private Point zzv = new Point();
    private long zzw = 0;
    private long zzx = 0;
    private zzabp zzy;

    public zzcdx(Context context, zzcfi zzcfi, JSONObject jSONObject, zzcjo zzcjo, zzcex zzcex, zzfh zzfh, zzbuv zzbuv, zzbud zzbud, zzdqo zzdqo, zzbbq zzbbq, zzdrg zzdrg, zzbmv zzbmv, zzcfz zzcfz, Clock clock, zzcax zzcax, zzdwg zzdwg) {
        this.zza = context;
        this.zzb = zzcfi;
        this.zzc = jSONObject;
        this.zzd = zzcjo;
        this.zze = zzcex;
        this.zzf = zzfh;
        this.zzg = zzbuv;
        this.zzh = zzbud;
        this.zzi = zzdqo;
        this.zzj = zzbbq;
        this.zzk = zzdrg;
        this.zzl = zzbmv;
        this.zzm = zzcfz;
        this.zzn = clock;
        this.zzo = zzcax;
        this.zzp = zzdwg;
    }

    private final String zzA(View view, Map<String, WeakReference<View>> map) {
        if (!(map == null || view == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (view.equals((View) ((WeakReference) next.getValue()).get())) {
                    return (String) next.getKey();
                }
            }
        }
        int zzt2 = this.zze.zzt();
        if (zzt2 == 1) {
            return "1099";
        }
        if (zzt2 == 2) {
            return "2099";
        }
        if (zzt2 != 6) {
            return null;
        }
        return "3099";
    }

    private final boolean zzB() {
        return this.zzc.optBoolean("allow_custom_click_gesture", false);
    }

    private final boolean zzC(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, boolean z) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzc);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbS)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            Context context = this.zza;
            JSONObject jSONObject7 = new JSONObject();
            zzs.zzc();
            DisplayMetrics zzy2 = zzr.zzy((WindowManager) context.getSystemService("window"));
            try {
                jSONObject7.put("width", zzzy.zza().zza(context, zzy2.widthPixels));
                jSONObject7.put("height", zzzy.zza().zza(context, zzy2.heightPixels));
            } catch (JSONException unused) {
                jSONObject7 = null;
            }
            jSONObject6.put("screen", jSONObject7);
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfC)).booleanValue()) {
                this.zzd.zzd("/clickRecorded", new zzcdv(this, (zzcdt) null));
            } else {
                this.zzd.zzd("/logScionEvent", new zzcdu(this, (zzcdt) null));
            }
            this.zzd.zzd("/nativeImpression", new zzcdw(this, (zzcdt) null));
            zzbbz.zza(this.zzd.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzq) {
                return true;
            }
            this.zzq = zzs.zzm().zzc(this.zza, this.zzj.zza, this.zzi.zzB.toString(), this.zzk.zzf);
            return true;
        } catch (JSONException e) {
            zzbbk.zzg("Unable to create impression JSON.", e);
            return false;
        }
    }

    private final boolean zzz(String str) {
        JSONObject optJSONObject = this.zzc.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null || !optJSONObject.optBoolean(str, false)) {
            return false;
        }
        return true;
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzu = new Point();
        this.zzv = new Point();
        if (!this.zzr) {
            this.zzo.zza(view);
            this.zzr = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzl.zzi(this);
        boolean zza2 = zzbn.zza(this.zzj.zzc);
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    if (zza2) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, WeakReference<View>> value2 : map2.entrySet()) {
                View view3 = (View) ((WeakReference) value2.getValue()).get();
                if (view3 != null) {
                    if (zza2) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    public final void zzb(View view, Map<String, WeakReference<View>> map) {
        this.zzu = new Point();
        this.zzv = new Point();
        this.zzo.zzb(view);
        this.zzr = false;
    }

    public final void zzc(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        View view3 = view2;
        Map<String, WeakReference<View>> map3 = map;
        JSONObject zze2 = zzbn.zze(this.zza, map, map2, view2);
        JSONObject zzb2 = zzbn.zzb(this.zza, view2);
        JSONObject zzc2 = zzbn.zzc(view2);
        JSONObject zzd2 = zzbn.zzd(this.zza, view2);
        View view4 = view;
        String zzA = zzA(view, map);
        zzi(true == ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbT)).booleanValue() ? view3 : view4, zzb2, zze2, zzc2, zzd2, zzA, zzbn.zzf(zzA, this.zza, this.zzv, this.zzu), (JSONObject) null, z, false);
    }

    public final void zzd(String str) {
        zzi((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, (JSONObject) null, (JSONObject) null, false, false);
    }

    public final void zze(Bundle bundle) {
        if (bundle == null) {
            zzbbk.zzd("Click data is null. No click is reported.");
        } else if (!zzz("click_reporting")) {
            zzbbk.zzf("The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zzi((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, bundle2 != null ? bundle2.getString("asset_id") : null, (JSONObject) null, zzs.zzc().zzg(bundle, (JSONObject) null), false, false);
        }
    }

    public final void zzf(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        View view2 = view;
        Map<String, WeakReference<View>> map3 = map;
        if (!this.zzt) {
            zzbbk.zzd("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!zzB()) {
            zzbbk.zzd("Custom click reporting failed. Ad unit id not in the allow list.");
        } else {
            Map<String, WeakReference<View>> map4 = map2;
            JSONObject zze2 = zzbn.zze(this.zza, map, map2, view);
            JSONObject zzb2 = zzbn.zzb(this.zza, view);
            JSONObject zzc2 = zzbn.zzc(view);
            JSONObject zzd2 = zzbn.zzd(this.zza, view);
            String zzA = zzA((View) null, map);
            zzi(view, zzb2, zze2, zzc2, zzd2, zzA, zzbn.zzf(zzA, this.zza, this.zzv, this.zzu), (JSONObject) null, z, true);
        }
    }

    public final void zzg() {
        this.zzt = true;
    }

    public final boolean zzh() {
        return zzB();
    }

    /* access modifiers changed from: protected */
    public final void zzi(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        String str2;
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzc);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            boolean z3 = false;
            jSONObject7.put("has_custom_click_handler", this.zzb.zzg(this.zze.zzN()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zze.zzt());
            jSONObject8.put("view_aware_api_used", z);
            zzagy zzagy = this.zzk.zzi;
            jSONObject8.put("custom_mute_requested", zzagy != null && zzagy.zzg);
            jSONObject8.put("custom_mute_enabled", !this.zze.zzA().isEmpty() && this.zze.zzB() != null);
            if (this.zzm.zzb() != null && this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzn.currentTimeMillis());
            if (this.zzt && zzB()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.zzb.zzg(this.zze.zzN()) != null) {
                z3 = true;
            }
            jSONObject8.put("has_custom_click_handler", z3);
            try {
                JSONObject optJSONObject = this.zzc.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                str2 = this.zzf.zzb().zzi(this.zza, optJSONObject.optString("click_string"), view);
            } catch (Exception e) {
                zzbbk.zzg("Exception obtaining click signals", e);
                str2 = null;
            }
            jSONObject8.put("click_signals", str2);
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcM)).booleanValue()) {
                jSONObject8.put("open_chrome_custom_tab", true);
            }
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfG)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("try_fallback_for_deep_link", true);
            }
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfH)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("in_app_link_handling_for_android_11_enabled", true);
            }
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzn.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzw);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzx);
            jSONObject7.put("touch_signal", jSONObject9);
            zzbbz.zza(this.zzd.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e2) {
            zzbbk.zzg("Unable to create click JSON.", e2);
        }
    }

    public final void zzj(View view, MotionEvent motionEvent, View view2) {
        this.zzu = zzbn.zzh(motionEvent, view2);
        long currentTimeMillis = this.zzn.currentTimeMillis();
        this.zzx = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzw = currentTimeMillis;
            this.zzv = this.zzu;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        Point point = this.zzu;
        obtain.setLocation((float) point.x, (float) point.y);
        this.zzf.zzd(obtain);
        obtain.recycle();
    }

    public final void zzk(Bundle bundle) {
        if (bundle == null) {
            zzbbk.zzd("Touch event data is null. No touch event is reported.");
        } else if (!zzz("touch_reporting")) {
            zzbbk.zzf("The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
        } else {
            float f = bundle.getFloat("x");
            float f2 = bundle.getFloat("y");
            this.zzf.zzb().zzg((int) f, (int) f2, bundle.getInt(Constants.VAST_DURATION_MS));
        }
    }

    public final JSONObject zzl(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        JSONObject zze2 = zzbn.zze(this.zza, map, map2, view);
        JSONObject zzb2 = zzbn.zzb(this.zza, view);
        JSONObject zzc2 = zzbn.zzc(view);
        JSONObject zzd2 = zzbn.zzd(this.zza, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", zze2);
            jSONObject.put("ad_view_signal", zzb2);
            jSONObject.put("scroll_view_signal", zzc2);
            jSONObject.put("lock_screen_signal", zzd2);
            return jSONObject;
        } catch (JSONException e) {
            zzbbk.zzg("Unable to create native ad view signals JSON.", e);
            return null;
        }
    }

    public final void zzm() {
        zzC((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, (JSONObject) null, false);
    }

    public final void zzn(View view) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzbbk.zzi("setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzcfz zzcfz = this.zzm;
        if (view != null) {
            view.setOnClickListener(zzcfz);
            view.setClickable(true);
            zzcfz.zzc = new WeakReference<>(view);
        }
    }

    public final void zzo(zzaja zzaja) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzbbk.zzi("setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzm.zza(zzaja);
        }
    }

    public final void zzp() {
        if (this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzm.zzc();
        }
    }

    public final void zzr(zzabp zzabp) {
        this.zzy = zzabp;
    }

    public final void zzs() {
        try {
            zzabp zzabp = this.zzy;
            if (zzabp != null) {
                zzabp.zze();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzt(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        String str;
        JSONObject zze2 = zzbn.zze(this.zza, map, map2, view);
        JSONObject zzb2 = zzbn.zzb(this.zza, view);
        JSONObject zzc2 = zzbn.zzc(view);
        JSONObject zzd2 = zzbn.zzd(this.zza, view);
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbS)).booleanValue()) {
            try {
                str = this.zzf.zzb().zzk(this.zza, view, (Activity) null);
            } catch (Exception unused) {
                zzbbk.zzf("Exception getting data.");
            }
            zzC(zzb2, zze2, zzc2, zzd2, str, (JSONObject) null, zzbn.zzi(this.zza, this.zzi));
        }
        str = null;
        zzC(zzb2, zze2, zzc2, zzd2, str, (JSONObject) null, zzbn.zzi(this.zza, this.zzi));
    }

    public final void zzu() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzc);
            zzbbz.zza(this.zzd.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzbbk.zzg("", e);
        }
    }

    public final boolean zzv(Bundle bundle) {
        if (!zzz("impression_reporting")) {
            zzbbk.zzf("The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
            return false;
        }
        return zzC((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, zzs.zzc().zzg(bundle, (JSONObject) null), false);
    }

    public final void zzw() {
        this.zzd.zzb();
    }

    public final void zzq(zzabt zzabt) {
        try {
            if (!this.zzs) {
                if (zzabt == null) {
                    if (this.zze.zzB() != null) {
                        this.zzs = true;
                        this.zzp.zzb(this.zze.zzB().zzf());
                        zzs();
                        return;
                    }
                }
                this.zzs = true;
                this.zzp.zzb(zzabt.zzf());
                zzs();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
