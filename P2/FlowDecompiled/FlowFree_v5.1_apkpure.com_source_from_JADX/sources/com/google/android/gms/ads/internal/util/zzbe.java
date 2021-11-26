package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzaq;
import com.google.android.gms.internal.ads.zzbbj;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbj;
import com.google.android.gms.internal.ads.zzefw;
import com.google.android.gms.internal.ads.zzk;
import com.google.android.gms.internal.ads.zzy;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbe {
    private static zzaf zzb;
    private static final Object zzc = new Object();

    public zzbe(Context context) {
        zzaf zzaf;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzc) {
            if (zzb == null) {
                zzaeq.zza(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcE)).booleanValue()) {
                        zzaf = zzao.zzb(context);
                        zzb = zzaf;
                    }
                }
                zzaf = zzbj.zza(context, (zzaq) null);
                zzb = zzaf;
            }
        }
    }

    public final zzefw<zzy> zza(String str) {
        zzbcb zzbcb = new zzbcb();
        zzb.zzb(new zzbd(str, (Map<String, String>) null, zzbcb));
        return zzbcb;
    }

    public final zzefw<String> zzb(int i, String str, Map<String, String> map, byte[] bArr) {
        String str2 = str;
        zzbb zzbb = new zzbb((zzax) null);
        zzay zzay = new zzay(this, str2, zzbb);
        zzbbj zzbbj = new zzbbj((String) null);
        zzaz zzaz = new zzaz(this, i, str, zzbb, zzay, bArr, map, zzbbj);
        if (zzbbj.zzj()) {
            try {
                zzbbj.zzb(str2, "GET", zzaz.zzm(), zzaz.zzn());
            } catch (zzk e) {
                zzbbk.zzi(e.getMessage());
            }
        }
        zzb.zzb(zzaz);
        return zzbb;
    }
}
