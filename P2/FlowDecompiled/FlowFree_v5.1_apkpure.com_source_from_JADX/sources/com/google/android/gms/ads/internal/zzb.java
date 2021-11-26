package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.internal.ads.zzavq;
import com.google.android.gms.internal.ads.zzayr;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzayr zzc;
    private final zzavq zzd = new zzavq(false, Collections.emptyList());

    public zzb(Context context, zzayr zzayr, zzavq zzavq) {
        this.zza = context;
        this.zzc = zzayr;
    }

    private final boolean zzd() {
        zzayr zzayr = this.zzc;
        return (zzayr != null && zzayr.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final boolean zzb() {
        return !zzd() || this.zzb;
    }

    public final void zzc(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzayr zzayr = this.zzc;
            if (zzayr != null) {
                zzayr.zze(str, (Map<String, String>) null, 3);
                return;
            }
            zzavq zzavq = this.zzd;
            if (zzavq.zza && (list = zzavq.zzb) != null) {
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        String replace = next.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzs.zzc();
                        zzr.zzL(this.zza, "", replace);
                    }
                }
            }
        }
    }
}
