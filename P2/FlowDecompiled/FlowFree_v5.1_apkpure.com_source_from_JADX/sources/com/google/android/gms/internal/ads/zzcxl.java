package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcxl implements zzcvw<zzcbs> {
    private final Context zza;
    private final zzccp zzb;
    private final Executor zzc;
    private final zzdqn zzd;

    public zzcxl(Context context, Executor executor, zzccp zzccp, zzdqn zzdqn) {
        this.zza = context;
        this.zzb = zzccp;
        this.zzc = executor;
        this.zzd = zzdqn;
    }

    private static String zzd(zzdqo zzdqo) {
        try {
            return zzdqo.zzu.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean zza(zzdra zzdra, zzdqo zzdqo) {
        return (this.zza instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzafo.zza(this.zza) && !TextUtils.isEmpty(zzd(zzdqo));
    }

    public final zzefw<zzcbs> zzb(zzdra zzdra, zzdqo zzdqo) {
        String zzd2 = zzd(zzdqo);
        return zzefo.zzh(zzefo.zza(null), new zzcxj(this, zzd2 != null ? Uri.parse(zzd2) : null, zzdra, zzdqo), this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzc(Uri uri, zzdra zzdra, zzdqo zzdqo, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzc zzc2 = new zzc(build.intent, (zzu) null);
            zzbcb zzbcb = new zzbcb();
            zzcbt zzc3 = this.zzb.zzc(new zzbra(zzdra, zzdqo, (String) null), new zzcbw(new zzcxk(zzbcb), (zzbgf) null));
            zzbcb.zzc(new AdOverlayInfoParcel(zzc2, (zzyi) null, zzc3.zzi(), (zzw) null, new zzbbq(0, 0, false, false, false), (zzbgf) null));
            this.zzd.zzd();
            return zzefo.zza(zzc3.zzh());
        } catch (Throwable th) {
            zzbbk.zzg("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
