package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzac;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzal;
import com.google.android.gms.internal.ads.zzami;
import com.google.android.gms.internal.ads.zzaq;
import com.google.android.gms.internal.ads.zzar;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbc;
import com.google.android.gms.internal.ads.zzbd;
import com.google.android.gms.internal.ads.zzy;
import com.google.android.gms.internal.ads.zzzy;
import java.io.File;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzao extends zzar {
    private final Context zzc;

    private zzao(Context context, zzaq zzaq) {
        super(zzaq);
        this.zzc = context;
    }

    public static zzaf zzb(Context context) {
        zzaf zzaf = new zzaf(new zzay(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzao(context, new zzbd((zzbc) null, (SSLSocketFactory) null)), 4);
        zzaf.zza();
        return zzaf;
    }

    public final zzy zza(zzac<?> zzac) throws zzal {
        if (zzac.zza() == 0) {
            if (Pattern.matches((String) zzaaa.zzc().zzb(zzaeq.zzcF), zzac.zzh())) {
                zzzy.zza();
                if (zzbbd.zzn(this.zzc, 13400000)) {
                    zzy zza = new zzami(this.zzc).zza(zzac);
                    if (zza != null) {
                        String valueOf = String.valueOf(zzac.zzh());
                        zze.zza(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zza;
                    }
                    String valueOf2 = String.valueOf(zzac.zzh());
                    zze.zza(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zza(zzac);
    }
}
