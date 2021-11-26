package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzs;
import com.mopub.common.AdType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbmc implements zzblr {
    private final CookieManager zza;

    public zzbmc(Context context) {
        this.zza = zzs.zze().zzk(context);
    }

    public final void zza(Map<String, String> map) {
        if (this.zza != null) {
            if (map.get(AdType.CLEAR) != null) {
                String str = (String) zzaaa.zzc().zzb(zzaeq.zzaz);
                String cookie = this.zza.getCookie(str);
                if (cookie != null) {
                    List<String> zzc = zzecq.zza(zzeby.zzb(';')).zzc(cookie);
                    int i = 0;
                    while (i < zzc.size()) {
                        CookieManager cookieManager = this.zza;
                        Iterator<String> it = zzecq.zza(zzeby.zzb('=')).zzb(zzc.get(i)).iterator();
                        Objects.requireNonNull(it);
                        if (it.hasNext()) {
                            String valueOf = String.valueOf(it.next());
                            String valueOf2 = String.valueOf((String) zzaaa.zzc().zzb(zzaeq.zzaq));
                            cookieManager.setCookie(str, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                            i++;
                        } else {
                            StringBuilder sb = new StringBuilder(91);
                            sb.append("position (0) must be less than the number of elements that remained (");
                            sb.append(0);
                            sb.append(")");
                            throw new IndexOutOfBoundsException(sb.toString());
                        }
                    }
                    return;
                }
                return;
            }
            String str2 = map.get("cookie");
            if (!TextUtils.isEmpty(str2)) {
                this.zza.setCookie((String) zzaaa.zzc().zzb(zzaeq.zzaz), str2);
            }
        }
    }
}
