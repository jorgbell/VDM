package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzbh extends zzac<String> {
    private final Object zza = new Object();
    private final zzah<String> zzb;

    public zzbh(int i, String str, zzah<String> zzah, zzag zzag) {
        super(i, str, zzag);
        this.zzb = zzah;
    }

    /* access modifiers changed from: protected */
    public final zzai<String> zzr(zzy zzy) {
        String str;
        try {
            byte[] bArr = zzy.zzb;
            Map<String, String> map = zzy.zzc;
            String str2 = "ISO-8859-1";
            if (map != null) {
                String str3 = map.get("Content-Type");
                if (str3 != null) {
                    String[] split = str3.split(";", 0);
                    int i = 1;
                    while (true) {
                        if (i >= split.length) {
                            break;
                        }
                        String[] split2 = split[i].trim().split("=", 0);
                        if (split2.length == 2 && split2[0].equals("charset")) {
                            str2 = split2[1];
                            break;
                        }
                        i++;
                    }
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzy.zzb);
        }
        return zzai.zza(str, zzaz.zza(zzy));
    }

    /* access modifiers changed from: protected */
    public void zzz(String str) {
        zzah<String> zzah;
        synchronized (this.zza) {
            zzah = this.zzb;
        }
        zzah.zza(str);
    }
}
