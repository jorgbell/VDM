package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcgd implements zzakp {
    private final zzcgh zza;

    zzcgd(zzcgh zzcgh) {
        this.zza = zzcgh;
    }

    public final void zza(Object obj, Map map) {
        zzbgf zzbgf = (zzbgf) obj;
        zzbgf.zzR().zzw(new zzcgg(this.zza, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzbgf.loadData(str, "text/html", "UTF-8");
        } else {
            zzbgf.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        }
    }
}
