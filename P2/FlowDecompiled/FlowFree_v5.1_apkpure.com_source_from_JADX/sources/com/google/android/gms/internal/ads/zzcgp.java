package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzbn;
import com.google.android.gms.ads.internal.zzb;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcgp {
    private final zzckt zza;
    private final zzcjo zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzcgp(zzckt zzckt, zzcjo zzcjo) {
        this.zza = zzckt;
        this.zzb = zzcjo;
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzzy.zza();
        return zzbbd.zzs(context, i);
    }

    public final View zza(View view, WindowManager windowManager) throws zzbgq {
        zzbgf zza2 = this.zza.zza(zzyx.zzb(), (zzdqo) null, (zzdqr) null);
        View view2 = (View) zza2;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zza2.zzab("/sendMessageToSdk", new zzcgj(this));
        zza2.zzab("/hideValidatorOverlay", new zzcgk(this, windowManager, view));
        zza2.zzab("/open", new zzala((zzb) null, (zzate) null, (zzcvk) null, (zzcni) null, (zzdvo) null));
        this.zzb.zzh(new WeakReference(zza2), "/loadNativeAdPolicyViolations", new zzcgl(this, view, windowManager));
        this.zzb.zzh(new WeakReference(zza2), "/showValidatorOverlay", zzcgm.zza);
        return view2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(View view, WindowManager windowManager, zzbgf zzbgf, Map map) {
        int i;
        zzbgf.zzR().zzw(new zzcgo(this, map));
        if (map != null) {
            Context context = view.getContext();
            int zzf = zzf(context, (String) map.get("validator_width"), ((Integer) zzaaa.zzc().zzb(zzaeq.zzfk)).intValue());
            int zzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) zzaaa.zzc().zzb(zzaeq.zzfl)).intValue());
            int zzf3 = zzf(context, (String) map.get("validator_x"), 0);
            int zzf4 = zzf(context, (String) map.get("validator_y"), 0);
            zzbgf.zzaf(zzbhv.zzc(zzf, zzf2));
            try {
                zzbgf.zzG().getSettings().setUseWideViewPort(((Boolean) zzaaa.zzc().zzb(zzaeq.zzfm)).booleanValue());
                zzbgf.zzG().getSettings().setLoadWithOverviewMode(((Boolean) zzaaa.zzc().zzb(zzaeq.zzfn)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzj = zzbn.zzj();
            zzj.x = zzf3;
            zzj.y = zzf4;
            windowManager.updateViewLayout(zzbgf.zzH(), zzj);
            String str = (String) map.get(AdUnitActivity.EXTRA_ORIENTATION);
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                if ("1".equals(str) || "2".equals(str)) {
                    i = rect.bottom;
                } else {
                    i = rect.top;
                }
                this.zzc = new zzcgn(view, zzbgf, str, zzj, i - zzf4, windowManager);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzc);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzbgf.loadUrl(str2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzf("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(WindowManager windowManager, View view, zzbgf zzbgf, Map map) {
        zzbbk.zzd("Hide native ad policy validator overlay.");
        zzbgf.zzH().setVisibility(8);
        if (zzbgf.zzH().getWindowToken() != null) {
            windowManager.removeView(zzbgf.zzH());
        }
        zzbgf.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzc);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbgf zzbgf, Map map) {
        this.zzb.zzf("sendMessageToNativeJs", map);
    }
}
