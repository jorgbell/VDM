package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zzbn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzauy;
import com.google.android.gms.internal.ads.zzavf;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbaf;
import com.google.android.gms.internal.ads.zzbak;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbid;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzcjo;
import com.google.android.gms.internal.ads.zzdrf;
import com.google.android.gms.internal.ads.zzdry;
import com.google.android.gms.internal.ads.zzeff;
import com.google.android.gms.internal.ads.zzefo;
import com.google.android.gms.internal.ads.zzefw;
import com.google.android.gms.internal.ads.zzefx;
import com.google.android.gms.internal.ads.zzfh;
import com.google.android.gms.internal.ads.zzfi;
import com.google.android.gms.internal.ads.zzys;
import com.google.android.gms.internal.ads.zzyt;
import com.google.android.gms.internal.ads.zzyx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzp extends zzbaf {
    protected static final List<String> zza = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click"}));
    protected static final List<String> zzb = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));
    protected static final List<String> zzc = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion"}));
    protected static final List<String> zzd = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));
    public static final /* synthetic */ int zze = 0;
    private final zzbid zzf;
    private Context zzg;
    private final zzfh zzh;
    /* access modifiers changed from: private */
    public final zzbbq zzi;
    private final zzdry<zzcjo> zzj;
    private final zzefx zzk;
    private final ScheduledExecutorService zzl;
    private zzavf zzm;
    private Point zzn = new Point();
    private Point zzo = new Point();
    private final Set<WebView> zzp = Collections.newSetFromMap(new WeakHashMap());

    public zzp(zzbid zzbid, Context context, zzfh zzfh, zzbbq zzbbq, zzdry<zzcjo> zzdry, zzefx zzefx, ScheduledExecutorService scheduledExecutorService) {
        this.zzf = zzbid;
        this.zzg = context;
        this.zzh = zzfh;
        this.zzi = zzbbq;
        this.zzj = zzdry;
        this.zzk = zzefx;
        this.zzl = scheduledExecutorService;
    }

    static boolean zzc(Uri uri) {
        return zzs(uri, zzc, zzd);
    }

    static final /* synthetic */ Uri zzq(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzv(uri, "nas", str) : uri;
    }

    static final /* synthetic */ ArrayList zzr(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzc(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzv(uri, "nas", str));
            }
        }
        return arrayList;
    }

    private static boolean zzs(Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            for (String contains : list) {
                if (path.contains(contains)) {
                    for (String endsWith : list2) {
                        if (host.endsWith(endsWith)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    private final zzefw<String> zzt(String str) {
        zzcjo[] zzcjoArr = new zzcjo[1];
        zzefw<O> zzh2 = zzefo.zzh(this.zzj.zzb(), new zzk(this, zzcjoArr, str), this.zzk);
        zzh2.zze(new zzl(this, zzcjoArr), this.zzk);
        return zzefo.zze(zzefo.zzi((zzeff) zzefo.zzg(zzeff.zzw(zzh2), (long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzeX)).intValue(), TimeUnit.MILLISECONDS, this.zzl), zzi.zza, this.zzk), Exception.class, zzj.zza, this.zzk);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzu() {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzavf r0 = r1.zzm
            if (r0 == 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzp.zzu():boolean");
    }

    private static final Uri zzv(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + "&" + uri2.substring(i));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzcjo[] zzcjoArr) {
        zzcjo zzcjo = zzcjoArr[0];
        if (zzcjo != null) {
            this.zzj.zzc(zzefo.zza(zzcjo));
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzbak zzbak, zzbad zzbad) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        String str = zzbak.zza;
        String str2 = zzbak.zzb;
        zzyx zzyx = zzbak.zzc;
        zzys zzys = zzbak.zzd;
        zza zzu = this.zzf.zzu();
        zzbtq zzbtq = new zzbtq();
        zzbtq.zza(context);
        zzdrf zzdrf = new zzdrf();
        if (str == null) {
            str = "adUnitId";
        }
        zzdrf.zzf(str);
        if (zzys == null) {
            zzys = new zzyt().zza();
        }
        zzdrf.zza(zzys);
        if (zzyx == null) {
            zzyx = new zzyx();
        }
        zzdrf.zzc(zzyx);
        zzbtq.zzb(zzdrf.zzu());
        zzu.zzc(zzbtq.zzd());
        zzs zzs = new zzs();
        zzs.zza(str2);
        zzu.zzb(new zzt(zzs, (zzr) null));
        new zzbze();
        zzefo.zzo(zzu.zza().zza(), new zzm(this, zzbad), this.zzf.zze());
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        View view;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeW)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzavf zzavf = this.zzm;
            if (zzavf == null) {
                view = null;
            } else {
                view = zzavf.zza;
            }
            this.zzn = zzbn.zzh(motionEvent, view);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            Point point = this.zzn;
            obtain.setLocation((float) point.x, (float) point.y);
            this.zzh.zzd(obtain);
            obtain.recycle();
        }
    }

    public final void zzg(List<Uri> list, IObjectWrapper iObjectWrapper, zzauy zzauy) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzeW)).booleanValue()) {
            try {
                zzauy.zzf("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzbbk.zzg("", e);
            }
        } else {
            zzefw zzb2 = this.zzk.zzb(new zzc(this, list, iObjectWrapper));
            if (zzu()) {
                zzb2 = zzefo.zzh(zzb2, new zzd(this), this.zzk);
            } else {
                zzbbk.zzh("Asset view map is empty.");
            }
            zzefo.zzo(zzb2, new zzn(this, zzauy), this.zzf.zze());
        }
    }

    public final void zzh(List<Uri> list, IObjectWrapper iObjectWrapper, zzauy zzauy) {
        try {
            if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzeW)).booleanValue()) {
                zzauy.zzf("The updating URL feature is not enabled.");
            } else if (list.size() != 1) {
                zzauy.zzf("There should be only 1 click URL.");
            } else {
                Uri uri = list.get(0);
                if (!zzs(uri, zza, zzb)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzbbk.zzi(sb.toString());
                    zzauy.zze(list);
                    return;
                }
                zzefw zzb2 = this.zzk.zzb(new zze(this, uri, iObjectWrapper));
                if (zzu()) {
                    zzb2 = zzefo.zzh(zzb2, new zzf(this), this.zzk);
                } else {
                    zzbbk.zzh("Asset view map is empty.");
                }
                zzefo.zzo(zzb2, new zzo(this, zzauy), this.zzf.zze());
            }
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final void zzi(zzavf zzavf) {
        this.zzm = zzavf;
        this.zzj.zza(1);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzge)).booleanValue()) {
            if (Build.VERSION.SDK_INT < 21) {
                zzbbk.zzi("Not registering the webview because the Android API level is lower than Lollopop which has security risks on webviews.");
                return;
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                zzbbk.zzf("The webView cannot be null.");
            } else if (this.zzp.contains(webView)) {
                zzbbk.zzh("This webview has already been registered.");
            } else {
                this.zzp.add(webView);
                webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView), "gmaSdk");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzk(zzcjo[] zzcjoArr, String str, zzcjo zzcjo) throws Exception {
        zzcjoArr[0] = zzcjo;
        Context context = this.zzg;
        zzavf zzavf = this.zzm;
        Map<String, WeakReference<View>> map = zzavf.zzb;
        JSONObject zze2 = zzbn.zze(context, map, map, zzavf.zza);
        JSONObject zzb2 = zzbn.zzb(this.zzg, this.zzm.zza);
        JSONObject zzc2 = zzbn.zzc(this.zzm.zza);
        JSONObject zzd2 = zzbn.zzd(this.zzg, this.zzm.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zze2);
        jSONObject.put("ad_view_signal", zzb2);
        jSONObject.put("scroll_view_signal", zzc2);
        jSONObject.put("lock_screen_signal", zzd2);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", zzbn.zzf((String) null, this.zzg, this.zzo, this.zzn));
        }
        return zzcjo.zzc(str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzl(Uri uri) throws Exception {
        return zzefo.zzi(zzt("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzh(this, uri), this.zzk);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Uri zzm(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.zzh.zze(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        } catch (zzfi e) {
            zzbbk.zzj("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzn(ArrayList arrayList) throws Exception {
        return zzefo.zzi(zzt("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzg(this, arrayList), this.zzk);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzo(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String zzk2 = this.zzh.zzb() != null ? this.zzh.zzb().zzk(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (!TextUtils.isEmpty(zzk2)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzc(uri)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzbbk.zzi(sb.toString());
                    arrayList.add(uri);
                } else {
                    arrayList.add(zzv(uri, "ms", zzk2));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }
}
