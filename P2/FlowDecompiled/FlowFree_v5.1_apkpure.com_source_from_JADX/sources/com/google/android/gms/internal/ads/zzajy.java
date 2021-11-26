package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzajy implements zzecb {
    private final String zza;

    zzajy(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        String str2 = (String) obj;
        zzakp<zzbgf> zzakp = zzako.zza;
        if (str2 != null) {
            if (zzagc.zze.zze().booleanValue()) {
                String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                String host = Uri.parse(str).getHost();
                int i = 0;
                while (true) {
                    if (i < 3) {
                        if (host.endsWith(strArr[i])) {
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
            String zze = zzagc.zza.zze();
            String zze2 = zzagc.zzb.zze();
            if (!TextUtils.isEmpty(zze)) {
                str = str.replace(zze, str2);
            }
            if (!TextUtils.isEmpty(zze2)) {
                Uri parse = Uri.parse(str);
                if (TextUtils.isEmpty(parse.getQueryParameter(zze2))) {
                    return parse.buildUpon().appendQueryParameter(zze2, str2).toString();
                }
            }
        }
        return str;
    }
}
