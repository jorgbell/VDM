package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbhi;
import com.google.android.gms.internal.ads.zzug;
import com.google.android.gms.internal.ads.zzvy;
import java.io.InputStream;
import java.util.Map;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzac {
    private zzac() {
    }

    /* synthetic */ zzac(zzt zzt) {
    }

    public static zzac zzt(int i) {
        return i >= 28 ? new zzab() : i >= 26 ? new zzz() : i >= 24 ? new zzy() : i >= 21 ? new zzx() : i >= 19 ? new zzw() : i >= 18 ? new zzv() : i >= 17 ? new zzu() : new zzac();
    }

    public static final boolean zzu() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        zzbr.zza(context, new zzs(context, webSettings));
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }

    public String zzb(Context context) {
        return "";
    }

    public void zzc(Context context) {
    }

    public Drawable zzd(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public int zze(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "wifi_on", 0);
    }

    public int zzf(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "airplane_mode_on", 0);
    }

    public boolean zzg(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public int zzh() {
        return 5;
    }

    public long zzi() {
        return -1;
    }

    public ViewGroup.LayoutParams zzj() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public CookieManager zzk(Context context) {
        if (!zzu()) {
            try {
                CookieSyncManager.createInstance(context);
                return CookieManager.getInstance();
            } catch (Throwable th) {
                zzbbk.zzg("Failed to obtain CookieManager.", th);
                zzs.zzg().zzg(th, "ApiLevelUtil.getCookieManager");
            }
        }
        return null;
    }

    public zzbgm zzl(zzbgf zzbgf, zzug zzug, boolean z) {
        return new zzbhi(zzbgf, zzug, z);
    }

    public int zzm() {
        return 1;
    }

    public WebResourceResponse zzn(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    public boolean zzo(Activity activity, Configuration configuration) {
        return false;
    }

    public zzvy zzq(Context context, TelephonyManager telephonyManager) {
        return zzvy.ENUM_UNKNOWN;
    }

    public void zzr(Activity activity) {
    }
}
